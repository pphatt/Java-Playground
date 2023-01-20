package org.example;

import org.example.utils.eval;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator {
    private JPanel panel1;
    private JButton buttonNumber1;
    private JButton buttonNumber2;
    private JButton buttonNumber3;
    private JButton buttonNumber4;
    private JButton buttonNumber5;
    private JButton buttonNumber6;
    private JButton buttonNumber7;
    private JButton buttonNumber8;
    private JButton buttonNumber9;
    private JButton mulButton;
    private JButton subButton;
    private JButton plusButton;
    private JButton equalButton;
    private JButton buttonNumber0;
    private JButton decimalButton;
    private JButton negateButton;
    private JButton divButton;
    private JButton deleteButton;
    private JLabel display1;
    private JLabel display2;

    private final String[] arr = {"", "", ""};

    public Calculator() {
        buttonNumber1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("1");
            }
        });

        buttonNumber2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("2");
            }
        });

        buttonNumber3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("3");
            }
        });

        buttonNumber4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("4");
            }
        });

        buttonNumber5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("5");
            }
        });

        buttonNumber6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("6");
            }
        });

        buttonNumber7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("7");
            }
        });

        buttonNumber8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("8");
            }
        });

        buttonNumber9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseNumber("9");
            }
        });

        buttonNumber0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!arr[0].equals("") || !arr[2].equals("")) {
                    parseNumber("0");
                }
            }
        });

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseOperator("+");
            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseOperator("-");
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseOperator("*");
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseOperator("/");
            }
        });

        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = Double.toString(eval.eval(arr[0] + arr[1] + arr[2]));
                display1.setText(arr[0] + " " + arr[1] + " " + arr[2] + " = ");
                display2.setText(result);
                arr[0] = result;
                arr[1] = "";
                arr[2] = "";
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arr[1].equals("")) {
                    if (!arr[0].equals("")) {
                        arr[0] = arr[0].substring(0, arr[0].length() - 1);
                        if (arr[0].equals("")) {
                            display2.setText("");
                        } else {
                            display2.setText(arr[0]);
                        }
                    }
                } else {
                    if (!arr[2].equals("")) {
                        arr[2] = arr[2].substring(0, arr[2].length() - 1);
                        if (arr[2].equals("")) {
                            display2.setText("0");
                        } else {
                            display2.setText(arr[2]);
                        }
                    } else {
                        display1.setText("");
                        display2.setText(arr[0]);
                        arr[1] = "";
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Calculator().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void parseOperator(String o) {
        if (arr[2].equals("")) {
            arr[1] = o;
            display1.setText(arr[0] + " " + arr[1] + " ");
        } else {
            String result = Double.toString(eval.eval(arr[0] + arr[1] + arr[2]));
            arr[0] = result;
            arr[1] = o;
            arr[2] = "";
            display1.setText(arr[0] + " " + arr[1] + " ");
            display2.setText(arr[0]);
        }
    }

    public void parseNumber(String n) {
        if (arr[1].equals("")) {
            if (display2.getText().equals("0")) {
                display2.setText(n);
            } else {
                display2.setText(display2.getText() + n);
            }

            arr[0] = display2.getText();
        } else {
            if (arr[2].equals("")) {
                display2.setText(n);
            } else {
                display2.setText(display2.getText() + n);
            }

            arr[2] = display2.getText();
        }
    }
}
