package EditorTexto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CreacionYAlmacenamiento {
    private JFrame frame;
    private JTextArea textArea;
    private JList<String> fileList;
    private File currentDirectory;

    public CreacionYAlmacenamiento(String directoryPath) {
        currentDirectory = new File(directoryPath);
        frame = new JFrame("Editor de Texto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new SaveAction());
        frame.add(saveButton, BorderLayout.SOUTH);

        fileList = new JList<>(getFileNames(currentDirectory));
        fileList.addListSelectionListener(new FileSelectionAction());
        frame.add(new JScrollPane(fileList), BorderLayout.WEST);

        frame.setVisible(true);
    }

    private String[] getFileNames(File directory) {
        return directory.list((dir, name) -> name.endsWith(".txt"));
    }

    private class SaveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser(currentDirectory);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                    writer.write(textArea.getText());
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(frame, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class FileSelectionAction implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String selectedFile = fileList.getSelectedValue();
                File file = new File(currentDirectory, selectedFile);
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.read(reader, null);
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(frame, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
