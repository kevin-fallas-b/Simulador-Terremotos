/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.Coordenada;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lusiu
 */
@XmlRootElement(name = "coordinates")
public class ListaCoordenadas {
    
    @XmlElement(name="coordinate")
    private List<Coordenada> coordenadas;

    public ListaCoordenadas() {
        coordenadas = new ArrayList();
    }
    
    @Override
    public String toString(){
        StringBuilder r = new StringBuilder("[\n");
        for (Coordenada p : coordenadas) {
            r.append(String.format("\t%s,\n", p));
        }
        r.append("]");
        return r.toString();
    }
    
}
