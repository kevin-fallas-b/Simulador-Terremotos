/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.clases;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author lusiu
 */
public class Sismo {
    private int id;
    private int sc;
    private LocalDate fecha;
    private double longitud;
    private double latitud;
    private double magnitud;
    private double profundidad;

    public Sismo() {
    }

    public Sismo(int id, int sc, LocalDate fecha, double longitud, double latitud, double magnitud, double profundidad) {
        this.id = id;
        this.sc = sc;
        this.fecha = fecha;
        this.longitud = longitud;
        this.latitud = latitud;
        this.magnitud = magnitud;
        this.profundidad = profundidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }
    
    @Override
    public String toString(){
        return id + " " + sc + " " + fecha + " " + longitud + " " + latitud + " " + magnitud + " " + profundidad;
    }
    
}
