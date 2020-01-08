/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import simuladorterremotos.control.ControlSimulador;

/**
 *
 * @author Kevin
 */
public class PanelCentral extends JPanel {

    private JPanel panel;
    private JLabel fondo;
    private BufferedImage mapaCr;
    private final ControlSimulador gestor;
    private Integer x = 0;
    private Integer y = 0;

    public PanelCentral(ControlSimulador gestor) {
        super();
        this.gestor = gestor;
        configurar();
    }

    private void configurar() {
        try {
            mapaCr = ImageIO.read(PanelCentral.class.getResourceAsStream("../resource/MapaCR.png"));
            setPreferredSize(new Dimension(mapaCr.getWidth(), mapaCr.getHeight()));

        } catch (IOException ex) {
            Logger.getLogger(PanelCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        setLayout(new GridLayout(1, 1));
        add(new JScrollPane(panel = new JPanel() {

        }, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        ));
        fondo = new JLabel(new ImageIcon(mapaCr));
        fondo.setLayout(null);
        fondo.setBounds(0, 0, mapaCr.getWidth(), mapaCr.getHeight());
        fondo.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                gestor.dibujarLineas(e);
            }
        });
        fondo.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        panel.add(fondo);
        panel.setBackground(new Color(200,235,255));
    }

    void dibujarLineas(MouseEvent e) {
        MouseEvent nuevo = SwingUtilities.convertMouseEvent(fondo, e, this);
        this.x = nuevo.getX();
        this.y = nuevo.getY();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.MAGENTA);
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);        
        g2d.drawLine(x, 0, x, panel.getHeight());
        g2d.drawLine(0, y, panel.getWidth(), y);
    }
}
