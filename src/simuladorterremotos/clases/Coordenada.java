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

public class Coordenada {
    PosicionImagen posImagen;
    PosicionMapa posMapa;

    public Coordenada() {
    }

    public Coordenada(PosicionImagen posImagen, PosicionMapa posMapa) {
        this.posImagen = posImagen;
        this.posMapa = posMapa;
    }

    public PosicionImagen getPosImagen() {
        return posImagen;
    }
    @XmlElement(name = "image-position")
    public void setPosImagen(PosicionImagen posImagen) {
        this.posImagen = posImagen;
    }

    public PosicionMapa getPosMapa() {
        return posMapa;
    }
    @XmlElement(name = "map-position")
    public void setPosMapa(PosicionMapa posMapa) {
        this.posMapa = posMapa;
    }
    
    @Override
    public String toString(){
        return "Imagen:\n"+posImagen.toString()+"\nMapa:\n"+posMapa.toString();
    }
}
