package InterfazGráfica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SeguimientoDelRaton extends JFrame {
    private JDesktopPane desktopPane = new JDesktopPane();
    private JLabel statusBar = new JLabel("Mouse Position: 0, 0");

    public SeguimientoDelRaton() {
        super("Seguimiento del Ratón en MDI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(desktopPane, BorderLayout.CENTER);
        setupStatusBar();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza la ventana principal

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newDocumentItem = new JMenuItem("New Document");
        newDocumentItem.addActionListener(e -> createNewDocument());
        fileMenu.add(newDocumentItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        desktopPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                statusBar.setText("Mouse Position: " + e.getX() + ", " + e.getY());
            }
        });
    }

    private void setupStatusBar() {
        statusBar.setPreferredSize(new Dimension(getWidth(), 22));
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        add(statusBar, BorderLayout.SOUTH);
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
            super("Document #" + (++openFrameCount), true, true, true, true);
            setSize(300, 300);
            setLocation(xOffset * openFrameCount, yOffset * openFrameCount);

            JTextArea textArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(textArea);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SeguimientoDelRaton frame = new SeguimientoDelRaton();
            frame.setVisible(true);
        });
    }
}
