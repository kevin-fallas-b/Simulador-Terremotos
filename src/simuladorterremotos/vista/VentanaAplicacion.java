/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.shape.Line;
import javax.swing.JFrame;
import simuladorterremotos.control.ControlSimulador;

/**
 *
 * @author Kevin
 */
public class VentanaAplicacion extends JFrame implements Observer {

    private final ControlSimulador gestor;
    private BarraInferior barraInferior;
    private PanelCentral panelCentral;

    public VentanaAplicacion(String titulo, ControlSimulador gestor) {
        super(titulo);
        this.gestor = gestor;
        configurar();

    }

    private void configurar() {
        setResizable(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }

        });
        //agrega la funcion de seguir el mouse
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                dibujarLineasMouse(e.getX(), e.getY());
            }
        });
        ajustarComponentes(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER, panelCentral = new PanelCentral());
        c.add(BorderLayout.PAGE_END, barraInferior = new BarraInferior());
    }

    public void init() {
        gestor.registrar(this);
    }

    private void cerrarVentana() {
        gestor.suprimir(this);
        dispose();
    }

    private void dibujarLineasMouse(Integer x, Integer y) {
        Line lineaVertical = new Line(x, 0, x + 10, 600);
        Line lineaHorizontal = new Line(0, y, 800, y + 10);
        barraInferior.mostrarMensaje(x, y);
    }
}
