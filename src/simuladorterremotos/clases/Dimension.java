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
public class Dimension {
    int height;
    int width;

    public Dimension() {
    }

    public Dimension(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    @XmlElement
    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    @XmlElement
    public void setWidth(int width) {
        this.width = width;
    }
    
    @Override
    public String toString(){
        return "Altura: "+height+" Ancho: "+width;
    }
}
