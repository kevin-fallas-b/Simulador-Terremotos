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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import simuladorterremotos.clases.Coordenada;
import simuladorterremotos.clases.Sismo;
import simuladorterremotos.configuracion.Configuracion;
import simuladorterremotos.control.ControlSimulador;
import simuladorterremotos.util.ConversionUtil;
import simuladorterremotos.util.XmlUtil;

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
    private List<Sismo> sismos;
    private final Integer tamanoCirculo;
    private final Color[] colores;
         
    public PanelCentral(ControlSimulador gestor) {
        super();
        this.gestor = gestor;
        this.sismos = new ArrayList();
        this.tamanoCirculo = Configuracion.obtenerInstancia().getTamanoSismo();
        this.colores = Configuracion.obtenerInstancia().getColores();
        configurar();
    }

    private void configurar() {
        try {
            mapaCr = ImageIO.read(new File(XmlUtil.getInstance().getMapa().getImage().getAbsolutePath()));
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
        panel.setBackground(new Color(200, 235, 255));
    }

    void dibujarLineas(MouseEvent e) {
        MouseEvent nuevo = SwingUtilities.convertMouseEvent(fondo, e, this);
        this.x = nuevo.getX();
        this.y = nuevo.getY();
        repaint();
    }

    public void dibujarSismos(List<Sismo> lista) {
        sismos = lista;
        repaint();
    }

    public void borrarSismos() {
        sismos = new ArrayList<>();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke basico = g2d.getStroke();
        //dibujar texto de guias
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        List<Coordenada> coordenadasGuias = XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas();
        g2d.drawString(coordenadasGuias.get(0).getPosMapa().getLongitud().toString(), fondo.getX() + coordenadasGuias.get(0).getPosImagen().getX() + 10 + panel.getX(), fondo.getY() + coordenadasGuias.get(0).getPosImagen().getY() - 25 + panel.getY());
        g2d.drawString(coordenadasGuias.get(0).getPosMapa().getLatitud().toString(), fondo.getX() + coordenadasGuias.get(0).getPosImagen().getX() + 10 + panel.getX(), fondo.getY() + coordenadasGuias.get(0).getPosImagen().getY() - 10 + panel.getY());

        g2d.drawString(coordenadasGuias.get(1).getPosMapa().getLongitud().toString(), fondo.getX() + coordenadasGuias.get(1).getPosImagen().getX() + 10 + panel.getX(), fondo.getY() + coordenadasGuias.get(1).getPosImagen().getY() - 25 + panel.getY());
        g2d.drawString(coordenadasGuias.get(1).getPosMapa().getLatitud().toString(), fondo.getX() + coordenadasGuias.get(1).getPosImagen().getX() + 10 + panel.getX(), fondo.getY() + coordenadasGuias.get(1).getPosImagen().getY() - 10 + panel.getY());

        //dibujar guias
        g2d.drawLine(fondo.getX() + XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas().get(0).getPosImagen().getX() + panel.getX(), 0, fondo.getX() + XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas().get(0).getPosImagen().getX() + panel.getX(), mapaCr.getHeight()); // guia vertical izquierda
        g2d.drawLine(fondo.getX(), XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas().get(0).getPosImagen().getY() + panel.getY(), fondo.getX() + fondo.getWidth(), XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas().get(0).getPosImagen().getY() + panel.getY()); // guia Horizontal arriba

        g2d.drawLine(fondo.getX() + XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas().get(1).getPosImagen().getX() + panel.getX(), 0, fondo.getX() + XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas().get(1).getPosImagen().getX() + panel.getX(), mapaCr.getHeight()); // guia vertical derecha
        g2d.drawLine(fondo.getX(), XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas().get(1).getPosImagen().getY() + panel.getY(), fondo.getX() + fondo.getWidth(), XmlUtil.getInstance().getMapa().getCoordinates().getCoordenadas().get(1).getPosImagen().getY() + panel.getY()); // guia horizontal abajo

        //dibujar lineas que siguen al mouse
        g2d.setColor(Color.MAGENTA);
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(x, 0, x, panel.getHeight());//linea vertical
        g2d.drawLine(0, y, panel.getWidth(), y);//linea horizontal

        //alistar para pintar sismos
        g2d.setStroke(basico);
        
        //si existen sismos, pintarlos
        int c = 0;
        for (int i = 0; i < sismos.size(); i++) {
            //se suman fondo y panel para que sea redimensionable y no se joda cuando se hace scroll
            Integer xSismo = fondo.getX() + ConversionUtil.longitudAPixeles(sismos.get(i).getLongitud()) + panel.getX();
            Integer ySismo = fondo.getY() + ConversionUtil.latitudAPixeles(sismos.get(i).getLatitud()) + panel.getY();

            g2d.setColor(getColorSegunMagnitud(sismos.get(i)));
            c++;
            if (c % colores.length == 0) {
                c = 0;
            }
            g2d.fillOval(xSismo, ySismo, tamanoCirculo, tamanoCirculo);

            g2d.setColor(new Color(0f, 0f, 0f, 1f));
            g2d.drawString(String.valueOf(sismos.get(i).getMagnitud()), xSismo + (tamanoCirculo/3), ySismo + (tamanoCirculo/2));
        }

    }
    
    private Color getColorSegunMagnitud(Sismo sismo){
       Double magnitud = sismo.getMagnitud();
       return colores[(magnitud.intValue()/2)];
    }
}
