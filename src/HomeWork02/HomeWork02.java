package HomeWork02;


//4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
//5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
public class HomeWork02 {


    public static void main(String[] args) {
//        System.out.println(sum(2,70));
//        positive(-7);
//        print("d", 2);
//        int a = 2000% 4;
//        int b = 1000 %100;
//        int c = 800%400;
        System.out.println(vis(1000));
    }


    static boolean sum(int a, int b) {
        return a + b >= 0 & a + b <= 20 ? true : false;
    }


    static void positive(int a) {
        if (a >= 0) {
            System.out.println("Позитивное число");
        } else {
            System.out.println("Негативное число");
        }
    }

    static boolean positiveBoolean(int a) {
        if (a <= 0) {
            return true;
        } else {
            return false;
        }
    }

    static void print(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    static boolean vis(int a) {
        if (a % 4 == 0) {
            if (a % 100 == 0 & a % 400 != 0) {
                return false;
            }
            return true;}

        return false;

    }
}
