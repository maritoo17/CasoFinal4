package ValidacionEmailYDiseño;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.regex.Pattern;

public class ValidadorDeEmail extends JFrame {
    private JTextField textField = new JTextField(20);
    private JLabel validationLabel = new JLabel("Ingrese un email");
    private static final Pattern emailPattern = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    public ValidadorDeEmail() {
        super("Validador de Email");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                validateEmail();
            }
            public void removeUpdate(DocumentEvent e) {
                validateEmail();
            }
            public void insertUpdate(DocumentEvent e) {
                validateEmail();
            }
        });

        add(textField);
        add(validationLabel);

        pack();
        setLocationRelativeTo(null);
    }

    private void validateEmail() {
        String text = textField.getText();
        if (emailPattern.matcher(text).matches()) {
            validationLabel.setText("Email válido");
            validationLabel.setForeground(new Color(0, 128, 0));
        } else {
            validationLabel.setText("Email no válido");
            validationLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ValidadorDeEmail().setVisible(true));
    }
}
