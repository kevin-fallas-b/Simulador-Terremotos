/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import simuladorterremotos.control.ControlSimulador;

/**
 *
 * @author Kevin
 */
public class VentanaAplicacion extends JFrame implements Observer {

    private final ControlSimulador gestor;

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
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void init() {
        gestor.registrar(this);
    }

    private void cerrarVentana() {
        gestor.suprimir(this);
        dispose();
    }
}
