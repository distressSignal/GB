package lesson8_hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;

    public ApplicationForm() throws HeadlessException {
        super.setTitle("Calculator v 1.9");
        setBounds(1700, 1500, 350, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

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


        ActionListener buttonListener = e -> {
            JButton btn = (JButton) e.getSource();
            inputField.setText(inputField.getText() + btn.getText());
        };


        //DIGITS
        bottom.add(getDigitsPanel(buttonListener), BorderLayout.CENTER);

        //OPERATORS
        bottom.add(getAdvPanel(buttonListener), BorderLayout.EAST);

        return bottom;
    }

    private JPanel getDigitsPanel(ActionListener buttonListener) {
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
            double result = MathParse.eval(inputField.getText());
            String resultStr = (result % 1 == 0) ? String.valueOf((int) result) : String.format("%.3f", result);
            inputField.setText(resultStr);
        });
        digitsPanel.add(calc);

        return digitsPanel;
    }

    private JPanel getAdvPanel(ActionListener buttonListener) {
        JPanel advPanel = new JPanel();
        advPanel.setLayout(new GridLayout(5, 2));

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
        clear.addActionListener(e -> inputField.setText(""));
        advPanel.add(clear);

        String[] operators = {"+", "-", "*", "/", "(", ")", "^"};

        for (String operator : operators) {
            JButton b = getJButtonOther(operator);
            b.addActionListener(buttonListener);
            advPanel.add(b);
        }

        return advPanel;
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
