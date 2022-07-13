package Mod01.HomeWork08;

import Mod01.HomeWork08.Components.NumberJButton;
import Mod01.HomeWork08.Components.OperatorJButton;
import Mod01.HomeWork08.listeners.Math;
import Mod01.HomeWork08.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {
    StringBuilder testB = new StringBuilder();

    private JTextField inputField;

    public JTextField getTestText() {
        return testText;
    }

    private JTextField testText;

    public ApplicationForm(String title) throws HeadlessException, InstantiationException, IllegalAccessException {
        super(title);
        setBounds(700, 500, 350, 470); //ПОМЕНЯТЬ!!!
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
//        testListener();

        setJMenuBar(createMenu());

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");

        menuBar.add(menuFile);
        menuBar.add(new JMenuItem("Help"));
        menuBar.add(new JMenuItem("About"));

        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        menuBar.add(exitItem);

/*        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });  */
        exitItem.addActionListener(new ExitButtonListener());



        return menuBar;
    }

//    public StringBuilder getTestB() {
//        return testB;
//    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        inputField.setFont(new Font("Arial", Font.PLAIN, 45));
        inputField.setMargin(new Insets(8, 0, 8, 0));
        inputField.setBackground(new Color(255, 255, 255));

        inputField.setText("Калькулятор");


        return top;
    }

    private JPanel createCenterPanel() throws InstantiationException, IllegalAccessException {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);

        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(buttonListener), BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) throws InstantiationException, IllegalAccessException {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJButton("=");
        digitsPanel.add(calc);
//        calc.setEnabled(false);
        calc.addActionListener(new Math(inputField));


        JButton clear = new OperatorJButton("C");
        digitsPanel.add(clear);
        clear.addActionListener(new ClearButtonActionListener(inputField));

        return digitsPanel;
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(buttonListener);
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(buttonListener);
        panel.add(plus);

        JButton multiply = new OperatorJButton("x");
        multiply.addActionListener(buttonListener);
        panel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(buttonListener);
        panel.add(divide);
//
//        JButton sc = new OperatorJButton(")");
//        sc.addActionListener(buttonListener);
//        panel.add(sc);
//
//        JButton sc2 = new OperatorJButton("(");
//        sc2.addActionListener(buttonListener);
//        panel.add(sc2);
//
//        JButton thck = new OperatorJButton(".");
//        thck.addActionListener(buttonListener);
//        panel.add(thck);
//
//        JButton sqrt = new OperatorJButton("sqrt");
//        sqrt.addActionListener(buttonListener);
//        panel.add(sqrt);



        return panel;
    }

    private void testListener() {
        Button button = new Button("Кнопка");
        button.addActionListener(new TestButtonListener());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("СОБЫТИЕ!");
            }
        });
//                button.addActionListener(e -> System.out.println("СОБЫТИЕ ЧЕРЕЗ ЛЯМБДУ!"));
        super.add(button);
    }
}
