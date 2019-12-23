/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import simuladorterremotos.control.ControlSimulador;
import simuladorterremotos.vista.VentanaAplicacion;

/**
 *
 * @author Kevin
 */
public class SimuladorTerremotos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }

        new SimuladorTerremotos().iniciar();
    }

    private void iniciar() {
        SwingUtilities.invokeLater(() -> {
            new VentanaAplicacion("Simulador UNA", new ControlSimulador()).init();
        });
    }

}
