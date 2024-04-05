package EditorTexto;

import javax.swing.*;

public class Main1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new CreacionYAlmacenamiento();
        });
    }
}