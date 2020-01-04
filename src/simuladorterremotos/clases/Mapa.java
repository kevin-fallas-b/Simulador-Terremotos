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
    /*
    try {
            JAXBContext ctx = JAXBContext.newInstance(Mapa.class);
            Unmarshaller mrs = ctx.createUnmarshaller();
            Mapa mapa = (Mapa) mrs.unmarshal(new File("../map.xml"));
            System.out.println(mapa);

        } catch (JAXBException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    */
    
}
