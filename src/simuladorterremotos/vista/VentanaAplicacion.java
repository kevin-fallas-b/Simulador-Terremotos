/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.shape.Line;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import simuladorterremotos.control.ControlSimulador;

/**
 *
 * @author Kevin
 */
public class VentanaAplicacion extends JFrame implements Observer {

    private final ControlSimulador gestor;
    private BarraInferior barraInferior;
    private PanelCentral panelCentral;
    private JMenuBar menuPrincipal;
    private JMenu menuVentana;
    private JMenu menuDatos;
    private JMenu menuArchivo;
    private JMenuItem itemCambiarArchivo;
    private JMenuItem itemLimitarVisualizacion;
    private JMenuItem itemSalir;

    public VentanaAplicacion(String titulo, ControlSimulador gestor) {
        super(titulo);
        this.gestor = gestor;
        configurar();

    }

    private void configurar() {
        setResizable(true);
        setSize(800, 600);
        setMinimumSize(new Dimension(400, 400));
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
        ajustarMenu();
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }

    private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER, panelCentral = new PanelCentral());
        c.add(BorderLayout.PAGE_END, barraInferior = new BarraInferior());
    }

    private void ajustarMenu(){
        menuPrincipal = new JMenuBar();
        menuPrincipal.add(menuArchivo = new JMenu("Archivo"));
        menuPrincipal.add(menuVentana = new JMenu("Ventana"));
        menuPrincipal.add(menuDatos = new JMenu("Datos"));
        
        menuArchivo.add(itemSalir = new JMenuItem("Salir"));
        menuVentana.add(itemLimitarVisualizacion = new JMenuItem("Ajustar Parametros"));
        menuDatos.add(itemCambiarArchivo = new JMenuItem("Cambiar Archivo"));
        
        itemSalir.addActionListener((ActionEvent e) -> {
            cerrarVentana();
        });
        
        setJMenuBar(menuPrincipal);
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
