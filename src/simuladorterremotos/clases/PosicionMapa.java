/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author lusiu
 */
public class PosicionMapa {
    
    Longitud longitud;
    Latitud latitud;

    public PosicionMapa() {
    }

    public PosicionMapa(Longitud longitud, Latitud latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Longitud getLongitud() {
        return longitud;
    }
    @XmlElement(name = "longitude")
    public void setLongitud(Longitud longitud) {
        this.longitud = longitud;
    }

    public Latitud getLatitud() {
        return latitud;
    }
    @XmlElement(name = "latitude")
    public void setLatitud(Latitud latitud) {
        this.latitud = latitud;
    }
    
    @Override
    public String toString(){
        return "Longitud:\n"+longitud.toString()+"\nLatitud:\n"+latitud.toString(); 
    }
}
