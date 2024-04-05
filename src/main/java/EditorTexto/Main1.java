package EditorTexto;

import javax.swing.*;

public class Main1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al establecer el LookAndFeel", "Error", JOptionPane.ERROR_MESSAGE);
            }
            new CreacionYAlmacenamiento("path/to/your/directory");
        });
    }
}
