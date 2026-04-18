import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LabelClass {
    public LabelClass() {
        Frame frame = new Frame("Label in New Class");
        Label label = new Label("Hello from a new label class");

        label.setAlignment(Label.CENTER);
        label.setBounds(40, 80, 260, 30);

        frame.add(label);
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

    public static void main(String[] args) {
        new LabelClass();
    }
}
