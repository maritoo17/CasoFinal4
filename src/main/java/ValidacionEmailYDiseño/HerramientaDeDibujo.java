package ValidacionEmailYDiseño;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HerramientaDeDibujo extends JFrame {
    private final JPanel drawPanel;

    public HerramientaDeDibujo() {
        super("Herramienta de Dibujo Simple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        drawPanel = new JPanel() {
            private Point lastPoint;

            {
                setPreferredSize(new Dimension(600, 400));
                setBackground(Color.WHITE);
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        lastPoint = e.getPoint();
                    }
                });
                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        Graphics g = getGraphics();
                        g.setColor(Color.BLACK);
                        g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                        lastPoint = e.getPoint();
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };

        setContentPane(drawPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HerramientaDeDibujo().setVisible(true));
    }
}
