package EditorTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class NavegacionYListado extends JFrame {
    private JTextArea textArea = new JTextArea(20, 60);
    private JFileChooser fileChooser = new JFileChooser();
    private JButton saveButton = new JButton("Save");
    private JButton openButton = new JButton("Open Document");

    public NavegacionYListado() {
        super("Simple Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(openButton);
        bottomPanel.add(saveButton);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> saveTextToFile());
        openButton.addActionListener(e -> showDocumentList());

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Set the default directory to user's current working directory
        pack();
    }

    private void saveTextToFile() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Ensure the file has a ".txt" extension
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getAbsolutePath() + ".txt");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Failed to save the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showDocumentList() {
        JDialog dialog = new JDialog(this, "Select Document", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);
        dialog.add(scrollPane, BorderLayout.CENTER);

        JButton loadButton = new JButton("Load");
        dialog.add(loadButton, BorderLayout.SOUTH);

        try (Stream<Path> paths = Files.walk(Paths.get(System.getProperty("user.dir")))) {
            paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".txt"))
                    .forEach(path -> model.addElement(path.toAbsolutePath().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        loadButton.addActionListener(e -> {
            if (!list.isSelectionEmpty()) {
                String selectedFile = list.getSelectedValue();
                loadFileIntoEditor(new File(selectedFile));
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
    }

    private void loadFileIntoEditor(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.read(reader, null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to load the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NavegacionYListado().setVisible(true));
    }
}
