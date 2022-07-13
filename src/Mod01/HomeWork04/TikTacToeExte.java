package Mod01.HomeWork04;

import java.util.Random;
import java.util.Scanner;

public class TikTacToeExte {
    private static final String SPACE_MAP = " ";
    private static final int SIZE = 9;
    private static final char DOT_EMP = '.';
    private static final char DOT_Hum = 'X';
    private static final char AI = '0';
    private static final String HEADER_FIR_SYM = "*";
    private static final char[][] MAP = new char[SIZE][SIZE];
    private static int columnNumber;
    private static int rowNumber;
    private static int turnCount = 0;
    private static final int victoryToken = 3;

    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();


    public static void turnGame() {
        do {

            System.out.println("Игра начинается");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private static void endGame() {
        in.close();
        System.out.println("Ты заходи, если что");
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "yes", "+", "да", "д" -> true;
            default -> false;
        };
    }

    private static void init() {
        turnCount = 0;
        initMAP();
    }


    private static void initMAP() {
        for (int i = 0; i < SIZE; i++) {
            for (int i1 = 0; i1 < SIZE; i1++) {
                MAP[i][i1] = DOT_EMP;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapBody();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIR_SYM + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMApNum(i);
        }
        System.out.println();
    }

    private static void printMapBody() {
        for (int i = 0; i < SIZE; i++) {
            printMApNum(i);
            for (int i1 = 0; i1 < SIZE; i1++) {
                System.out.print(MAP[i][i1] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void printMApNum(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (ckeckEnd(DOT_Hum)) {
                break;
            }

            aiTurn();
            printMap();
            if (ckeckEnd(AI)) {
                break;
            }
        }

    }

    private static boolean ckeckEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_Hum) {
                System.out.println("Вы победили");
            } else {
                System.out.println("Восстание близко");
            }
            return true;

        }
        if (checkDraw()) {
            System.out.println("Ничья");
            return true;

        }

        return false;
    }

    private static boolean checkDraw() {

        return turnCount >= SIZE * SIZE;
    }

    private static boolean checkWin(char symbol) {


        if (checkX() || checkY()) {
            return true;
        }
        return false;

    }

    private static boolean checkY() {
        int count = victoryToken;
        char c = MAP[rowNumber][columnNumber];
        for (int i = 0; i < MAP.length; i++) {
            if (c == MAP[i][columnNumber]) {
                count--;

            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkX() {
        int count = victoryToken;
        char c = MAP[rowNumber][columnNumber];
        for (int i = 0; i < MAP.length; i++) {
            if (c == MAP[rowNumber][i]) {
                count--;

            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void humanTurn() {
        System.out.println("ход Человека");


        while (true) {
            System.out.println("Введите координату");
            rowNumber = getValidNumberFromScanner() - 1;

            System.out.println("Введите координату");
            columnNumber = getValidNumberFromScanner() - 1;

            if (isaCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ячейка с координатами: %d:%d уже занята%n%n", rowNumber +
                    1, columnNumber + 1);
        }

        MAP[rowNumber][columnNumber] = DOT_Hum;
        turnCount++;
    }

    private static int getValidNumberFromScanner() {
        while (true) {
            if (in.hasNext()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                } else {
                    System.out.println("Проверьте значение координаты должно быть от 1 до " + SIZE);
                }
            } else {
                System.out.println("!!!!Вводи допускает лишь целые числа");
                in.next();
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static boolean isaCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMP;
    }

    private static void aiTurn() {
        System.out.println("ход Компьютера");
        int rowNumber;
        int columnNumber;
        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isaCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = AI;
        turnCount++;

    }

}

