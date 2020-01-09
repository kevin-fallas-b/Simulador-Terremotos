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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import simuladorterremotos.clases.Sismo;
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
    private JMenuItem itemVisualizarEnTabla;
    private JMenuItem itemSalir;
    private JCheckBoxMenuItem itemVisualizar;

    public VentanaAplicacion(String titulo, ControlSimulador gestor) {
        super(titulo);
        this.gestor = gestor;
        configurar();
        setSize(900, 700);
    }

    private void configurar() {
        setResizable(true);
        setSize(900, 699);
        setLocationRelativeTo(null);
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
        ajustarComponentes(this);
        ajustarMenu();
        try {
            setIconImage(ImageIO.read(VentanaAplicacion.class.getResourceAsStream("../resource/icon.png")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof MouseEvent) {
            dibujarLineasMouse(((MouseEvent) arg));
        }
        if (arg instanceof List) {
            System.out.println("instancia de lista encontrada");
            dibujarSismos((List<Sismo>) arg);
        }

    }

    private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER, panelCentral = new PanelCentral(gestor));
        c.add(BorderLayout.PAGE_END, barraInferior = new BarraInferior());
    }

    private void ajustarMenu() {
        menuPrincipal = new JMenuBar();
        menuPrincipal.add(menuArchivo = new JMenu("Archivo"));
        menuPrincipal.add(menuVentana = new JMenu("Ventana"));
        menuPrincipal.add(menuDatos = new JMenu("Datos"));

        menuArchivo.add(itemSalir = new JMenuItem("Salir"));
        menuVentana.add(itemLimitarVisualizacion = new JMenuItem("Ajustar Parametros"));
        menuVentana.add(itemVisualizarEnTabla = new JMenuItem("Visualizar en tabla"));
        menuVentana.add(itemVisualizar = new JCheckBoxMenuItem("Visualizar sismos"));
        itemVisualizar.setSelected(false);
        menuDatos.add(itemCambiarArchivo = new JMenuItem("Cambiar Archivo de datos"));

        itemSalir.addActionListener((ActionEvent e) -> {
            cerrarVentana();
        });

        itemCambiarArchivo.addActionListener((e) -> {
            abrirVentanaDatos();
        });
        itemLimitarVisualizacion.addActionListener((e) -> {
            abrirVentanaLimites();
        });
        itemVisualizarEnTabla.addActionListener((e) -> {
            abrirVentanaTabla();
        });
        itemVisualizar.addActionListener((e) -> {
            visualizarSismos();
        });
        setJMenuBar(menuPrincipal);
    }

    public void init() {
        gestor.registrar(this);
    }

    private void cerrarVentana() {
        gestor.cerrarAplicacion();
    }

    private void dibujarLineasMouse(MouseEvent e) {
        barraInferior.mostrarMensaje(e.getX(), e.getY());
        panelCentral.dibujarLineas(e);
    }

    private void abrirVentanaDatos() {
        new VentanaDatos(gestor).init();
    }

    private void abrirVentanaLimites() {
        new VentanaParametros(gestor).init();
    }

    private void abrirVentanaTabla() {
        VentanaTabla vtabla = new VentanaTabla(gestor);
    }

    private void visualizarSismos() {
        if (itemVisualizar.isSelected()) {
            gestor.dibujarSismos();
        } else {
            panelCentral.borrarSismos();
        }
    }

    private void dibujarSismos(List<Sismo> lista) {        
        panelCentral.dibujarSismos(lista);
    }
}
