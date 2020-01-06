/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import simuladorterremotos.control.ControlSimulador;

/**
 *
 * @author Kevin
 */
public class VentanaParametros extends JFrame implements Observer {

    private ControlSimulador gestor;

    public VentanaParametros(ControlSimulador gestor) {
        super("Ajuste de parametros");
        this.gestor = gestor;
        configurar();
    }

    private void configurar() {
        setSize(new Dimension(600, 400));
        setResizable(false);
        setMinimumSize(new Dimension(300, 250));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gestor.suprimir(VentanaParametros.this);
                dispose();
            }
        });
    }

    void init() {
        gestor.registrar(this);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
    }

}
