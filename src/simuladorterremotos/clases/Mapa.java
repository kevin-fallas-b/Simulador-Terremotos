/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lusiu
 */
@XmlRootElement(name = "base-map")
public class Mapa {
    
    @XmlElement
    private ListaCoordenadas coordinates;
    @XmlElement
    private Imagen image;

    public Mapa() {
        image = new Imagen();
        coordinates = new ListaCoordenadas();
    }
    
    public String toString(){
        return "Imagen: "+image.toString()+"\nCoordenadas:\n"+coordinates.toString();
    }
    
    
}
