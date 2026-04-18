import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScientificCalculator extends JFrame implements ActionListener {

    JTextField tf;
    double num1 = 0, num2 = 0, result = 0;
    String operator = "";

    public ScientificCalculator() {

        setTitle("Scientific Calculator");
        setSize(350, 400);

        tf = new JTextField();
        tf.setFont(new Font("Arial", Font.BOLD, 18));
        add(tf, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        String buttons[] = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0",".","=","+",
                "sin","cos","tan","log",
                "sqrt","x^y","C",""
        };

        for (String text : buttons) {
            if (text.equals("")) {
                panel.add(new JLabel());
            } else {
                JButton btn = new JButton(text);
                btn.addActionListener(this);
                panel.add(btn);
            }
        }

        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        try {
            // Numbers
            if (cmd.matches("[0-9.]")) {
                tf.setText(tf.getText() + cmd);
            }

            // Operators
            else if (cmd.matches("[+\\-*/]")) {
                num1 = Double.parseDouble(tf.getText());
                operator = cmd;
                tf.setText("");
            }

            // Equals
            else if (cmd.equals("=")) {

                if (operator.equals("pow")) {
                    num2 = Double.parseDouble(tf.getText());
                    result = Math.pow(num1, num2);
                } else {
                    num2 = Double.parseDouble(tf.getText());

                    switch (operator) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/": result = num1 / num2; break;
                    }
                }

                tf.setText(String.valueOf(result));
            }

            // Scientific Functions
            else if (cmd.equals("sin")) {
                result = Math.sin(Math.toRadians(Double.parseDouble(tf.getText())));
                tf.setText(String.valueOf(result));
            }

            else if (cmd.equals("cos")) {
                result = Math.cos(Math.toRadians(Double.parseDouble(tf.getText())));
                tf.setText(String.valueOf(result));
            }

            else if (cmd.equals("tan")) {
                result = Math.tan(Math.toRadians(Double.parseDouble(tf.getText())));
                tf.setText(String.valueOf(result));
            }

            else if (cmd.equals("log")) {
                result = Math.log10(Double.parseDouble(tf.getText()));
                tf.setText(String.valueOf(result));
            }

            else if (cmd.equals("sqrt")) {
                result = Math.sqrt(Double.parseDouble(tf.getText()));
                tf.setText(String.valueOf(result));
            }

            else if (cmd.equals("x^y")) {
                num1 = Double.parseDouble(tf.getText());
                operator = "pow";
                tf.setText("");
            }

            // Clear
            else if (cmd.equals("C")) {
                tf.setText("");
                num1 = num2 = result = 0;
                operator = "";
            }

        } catch (Exception ex) {
            tf.setText("Error");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
