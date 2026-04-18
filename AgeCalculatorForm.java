import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.*;

public class AgeCalculatorForm 
{
    public static void main(String[] args) {
        JFrame f = new JFrame("DOB to Age");
        JLabel l1 = new JLabel("Name:");
        JTextField t1 = new JTextField(15);
        JLabel l2 = new JLabel("DOB (YYYY-MM-DD):");
        JTextField t2 = new JTextField(15);
        JButton b = new JButton("Submit");
        JTextArea output = new JTextArea(5, 25);
        
f.setLayout(new FlowLayout());
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(b);
f.add(output);
b.addActionListener(e -> {
String name = t1.getText();
String dobString = t2.getText();
try {
LocalDate birthDate = LocalDate.parse(dobString);
LocalDate currentDate = LocalDate.now();
int age = Period.between(birthDate, currentDate).getYears();
output.setText("Name: " + name + "\nAge: " + age);
} catch (Exception ex) {
output.setText("Invalid Format! Use YYYY-MM-DD");
}
});
f.setSize(300, 350);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
}
}