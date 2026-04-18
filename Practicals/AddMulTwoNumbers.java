import java.awt.*;
import java.awt.event.*;

public class AddMulTwoNumbers extends Frame implements ActionListener {
    // Component declarations
    TextField txtNum1, txtNum2, txtResult;
    Button btnAdd, btnMultiply;

    public AddMulTwoNumbers() {
        // Use FlowLayout for easy component positioning
        setLayout(new FlowLayout());

        // Initialise input fields and labels
        add(new Label("First Number:"));
        txtNum1 = new TextField(10);
        add(txtNum1);

        add(new Label("Second Number:"));
        txtNum2 = new TextField(10);
        add(txtNum2);

        // Initialise action buttons
        btnAdd = new Button("Add");
        btnMultiply = new Button("Multiply");
        add(btnAdd);
        add(btnMultiply);

        // Initialise result field (read-only)
        add(new Label("Result:"));
        txtResult = new TextField(10);
        txtResult.setEditable(false);
        add(txtResult);

        // Register action listeners for buttons
        btnAdd.addActionListener(this);
        btnMultiply.addActionListener(this);

        // Standard window settings
        setTitle("Simple Calculator");
        setSize(300, 200);
        setVisible(true);

        // Close window logic
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Retrieve and parse inputs
            double n1 = Double.parseDouble(txtNum1.getText());
            double n2 = Double.parseDouble(txtNum2.getText());
            double result = 0;

            // Determine which button was clicked
            if (e.getSource() == btnAdd) {
                result = n1 + n2;
            } else if (e.getSource() == btnMultiply) {
                result = n1 * n2;
            }

            // Display formatted result
            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            // Basic error handling for non-numeric input
            txtResult.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        new AddMulTwoNumbers();
    }
}
