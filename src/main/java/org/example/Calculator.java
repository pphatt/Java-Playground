package org.example;

import javax.swing.*;

public class Calculator {
    private JPanel MainPanel;
    private JButton numberOne;
    private JButton numberTwo;
    private JButton numberThree;
    private JButton numberFour;
    private JButton numberFive;
    private JButton numberSix;
    private JButton numberSeven;
    private JButton numberEight;
    private JButton numberNine;
    private JLabel input;
    private JButton btn;

    public Calculator() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Calculator().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
//        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
