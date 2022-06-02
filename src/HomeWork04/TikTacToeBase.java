package HomeWork04;

import java.util.Random;
import java.util.Scanner;

public class TikTacToeBase {

    public static final String SPACE_MAP = " ";
    private static final int SIZE = 4;
    private static final char DOT_EMP = '.';
    private static final char DOT_Hum = 'X';
    private static final char AI = '0';
    private static final String HEADER_FIR_SYM = "*";
    private static final char[][] MAP = new char[SIZE][SIZE];
    private static int turnCount=0;

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMAP();
        printMap();
        playGame();
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
        if (checkWin(symbol)){
            if (symbol == DOT_Hum){
                System.out.println("Вы победили");
            } else {
                System.out.println("Восстание близко");
            }
            return true;

        }
        if (checkDraw()){
            System.out.println("Ничья");
            return true;

        }

        return false;
    }

    private static boolean checkDraw() {
//        for (char[] chars : MAP) {
//            for (char symbol : chars) {
//                if (symbol == DOT_EMP) {
//                    return false;
//                }
//
//            }
//        }
//        return false;
        return turnCount >= SIZE* SIZE;
    }

    private static boolean checkWin(char symbol) {
        if(MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) return true;
        if(MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) return true;
        if(MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) return true;
        if(MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) return true;
        if(MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[2][0] == symbol && MAP[1][1] == symbol && MAP[0][2] == symbol) return true;
        return false;
    }


    private static void humanTurn() {
        System.out.println("ход Человека");
        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.println("Введите координату");
            rowNumber = in.nextInt() - 1;

            System.out.println("Введите координату");
            columnNumber = in.nextInt() - 1;

            if (isaCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ячейка с координатами: %d:%d уже занята%n%n", rowNumber +
                    1, columnNumber + 1);
        }

        MAP[rowNumber][columnNumber] = DOT_Hum;
        turnCount++;
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
        } while (!isaCellFree(rowNumber,columnNumber));

        MAP[rowNumber][columnNumber] = AI;
        turnCount++;

    }

    }

