/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.clases;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author lusiu
 */
public class Longitud {
    int grados;
    int minutos;
    int segundos;
    String direccion;

    public Longitud() {
    }

    public Longitud(int Grados, int minutos, int segundos, String direccion) {
        this.grados = Grados;
        this.minutos = minutos;
        this.segundos = segundos;
        this.direccion = direccion;
    }

    public int getGrados() {
        return grados;
    }
    @XmlElement(name = "longitude-degrees")
    public void setGrados(int Grados) {
        this.grados = Grados;
    }

    public int getMinutos() {
        return minutos;
    }
    @XmlElement(name = "minutes")
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }
    @XmlElement(name = "seconds")
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getDireccion() {
        return direccion;
    }
    @XmlElement(name = "longitude-direction")
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString(){
        return "Grados: "+grados+"\n\tMinutos:"+minutos+"\n\tSegundos: "+segundos+"\n\tDireccion: "+direccion;
    }
}
