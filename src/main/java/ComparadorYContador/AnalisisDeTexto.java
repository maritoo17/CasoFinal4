package ComparadorYContador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AnalisisDeTexto extends JFrame {
    private JTextArea textArea = new JTextArea(20, 60);
    private JButton loadButton = new JButton("Load Text File");
    private JButton analyzeButton = new JButton("Analyze Text");
    private JFileChooser fileChooser = new JFileChooser();

    public AnalisisDeTexto() {
        super("Text Analysis Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupUI();
        pack();
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    private void setupUI() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(loadButton);
        contentPane.add(analyzeButton);

        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane);

        loadButton.addActionListener(e -> loadFile());
        analyzeButton.addActionListener(e -> analyzeText());

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Establece el directorio actual como predeterminado
    }

    private void loadFile() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                textArea.setText(content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void analyzeText() {
        String text = textArea.getText();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Text is empty. Please load a file first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String[] words = text.split("\\s+");
        int totalWords = words.length;

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        StringBuilder stats = new StringBuilder();
        stats.append("Total Words: ").append(totalWords).append("\n\nWord Frequency:\n");
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> stats.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));

        JOptionPane.showMessageDialog(this, stats.toString(), "Text Analysis", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnalisisDeTexto().setVisible(true));
    }
}
