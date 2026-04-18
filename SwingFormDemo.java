import java.awt.*;
import javax.swing.*;

public class SwingFormDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Swing Form");

        JLabel l1 = new JLabel("Name:");
        JTextField t1 = new JTextField(15);

        JLabel l2 = new JLabel("Password:");
        JPasswordField p1 = new JPasswordField(15);

        JLabel l3 = new JLabel("Gender:");
        JRadioButton r1 = new JRadioButton("Male");
        JRadioButton r2 = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();  // select any one group from both male and female 
        bg.add(r1);
        bg.add(r2);

        JLabel l4 = new JLabel("Hobbies:");
        JCheckBox c1 = new JCheckBox("Reading");
        JCheckBox c2 = new JCheckBox("Music");
        JCheckBox c3 = new JCheckBox("Sports");

        JLabel l5 = new JLabel("Course:");
        String courses[] = {"BCA", "BTech", "MCA", "BSc"};
        JComboBox<String> cb = new JComboBox<>(courses);

        JLabel l6 = new JLabel("Address:");
        JTextArea ta1 = new JTextArea(3, 15);

        JButton b = new JButton("Submit");
        JTextArea ta2 = new JTextArea(10, 30);

        f.setLayout(new FlowLayout());

        f.add(l1); f.add(t1);
        f.add(l2); f.add(p1);
        f.add(l3); f.add(r1); f.add(r2);
        f.add(l4); f.add(c1); f.add(c2); f.add(c3);
        f.add(l5); f.add(cb);
        f.add(l6); f.add(ta1);
        f.add(b);
        f.add(ta2);

        // ✅ Lambda Expression used here
        b.addActionListener(e -> {
            String name = t1.getText();
            String pass = new String(p1.getPassword());

            String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "";

            String hobbies = "";
            if (c1.isSelected()) hobbies += "Reading ";
            if (c2.isSelected()) hobbies += "Music ";
            if (c3.isSelected()) hobbies += "Sports ";

            String course = (String) cb.getSelectedItem();
            String address = ta1.getText();

            ta2.setText(
                "Name: " + name + "\n" +
                "Password: " + pass + "\n" +
                "Gender: " + gender + "\n" +
                "Hobbies: " + hobbies + "\n" +
                "Course: " + course + "\n" +
                "Address: " + address
            );
        });

        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}