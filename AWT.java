//JAVA AWT PROGRAM FOR HELLO WORLD
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// DRIVER CLASS
public class AWT{
    // MAIN FUNCTION
    public static void main(String[] args) {
        //Declaring a frame and label
        Frame frame = new Frame("Window Title");
        Label label = new Label("HELLO WORLD!");
        //Setting the alignment of the label to center
        label.setAlignment(label.CENTER);
        //adding the label and setting the size of the frame
        frame.add(label);
        frame.setSize(300, 300);
        // making the frame visible
        frame.setVisible(true);
        // using the window adapter to handle the window closing event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}