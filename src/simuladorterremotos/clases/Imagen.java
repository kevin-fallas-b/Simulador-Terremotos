/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.net.URI;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author lusiu
 */
public class Imagen {
    
    Dimension dimension;
    URI url;

    public Imagen() {
    }

    public Imagen(Dimension dimension, URI url) {
        this.dimension = dimension;
        this.url = url;
    }

    public Dimension getDimension() {
        return dimension;
    }
    @XmlElement
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public URI getUrl() {
        return url;
    }
    @XmlElement
    public void setUrl(URI url) {
        this.url = url;
    }
    
    public String toString(){
        return "URL: "+url+"\nImagen:\n"+dimension.toString();
    }
}
