import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    JTextField display;
    double num1 = 0;
    String operator = "";

    public CalculatorGUI() {
        setTitle("Scientific Calculator");
        setSize(420, 500);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 22));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(6, 4, 10, 10));

        String buttons[] = {
                "sin", "cos", "tan", "sqrt",
                "log", "x²", "%", "AC",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            if (cmd.matches("[0-9.]")) {
                display.setText(display.getText() + cmd);
            }
            else if (cmd.equals("AC")) {
                display.setText("");
                num1 = 0;
                operator = "";
            }
            else if (cmd.matches("[+\\-*/]")) {
                if (!display.getText().isEmpty()) {
                    double value = Double.parseDouble(display.getText());

                    if (!operator.isEmpty()) {
                        num1 = calculate(num1, value, operator);
                    } else {
                        num1 = value;
                    }

                    operator = cmd;
                    display.setText("");
                } else if (!operator.isEmpty()) {
                    operator = cmd; // change operator if user presses a different one
                }
            }
            else if (cmd.equals("=")) {
                if (!operator.isEmpty() && !display.getText().isEmpty()) {
                    double num2 = Double.parseDouble(display.getText());
                    double result = calculate(num1, num2, operator);

                    display.setText(String.valueOf(result));
                    operator = "";
                }
            }
            else if (cmd.equals("sin") && !display.getText().isEmpty()) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sin(Math.toRadians(n))));
            }
            else if (cmd.equals("cos") && !display.getText().isEmpty()) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.cos(Math.toRadians(n))));
            }
            else if (cmd.equals("tan") && !display.getText().isEmpty()) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.tan(Math.toRadians(n))));
            }
            else if (cmd.equals("sqrt") && !display.getText().isEmpty()) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sqrt(n)));
            }
            else if (cmd.equals("log") && !display.getText().isEmpty()) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.log10(n)));
            }
            else if (cmd.equals("x²") && !display.getText().isEmpty()) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(n * n));
            }
            else if (cmd.equals("%") && !display.getText().isEmpty()) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(n / 100));
            }
        } 
        catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return b;
        }
    }
}
