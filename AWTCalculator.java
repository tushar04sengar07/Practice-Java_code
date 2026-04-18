import java.awt.*;
import java.awt.event.*;

public class AWTCalculator implements ActionListener {
    Frame frame;
    TextField display;
    String currentText = "";
    String operator = "";
    double storedValue = 0;
    boolean startNewNumber = true;

    public AWTCalculator() {
        frame = new Frame("AWT Calculator");

        display = new TextField("0");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setBackground(Color.WHITE);

        Panel buttonPanel = new Panel(new GridLayout(6, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE", "", ""
        };
        for (String label : buttons) {
            if (label.isEmpty()) {
                buttonPanel.add(new Label());
            } else {
                Button button = new Button(label);
                button.setFont(new Font("Arial", Font.PLAIN, 18));
                button.addActionListener(this);
                buttonPanel.add(button);
            }
        }
        
        frame.setLayout(new BorderLayout(5, 5));
        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(360, 420);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((Button) e.getSource()).getLabel();

        switch (command) {
            case "C":
                currentText = "";
                operator = "";
                storedValue = 0;
                startNewNumber = true;
                display.setText("0");
                break;
            case "CE":
                currentText = "";
                display.setText("0");
                startNewNumber = true;
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!currentText.isEmpty()) {
                    storedValue = Double.parseDouble(currentText);
                }
                operator = command;
                startNewNumber = true;
                break;
            case "=":
                calculateResult();
                break;
            default:
                addDigit(command);
                break;
        }
    }

    private void addDigit(String digit) {
        if (startNewNumber) {
            currentText = "";
            startNewNumber = false;
        }
        if (digit.equals(".") && currentText.contains(".")) {
            return;
        }
        currentText += digit;
        display.setText(currentText);
    }

    private void calculateResult() {
        try {
            if (operator.isEmpty() || currentText.isEmpty()) {
                return;
            }
            double secondValue = Double.parseDouble(currentText);
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
                        display.setText("Error");
                        currentText = "";
                        return;
                    }
                    result = storedValue / secondValue;
                    break;
                default:
                    return;
            }
            String text = String.valueOf(result);
            display.setText(text);
            currentText = text;
            startNewNumber = true;
            operator = "";
        } catch (NumberFormatException ex) {
            display.setText("Error");
            currentText = "";
        }
    }

    public static void main(String[] args) {
        new AWTCalculator();
    }
}