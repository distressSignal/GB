package lesson8_hw;

import java.util.Stack;

public class MathParse {
    private static Stack<Double> numbers = new Stack<>();
    private static String mathPostfix;

    public static double eval(String mathInfix) {
        mathPostfix = InfixToPostfix.convert(mathInfix);
        var mathArr = mathPostfix.split("\s+");

        for (String mathElement : mathArr) {
            if (InfixToPostfix.isNumeric(mathElement)) {
                numbers.push(Double.parseDouble(mathElement));
                continue;
            }
            double num2 = numbers.pop();
            double num1 = numbers.pop();

            numbers.push(calc(num1, num2, mathElement));
        }


        return numbers.pop();
    }

    private static double calc(double num1, double num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "^" -> Math.pow(num1, num2);
            default -> 0;
        };

    }

    public static void main(String[] args) {
        System.out.println(eval("11*(42 + 23 )-(40^2/5)"));
        System.out.println(eval("((3 + 7) * (2 - 5 * 1))/7"));
        System.out.println(eval("1.5+4.2*(5+2)/10-4"));
    }
}
