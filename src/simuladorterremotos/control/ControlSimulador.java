/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.control;

import java.awt.event.MouseEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Observer;
import simuladorterremotos.clases.Sismo;
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

    public List<Sismo> getSismos(){
        return modelo.getSismos();
    }
    
    public void FiltrarSismos(){
        modelo.setSismosFiltrados();
    }
    
    public void LeerTxt(){
        modelo.LeerTxt();
    }

    public void dibujarSismos() {
        modelo.dibujarSismos();
    }

    public void borrarSismos() {
    }
    
    public void setFechaInicio(LocalDate fecha){
        modelo.setFechaInicio(fecha);
    }
    
    public void setFechaFinal(LocalDate fecha){
        modelo.setFechaFinal(fecha);
    }
    
    public void setMagnitudInicio(double magnitud){
        modelo.setMagnitudInicio(magnitud);
    }
    
    public void setMagnitudFinal(double magnitud){
        modelo.setMagnitudFinal(magnitud);
    }
}
