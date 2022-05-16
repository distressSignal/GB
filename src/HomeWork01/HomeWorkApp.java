package HomeWork01;


public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void compareNumbers() {
        int a = 1;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static void printColor() {
        int value = 3;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }


    public static void checkSumSign() {
        int a = 2;
        int b = 3;
        System.out.println(a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    private static void printThreeWords() {
        System.out.println("Orange\n" +
                "Banana\n" +
                "Apple");
    }
}
