package lesson8_hw_simply;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;
    private CalcEngine calcEngine;

    public ApplicationForm() throws HeadlessException {
        super.setTitle("Calculator v 1.5");
        setBounds(1700, 1500, 350, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        calcEngine = new CalcEngine();

        setJMenuBar(createMenu());

        setLayout(new BorderLayout());

        add(createTop(), BorderLayout.NORTH);
        add(createBottom(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        menu.add(new JMenuItem("Clear"));
        JMenuItem exit = menu.add(new JMenuItem("Exit"));

        exit.addActionListener(e -> {
            System.out.println("Приложение завершает свою работу");
            System.exit(0);
        });

        return menuBar;
    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("TimesRoman", Font.BOLD, 30));

        inputField.setEditable(false);
        top.add(inputField);

        return top;
    }

    private JPanel createBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());


        //DIGITS
        bottom.add(getDigitsPanel(), BorderLayout.CENTER);

        //OPERATORS
        bottom.add(getAdvPanel(), BorderLayout.EAST);

        return bottom;
    }

    private JPanel getDigitsPanel() {
        ActionListener buttonListener = e -> {
            JButton btn = (JButton) e.getSource();
            inputField.setText(inputField.getText() + btn.getText());
        };

        JPanel digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 1; i <= 10; i++) {
            String buttonTitle = (i == 10) ? "0" : String.valueOf(i);
            JButton btn = getJButtonNums(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton dot = getJButtonOther(".");
        dot.addActionListener(buttonListener);
        digitsPanel.add(dot);

        JButton calc = getJButtonOther("=");
        calc.addActionListener(e -> {
            Double result = calcEngine.addOperand(getLastInputNum());
            showResult(result);
            calcEngine.reset();
        });
        digitsPanel.add(calc);

        return digitsPanel;
    }

    private void showResult(double result) {
        showResult(result, null);
    }

    private void showResult(double result, String operator) {
        String resultStr = (result % 1 == 0) ? String.valueOf((int) result) : String.format("%.3f", result);
        if (operator != null) {
            resultStr += operator;
        }
        inputField.setText(resultStr);
    }

    private JPanel getAdvPanel() {
        JPanel advPanel = new JPanel();
        advPanel.setLayout(new GridLayout(4, 2));

        JButton clearOne = getJButtonOther("<");
        clearOne.addActionListener(e -> {
            String str = inputField.getText();
            if (str.length() == 0) {
                return;
            }
            inputField.setText(str.substring(0, str.length() - 1));
        });
        advPanel.add(clearOne);

        JButton clear = getJButtonOther("C");
        clear.addActionListener(e -> {
            inputField.setText("");
            calcEngine.reset();
        });
        advPanel.add(clear);

        JButton plus = getJButtonOther("+");
        plus.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("+");
        });
        advPanel.add(plus);

        JButton minus = getJButtonOther("-");
        minus.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("-");
        });
        advPanel.add(minus);


        JButton multiply = getJButtonOther("*");
        multiply.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("*");
        });
        advPanel.add(multiply);

        JButton divide = getJButtonOther("/");
        divide.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("/");
        });
        advPanel.add(divide);

        JButton pow = getJButtonOther("^");
        pow.addActionListener(e -> {
            if (inputField.getText().length() == 0) {
                return;
            }
            buttonOperatorHandling("^");
        });
        advPanel.add(pow);

        return advPanel;
    }

    private void buttonOperatorHandling(String operator) {
        String inputStr = inputField.getText();

        if (String.valueOf(inputStr.charAt(inputStr.length() - 1)).matches("\\D")) {
            inputField.setText(inputStr.substring(0, inputStr.length() - 1) + operator);
            calcEngine.setOperator(operator);
            return;
        }

        Double result = calcEngine.addOperand(getLastInputNum());
        if (result != null) {
            showResult(result, operator);
        } else {
            inputField.setText(inputStr + operator);
        }

        calcEngine.setOperator(operator);
    }

    private String getLastInputNum() {
        var arr = inputField.getText().split("[^0-9\\.]");
        return arr[arr.length - 1];
    }


    private JButton getJButtonOther(String title) {
        JButton btn = new JButton(title);
        btn.setFont(new Font("TimesRoman", Font.BOLD, 25));
        return btn;
    }

    private JButton getJButtonNums(String title) {
        JButton btn = new JButton(title);
        btn.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        return btn;
    }
}
