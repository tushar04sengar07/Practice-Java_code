import java.awt.*;
import java.awt.event.*;

public class AWTNumberOperation implements ActionListener {
    Frame frame;
    TextField firstNumber;
    TextField secondNumber;
    TextField symbolField;
    Label resultLabel;

    public AWTNumberOperation() {
        frame = new Frame("AWT Number Operation");

        Label firstLabel = new Label("First number:");
        Label secondLabel = new Label("Second number:");
        Label symbolLabel = new Label("Symbol (+ - * /):");
        resultLabel = new Label("Result will appear here");

        firstNumber = new TextField();
        secondNumber = new TextField();
        symbolField = new TextField();
        Button calculateButton = new Button("Calculate");

        firstLabel.setBounds(50, 60, 100, 25);
        firstNumber.setBounds(160, 60, 120, 25);
        secondLabel.setBounds(50, 100, 100, 25);
        secondNumber.setBounds(160, 100, 120, 25);
        symbolLabel.setBounds(50, 140, 100, 25);
        symbolField.setBounds(160, 140, 120, 25);
        calculateButton.setBounds(120, 190, 100, 30);
        resultLabel.setBounds(50, 240, 260, 25);

        calculateButton.addActionListener(this);

        frame.add(firstLabel);
        frame.add(firstNumber);
        frame.add(secondLabel);
        frame.add(secondNumber);
        frame.add(symbolLabel);
        frame.add(symbolField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setSize(360, 320);
        frame.setLayout(null);
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
        try {
            double num1 = Double.parseDouble(firstNumber.getText().trim());
            double num2 = Double.parseDouble(secondNumber.getText().trim());
            String symbol = symbolField.getText().trim();
            double result;

            switch (symbol) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        resultLabel.setText("Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    resultLabel.setText("Enter +, -, * or /");
                    return;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new AWTNumberOperation();
    }
}
