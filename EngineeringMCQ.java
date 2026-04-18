import java.awt.*;
import javax.swing.*;

public class EngineeringMCQ {
    public static void main(String[] args) {
        JFrame f = new JFrame("Select Discipline");

        JLabel q = new JLabel("Choose at least 3 Engineering Disciplines:");
        
        JCheckBox c1 = new JCheckBox("CSE");
        JCheckBox c2 = new JCheckBox("Civil");
        JCheckBox c3 = new JCheckBox("Elec");
        JCheckBox c4 = new JCheckBox("Mech");
        JCheckBox c5 = new JCheckBox("CSIT");
        JCheckBox c6 = new JCheckBox("AIML");

        JButton b = new JButton("Submit Selection");
        JLabel res = new JLabel("Selected: None");

        f.setLayout(new GridLayout(9, 1));

        f.add(q);
        f.add(c1); f.add(c2); f.add(c3);
        f.add(c4); f.add(c5); f.add(c6);
        f.add(b);
        f.add(res);

        b.addActionListener(e -> {
            String selected = "";
            int count = 0;

            if (c1.isSelected()) { selected += "CSE, "; count++; }
            if (c2.isSelected()) { selected += "Civil, "; count++; }
            if (c3.isSelected()) { selected += "Elec, "; count++; }
            if (c4.isSelected()) { selected += "Mech, "; count++; }
            if (c5.isSelected()) { selected += "CSIT, "; count++; }
            if (c6.isSelected()) { selected += "AIML, "; count++; }

            if (count >= 3) {
                selected = selected.substring(0, selected.length() - 2);
                res.setText("Selected: " + selected);
            } else {
                res.setText("Please select at least 3 options!");
            }
        });

        f.setSize(300, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}