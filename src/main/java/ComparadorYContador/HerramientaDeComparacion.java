package ComparadorYContador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class HerramientaDeComparacion extends JFrame {
    private JButton compareButton = new JButton("Compare Files");
    private JFileChooser fileChooser = new JFileChooser();

    public HerramientaDeComparacion() {
        super("File Comparison Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupUI();
        pack();
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(compareButton);

        compareButton.addActionListener(e -> compareFiles());
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    }

    private void compareFiles() {
        JOptionPane.showMessageDialog(this, "Select the first file to compare.");
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File firstFile = fileChooser.getSelectedFile();

        JOptionPane.showMessageDialog(this, "Select the second file to compare.");
        returnVal = fileChooser.showOpenDialog(this);
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File secondFile = fileChooser.getSelectedFile();

        try {
            String firstFileContent = new String(Files.readAllBytes(firstFile.toPath()));
            String secondFileContent = new String(Files.readAllBytes(secondFile.toPath()));

            if (firstFileContent.equals(secondFileContent)) {
                JOptionPane.showMessageDialog(this, "The files are identical.");
            } else {
                JOptionPane.showMessageDialog(this, "The files are different.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading files.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HerramientaDeComparacion().setVisible(true));
    }
}
