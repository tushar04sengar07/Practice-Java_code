import java.awt.*;
import java.awt.event.*;

class AWTButtonExample implements ActionListener {
    Frame f;  Button b;  TextField tf;
    AWTButtonExample() {
        f = new Frame("AWT Button Example");
        b = new Button("Click Me");
        b.setBounds(50, 100, 80, 30);
        tf = new TextField();
        tf.setBounds(50, 150, 150, 20);
        b.addActionListener(this);
        f.add(b); f.add(tf);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
    public void actionPerformed(ActionEvent e) {
        tf.setText("Button Clicked");
    }
    public static void main(String[] args) {
        new AWTButtonExample();
    }   
}
