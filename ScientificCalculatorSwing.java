import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScientificCalculatorSwing implements ActionListener {
    private JFrame frame;
    private JTextField display;
    private String currentValue = "";
    private String operator = "";
    private double storedValue = 0;

    public ScientificCalculatorSwing() {
        frame = new JFrame("Scientific Calculator");
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sin", "cos", "tan", "sqrt",
            "log", "^2", "C", "CE"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        frame.setLayout(new BorderLayout(5, 5));
        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(360, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "C":
                currentValue = "";
                operator = "";
                storedValue = 0;
                display.setText("");
                break;
            case "CE":
                currentValue = "";
                display.setText("");
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!currentValue.isEmpty()) {
                    storedValue = Double.parseDouble(currentValue);
                    currentValue = "";
                }
                operator = command;
                display.setText(command);
                break;
            case "=":
                calculateResult();
                break;
            case "sin":
            case "cos":
            case "tan":
            case "sqrt":
            case "log":
            case "^2":
                applyFunction(command);
                break;
            default:
                currentValue += command;
                display.setText(currentValue);
                break;
        }
    }

    private void calculateResult() {
        try {
            double secondValue = currentValue.isEmpty() ? 0 : Double.parseDouble(currentValue);
            double result;

            switch (operator) {
                case "+":
                    result = storedValue + secondValue;
                    break;
                case "-":
                    result = storedValue - secondValue;
                    break;
                case "*":
                    result = storedValue * secondValue;
                    break;
                case "/":
                    if (secondValue == 0) {
                        display.setText("Error: divide by zero");
                        return;
                    }
                    result = storedValue / secondValue;
                    break;
                default:
                    display.setText(currentValue);
                    return;
            }

            display.setText(String.valueOf(result));
            currentValue = String.valueOf(result);
            operator = "";
        } catch (NumberFormatException ex) {
            display.setText("Invalid input");
        }
    }

    private void applyFunction(String function) {
        try {
            double value = currentValue.isEmpty() ? storedValue : Double.parseDouble(currentValue);
            double result;

            switch (function) {
                case "sin":
                    result = Math.sin(Math.toRadians(value));
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(value));
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(value));
                    break;
                case "sqrt":
                    result = Math.sqrt(value);
                    break;
                case "log":
                    result = Math.log10(value);
                    break;
                case "^2":
                    result = value * value;
                    break;
                default:
                    return;
            }

            display.setText(String.valueOf(result));
            currentValue = String.valueOf(result);
            operator = "";
            storedValue = 0;
        } catch (NumberFormatException ex) {
            display.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScientificCalculatorSwing::new);
    }
}

