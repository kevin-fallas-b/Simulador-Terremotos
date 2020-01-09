/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.modelo;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import simuladorterremotos.clases.Sismo;

/**
 *
 * @author Kevin
 */
public class ModeloSimulador extends Observable {

    private File archivoDatos;

    private List<Sismo> sismos;
    private List<Sismo> sismosFiltrados;

    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private double magnitudInicio;
    private double magnitudFinal;

    public ModeloSimulador() {
        sismos = new ArrayList();
        sismosFiltrados = new ArrayList();
    }

    public List<Sismo> getSismos() {
        return sismos;
    }

    public void setSismos(List<Sismo> sismos) {
        this.sismos = sismos;
    }
    
    public void DibujarLineas(MouseEvent e) {
        setChanged();
        notifyObservers(e);
    }

    public void setArchivoDatos(File archivo) {
        this.archivoDatos = archivo;
        LeerTxt();
    }

    public String getNombreArchivoDatos() {
        if (archivoDatos != null) {
            return archivoDatos.getName();
        } else {
            return "";
        }
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getMagnitudInicio() {
        return magnitudInicio;
    }

    public void setMagnitudInicio(double magnitudInicio) {
        this.magnitudInicio = magnitudInicio;
    }

    public double getMagnitudFinal() {
        return magnitudFinal;
    }

    public void setMagnitudFinal(double magnitudFinal) {
        this.magnitudFinal = magnitudFinal;
    }

    public List<Sismo> getSismosFiltrados() {
        return sismosFiltrados;
    }

    public void LeerTxt() {
        try {
            FileReader f = new FileReader(archivoDatos);
            BufferedReader b = new BufferedReader(f);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            char y;
            String x = "";
            Sismo sismo;
            int aux = 0;

            while (!eof(b)) {
                sismo = new Sismo();

                while ((y = (char) b.read()) != '\t') {
                    x = x + y;
                }
                sismo.setId(Integer.valueOf(x));
                x = "";

                while ((y = (char) b.read()) != '\t') {
                    x = x + y;
                }
                sismo.setSc(Integer.valueOf(x));
                x = "";

                while ((y = (char) b.read()) != '\t') {
                    x = x + y;
                }
                x = AcomodarSting(x);
                sismo.setFecha(LocalDate.parse(x, format));
                x = "";

                while ((y = (char) b.read()) != '\t') {
                    x = x + y;
                }
                sismo.setLongitud(Double.valueOf(x));
                x = "";

                while ((y = (char) b.read()) != '\t') {
                    x = x + y;
                }
                sismo.setLatitud(Double.valueOf(x));
                x = "";

                while ((y = (char) b.read()) != '\t') {
                    x = x + y;
                }
                sismo.setMagnitud(Double.valueOf(x));
                x = "";

                while (!eof(b) && (y = (char) b.read()) != '\n') {
                    x = x + y;
                }
                if (aux == -1) {
                    System.out.println("ya");
                }
                sismo.setProfundidad(Double.valueOf(x));
                x = "";

                sismos.add(sismo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error archivo");
        } catch (IOException ex) {
            System.out.println("Error");
        }

//       sismos.forEach(x->{
//           System.out.println(x.toString());
//       });
    }

    private boolean eof(BufferedReader r) throws IOException {
        r.mark(1);
        int i = r.read();
        r.reset();
        return i < 0;
    }

    private String AcomodarSting(String x) {
        String y = "";
        char[] fecha = x.toCharArray();
        int aux = 4;
        int cont = 2;
        if (fecha[1] == '-') {
            y = "0";
            for (int i = 0; i < 2; i++) {
                y = y + fecha[i];
            }
            aux = 3;
        } else {
            for (int i = 0; i < 3; i++) {
                y = y + fecha[i];
            }
            cont = 3;
        }

        if (fecha[aux] == '-') {
            y = y + "0";
            for (int i = cont; i < fecha.length; i++) {
                y = y + fecha[i];
            }
        } else {
            for (int i = cont; i < fecha.length; i++) {
                y = y + fecha[i];
            }
        }

        return y;
    }

    public void dibujarSismos() {
        setSismosFiltrados();
        setChanged();
        notifyObservers(sismosFiltrados);
    }

    public void setSismosFiltrados() {
        sismosFiltrados = sismos;

        System.out.println("se setiaron sismos filtrados" +sismos.size() + "filtrados "+sismosFiltrados.size());
        for (int i = 0; i < sismos.size(); i++) {
            if (fechaInicio != null && fechaFinal != null) {
                if (sismos.get(i).getFecha().isBefore(fechaFinal) && sismos.get(i).getFecha().isAfter(fechaInicio) && sismos.get(i).getMagnitud() > magnitudInicio && sismos.get(i).getMagnitud() < magnitudFinal) {
                    sismosFiltrados.add(sismos.get(i));
                }
            }
        }

//        for (int i = 0; i < sismos.size(); i++) {
//            if (fechaInicio != null && fechaFinal != null) {
//                if (sismos.get(i).getFecha().isBefore(fechaFinal) && sismos.get(i).getFecha().isAfter(fechaInicio) && sismos.get(i).getMagnitud() > magnitudInicio && sismos.get(i).getMagnitud() < magnitudFinal) {
//                    sismosFiltrados.add(sismos.get(i));
//                }
//            }
//        }

    }
}
