package PalabrasYGestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

class Contacto {
    String nombre;
    String email;
    String telefono;

    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " (" + email + ", " + telefono + ")";
    }
}

public class AgendaDeContactos extends JFrame {
    private JTextArea textArea = new JTextArea(20, 60);
    private JButton loadButton = new JButton("Load Text File");
    private JButton analyzeButton = new JButton("Analyze Text");
    private JButton contactsButton = new JButton("Manage Contacts");
    private JFileChooser fileChooser = new JFileChooser();
    private List<Contacto> contactos = new ArrayList<>();

    public AgendaDeContactos() {
        super("Text and Contacts Management Tool");
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
        contentPane.add(contactsButton);

        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane);

        loadButton.addActionListener(e -> loadFile());
        analyzeButton.addActionListener(e -> analyzeText());
        contactsButton.addActionListener(e -> manageContacts());

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
        JOptionPane.showMessageDialog(this, "Total Words: " + text.split("\\s+").length, "Text Analysis", JOptionPane.INFORMATION_MESSAGE);
    }

    private void manageContacts() {
        JDialog contactsDialog = new JDialog(this, "Contacts Management", true);
        contactsDialog.setSize(400, 300);
        contactsDialog.setLayout(new BorderLayout());

        DefaultListModel<Contacto> model = new DefaultListModel<>();
        contactos.forEach(model::addElement);
        JList<Contacto> list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);
        contactsDialog.add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Contact Name:");
            String email = JOptionPane.showInputDialog("Contact Email:");
            String telefono = JOptionPane.showInputDialog("Contact Phone:");
            if (nombre != null && email != null && telefono != null) {
                Contacto nuevoContacto = new Contacto(nombre, email, telefono);
                contactos.add(nuevoContacto);
                model.addElement(nuevoContacto);
            }
        });
        contactsDialog.add(addButton, BorderLayout.SOUTH);

        contactsDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaDeContactos().setVisible(true));
    }
}
