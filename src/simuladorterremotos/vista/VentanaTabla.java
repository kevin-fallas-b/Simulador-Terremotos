/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import simuladorterremotos.clases.Sismo;
import simuladorterremotos.control.ControlSimulador;

/**
 *
 * @author lusiu
 */
public class VentanaTabla extends JFrame implements Observer {

    private ControlSimulador gestor;
    private List<Sismo> sismos;
    DefaultTableModel tableModel;

    public VentanaTabla(ControlSimulador gestor) {
        this.gestor = gestor;
        sismos = new ArrayList<>();
        Configurar();

    }

    private void Configurar() {
        setResizable(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(400, 400));
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });
        ajustarComponentes(this);
        try {
            setIconImage(ImageIO.read(VentanaTabla.class.getResourceAsStream("../resource/icon.png")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ajustarComponentes(Container c) {
        String[] columnNames
                = {"Id",
                    "Secuencia",
                    "Fecha",
                    "Latitud",
                    "Longitud",
                    "Magnitud",
                    "Profundidad"
                };

        tableModel = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(tableModel);
        
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(table);
        table.setSize(200, 200);

        c.add(scroll);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof List) {
            sismos = (List<Sismo>) arg;
            llenarTabla();
        }
    }

    private void llenarTabla() {
        tableModel.setRowCount(0);
        for (int i = 0; i < sismos.size(); i++) {

            int id = sismos.get(i).getId();
            int sc = sismos.get(i).getSc();
            LocalDate fecha = sismos.get(i).getFecha();
            double latitud = sismos.get(i).getLatitud();
            double longitud = sismos.get(i).getLongitud();
            double magnitud = sismos.get(i).getMagnitud();
            double profundidad = sismos.get(i).getProfundidad();

            Object[] data = {id, sc, fecha, latitud, longitud, magnitud, profundidad};

            tableModel.addRow(data);
        }
    }

    private void cerrarVentana() {
        gestor.suprimir(this);
        dispose();
    }

    public void init() {
        gestor.registrar(this);
        setVisible(true);
        gestor.getSismosFiltrados();
    }

}
