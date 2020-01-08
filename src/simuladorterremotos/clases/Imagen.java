/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.clases;

import java.net.URI;
import javax.xml.bind.annotation.XmlElement;
import simuladorterremotos.util.PathUtils;

/**
 *
 * @author lusiu
 */
public class Imagen {
    
    Dimension dimension;
    URI url;
    private String absolutePath;

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
        this.absolutePath = PathUtils.getWorkingDirectory()+"/src/simuladorterremotos/resource/"+url.toString();
    }
    
    public String toString(){
        return "URL: "+url+"\nImagen:\n"+dimension.toString();
    }

    public String getAbsolutePath() {
        return absolutePath;
    }
    
}
