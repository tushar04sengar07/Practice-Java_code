import java.awt.*;
import java.awt.event.*;

public class CalculatorAWT implements ActionListener {
    // Declare components globally so they can be accessed in actionPerformed
    Frame f;
    Label l1, l2, l3;
    TextField tf1, tf2, tf3;
    Button b;

    CalculatorAWT() {
        f = new Frame("Calculator");
        f.setLayout(null); // Use null layout for setBounds to work

        // Labels
        l1 = new Label("Enter First Number:");
        l1.setBounds(50, 50, 150, 20);
        l2 = new Label("Enter Second Number:");
        l2.setBounds(50, 80, 150, 20);
        l3 = new Label("Result:");
        l3.setBounds(50, 140, 150, 20);

        // TextFields
        tf1 = new TextField();
        tf1.setBounds(200, 50, 100, 20);
        tf2 = new TextField();
        tf2.setBounds(200, 80, 100, 20);
        tf3 = new TextField();
        tf3.setBounds(200, 140, 100, 20);
        tf3.setEditable(false);
        
        // Button
        b = new Button("Add");
        b.setBounds(120, 180, 80, 30);

        // Event
        b.addActionListener(this);

        // Add components
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(b);

        // Frame settings
        f.setSize(350, 250);
        f.setVisible(true);
        
        // Window close listener
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n1 = Integer.parseInt(tf1.getText());
            int n2 = Integer.parseInt(tf2.getText());
            int sum = n1 + n2;
            tf3.setText(String.valueOf(sum));
        } catch (NumberFormatException ex) {
            tf3.setText("Error");
        }
    }

    public static void main(String[] args) {
        new CalculatorAWT();
    }
}