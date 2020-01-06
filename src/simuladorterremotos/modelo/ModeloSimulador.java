/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.modelo;

import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Observable;

/**
 *
 * @author Kevin
 */
public class ModeloSimulador extends Observable{
    
    private File archivoDatos;
    
    public void DibujarLineas(MouseEvent e){
        setChanged();
        notifyObservers(e);
    }
    
    public void setArchivoDatos(File archivo){
        this.archivoDatos = archivo;
    }

    public String getNombreArchivoDatos() {
        if(archivoDatos!=null){
            return archivoDatos.getName();
        }else{
            return "";
        }
    }
}
