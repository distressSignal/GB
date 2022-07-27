package Mod01.HomeWork08.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    public static StringBuilder sb = new StringBuilder();
    private JTextField inputField;

    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    public static StringBuilder getSb() {
        return sb;
    }

    public static void setSb(StringBuilder sb) {
        ButtonListener.sb = sb;
    }

    public void getSb(String inputField) {
        sb.append(inputField);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
//        sb.append(e.toString());


        sb.append(btn.getText());
        String a = sb.toString() + " ";


//        sb.append(btn);
//        new Math(sb);

//        sb.append(inputField.getText());
        inputField.setText(inputField.getText() + " " + btn.getText() + "  ");

//        inputField.setText(a);
    }
}
