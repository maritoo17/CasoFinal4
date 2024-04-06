package InterfazGráfica;

import javax.swing.*;
import java.awt.*;

public class MultiplicidadDeVentanas extends JFrame {
    private JDesktopPane desktopPane = new JDesktopPane();

    public MultiplicidadDeVentanas() {
        super("Multi-Document Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(desktopPane, BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza la ventana principal

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newDocumentItem = new JMenuItem("New Document");
        newDocumentItem.addActionListener(e -> createNewDocument());
        fileMenu.add(newDocumentItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void createNewDocument() {
        JInternalFrame internalFrame = new DocumentInternalFrame();
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }

    class DocumentInternalFrame extends JInternalFrame {
        private static int openFrameCount = 0;
        private static final int xOffset = 30, yOffset = 30;

        public DocumentInternalFrame() {
            super("Document #" + (++openFrameCount),
                    true, // resizable
                    true, // closable
                    true, // maximizable
                    true);// iconifiable
            setSize(300, 300);
            setLocation(xOffset * openFrameCount, yOffset * openFrameCount);

            JTextArea textArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(textArea);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultiplicidadDeVentanas frame = new MultiplicidadDeVentanas();
            frame.setVisible(true);
        });
    }
}
