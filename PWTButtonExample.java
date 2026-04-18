import java.awt.*;
import java.awt.event.*;

public class PWTButtonExample implements ActionListener {
    Frame frame;
    Button button;
    Label statusLabel;
    public PWTButtonExample() {
        frame = new Frame("PWT Button Example");
        button = new Button("Click Me");
        statusLabel = new Label("Button not clicked yet");
        button.setBounds(100, 70, 120, 30);
        statusLabel.setBounds(80, 120, 180, 30);

        button.addActionListener(this);
        frame.add(button);
        frame.add(statusLabel);
        frame.setSize(340, 220);
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
        statusLabel.setText("Hello!");
    }
    public static void main(String[] args) {
        new PWTButtonExample();
    }
}
