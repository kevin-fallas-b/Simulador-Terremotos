/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lusiu
 */
@XmlRootElement(name = "base-map")
public class Mapa {
    
    @XmlElement
    private ListaCoordenadas coordenadas;
    @XmlElement
    private Imagen imagen;

    public Mapa() {
        imagen = new Imagen();
        coordenadas = new ListaCoordenadas();
    }
    
    public String toString(){
        return "Imagen: "+imagen.toString()+"\nCoordenadas:\n"+coordenadas.toString();
    }

    public ListaCoordenadas getCoordinates() {
        return coordenadas;
    }

    public void setCoordinates(ListaCoordenadas coordinates) {
        this.coordenadas = coordinates;
    }

    public Imagen getImage() {
        return imagen;
    }

    public void setImage(Imagen image) {
        this.imagen = image;
    }
   
}
