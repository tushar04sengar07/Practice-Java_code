import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class BasicWordEditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JButton newBtn, openBtn, saveBtn, cutBtn, copyBtn, pasteBtn;
    JFileChooser fileChooser;

    public BasicWordEditor() {

        setTitle("Basic Word Editor");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Text Area
        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        // Buttons Panel
        JPanel panel = new JPanel();

        newBtn = new JButton("New");
        openBtn = new JButton("Open");
        saveBtn = new JButton("Save");
        cutBtn = new JButton("Cut");
        copyBtn = new JButton("Copy");
        pasteBtn = new JButton("Paste");

        panel.add(newBtn);
        panel.add(openBtn);
        panel.add(saveBtn);
        panel.add(cutBtn);
        panel.add(copyBtn);
        panel.add(pasteBtn);

        add(panel, BorderLayout.NORTH);

        // File chooser
        fileChooser = new JFileChooser();

        // Add listeners
        newBtn.addActionListener(this);
        openBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        cutBtn.addActionListener(this);
        copyBtn.addActionListener(this);
        pasteBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == newBtn) {
                textArea.setText("");
            }

            else if (e.getSource() == openBtn) {
                if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    FileReader fr = new FileReader(file);
                    textArea.read(fr, null);
                    fr.close();
                }
            }

            else if (e.getSource() == saveBtn) {
                if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    FileWriter fw = new FileWriter(file);
                    textArea.write(fw);
                    fw.close();
                }
            }

            else if (e.getSource() == cutBtn) {
                textArea.cut();
            }

            else if (e.getSource() == copyBtn) {
                textArea.copy();
            }

            else if (e.getSource() == pasteBtn) {
                textArea.paste();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }

    public static void main(String[] args) {
        new BasicWordEditor();
    }
}
