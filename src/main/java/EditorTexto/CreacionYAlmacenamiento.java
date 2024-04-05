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

    public CreacionYAlmacenamiento() {
        frame = new JFrame("Editor de Texto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new SaveAction());
        frame.add(saveButton, BorderLayout.SOUTH);

        fileList = new JList<>(getFileNames("path/to/your/directory"));
        fileList.addListSelectionListener(new FileSelectionAction());
        frame.add(new JScrollPane(fileList), BorderLayout.WEST);

        frame.setVisible(true);
    }

    private String[] getFileNames(String directoryPath) {
        File directory = new File(directoryPath);
        return directory.list();
    }

    private class SaveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                writer.write(textArea.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private class FileSelectionAction implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String selectedFile = fileList.getSelectedValue();
                try (BufferedReader reader = new BufferedReader(new FileReader("path/to/your/directory/" + selectedFile))) {
                    textArea.read(reader, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}