/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Kevin
 */
public class PanelCentral extends JPanel {

    private JPanel panel;
    private JLabel fondo;
    private BufferedImage mapaCr;

    public PanelCentral() {
        super();
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
        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                dibujarLineas(e.getX(), e.getY());
            }
        });
        fondo = new JLabel(new ImageIcon(mapaCr));
        fondo.setLayout(null);
        fondo.setBounds(0, 0, mapaCr.getWidth(), mapaCr.getHeight());
        panel.add(fondo);

    }

    private void dibujarLineas(Integer x, Integer y) {

    }

}
