/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.control;

import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Observer;
import simuladorterremotos.modelo.ModeloSimulador;

/**
 *
 * @author Kevin
 */
public class ControlSimulador {

    private ModeloSimulador modelo;

    public ControlSimulador() {
        this.modelo = new ModeloSimulador();
    }

    public void registrar(Observer nuevoObservador) {
        modelo.addObserver(nuevoObservador);
    }

    public void suprimir(Observer observador) {
        modelo.deleteObserver(observador);
        if (modelo.countObservers() == 0) {
            System.exit(0);
        }
    }
    
    public void dibujarLineas(MouseEvent e){
      modelo.DibujarLineas(e);
    }

    public void cerrarAplicacion() {
       modelo.deleteObservers();
       System.exit(0);
    }

    public void cambiarArchivoDeDatos(File selectedFile) {
        modelo.setArchivoDatos(selectedFile);
    }

    public String solicitarNombreArchivoDatos() {
        return modelo.getNombreArchivoDatos();
    }

}
