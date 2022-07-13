package lesson8_hw;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    private static StringBuilder mathPostfix = new StringBuilder();

    private static LinkedList<String> operators = new LinkedList<>();
    private static Stack<String> operatorsStack = new Stack<>();

    static {
        operators.add("*");
        operators.add("/");
        operators.add("-");
        operators.add("+");
        operators.add("^");
    }


    public static String convert(String mathInfix) {
        operatorsStack.clear();
        mathPostfix.setLength(0);

        Matcher matcherMath = getMatcherMath(mathInfix);
        while (matcherMath.find()) {
            String mathElement = matcherMath.group();
            if (isNumeric(mathElement)) {
                mathPostfix.append(mathElement).append(" ");
            } else if (mathElement.equals("(")) {
                operatorsStack.add(mathElement);
            } else if (mathElement.equals(")")) {
                while (!operatorsStack.peek().equals("(")) {
                    mathPostfix.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.pop();
            } else {
                while (!operatorsStack.isEmpty() && getOperatorPriority(operatorsStack.peek()) >= getOperatorPriority(mathElement)) {
                    mathPostfix.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.push(mathElement);
            }
        }

        while (!operatorsStack.isEmpty()) {
            mathPostfix.append(operatorsStack.pop()).append(" ");
        }

        return mathPostfix.toString();
    }

    private static Matcher getMatcherMath(String mathInfix) {
        Pattern patternMath = Pattern.compile(getPatternString());
        return  patternMath.matcher(mathInfix);

    }

    private static int getOperatorPriority(String operator) {
        return switch (operator) {
            case "^" -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default -> 0;
        };
    }

    private static String getPatternString() {
        return getPatternStrDigits() + "|" + getPatternStrOperators() + "|" + getPatternStrBrackets();
    }

    private static String getPatternStrBrackets() {
        return "([\\(\\)])";
    }

    private static String getPatternStrOperators() {
        StringBuilder sb = new StringBuilder("([");
        for (String operator : operators) {
            sb.append("\\").append(operator);
        }
        return sb.append("])").toString();
    }

    private static String getPatternStrDigits() {
        return "(\\d+((\\.\\d+)?)+)";
    }

    static boolean isNumeric(String mathElement) {
//        Pattern patternDigit = Pattern.compile(getPatternStrDigits());
//        return patternDigit.matcher(mathElement).find();
        return mathElement.matches(getPatternStrDigits());
    }


    public static void main(String[] args) {
//        System.out.println(getPatternString());
//        System.out.println(convert("1 + 2 + 3 * 4 + 5"));
//        System.out.println(convert("1 + 2 * 3"));
//        System.out.println(convert("1.5+4.2*(5+2)/10-4"));
//        System.out.println(convert("11*(42 + 23 )-(40^2/5)"));
    }
}
