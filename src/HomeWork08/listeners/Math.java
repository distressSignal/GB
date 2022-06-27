package HomeWork08.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Math implements ActionListener {
    StringBuilder stringBuilder2 = ButtonListener.getSb();
    private JTextField inputField;

    public Math(JTextField inputField) {

        this.inputField = inputField;
    }


    public String calc() {


        String[] numbers = stringBuilder2.toString().split("[+-/x]");
        double a = Double.parseDouble(numbers[0]);
        double b = Double.parseDouble(numbers[1]);
        char qw = stringBuilder2.charAt(numbers[0].length());
        String result = "";
        switch (qw) {
            case '+':
                result = String.valueOf((int) (a + b));
                break;
            case '-':
                result = String.valueOf((int) (a - b));
                break;
            case 'x':
                result = String.valueOf((int) (a * b));
                break;
            case '/':
                if (b == 0) {
                    result = "Ноль нельзя делить";
                    break;
                }
                result = String.valueOf((a / b));

            default:

        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputField.setText(calc());
    }
}
