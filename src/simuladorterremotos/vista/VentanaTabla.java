/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import simuladorterremotos.clases.Sismo;
import simuladorterremotos.control.ControlSimulador;

/**
 *
 * @author lusiu
 */
public class VentanaTabla extends JFrame{

    private ControlSimulador gestor;

    public VentanaTabla(ControlSimulador gestor) {
        this.gestor = gestor;
        Configurar();
    }

    private void Configurar() {
        setResizable(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(400, 400));
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        ajustarComponentes(this);
    }

    private void ajustarComponentes(Container c) {
        String[] columnNames =
        {   "Id",
            "Secuencia",
            "Fecha",
            "Latitud",
            "Longitud",
            "Magnitud",
            "Profundidad"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        
        List<Sismo> sismos = gestor.getSismos();
        for(int i = 0;i < sismos.size();i++){
            int id = sismos.get(i).getId();
            int sc = sismos.get(i).getSc();
            LocalDate fecha = sismos.get(i).getFecha();
            double latitud = sismos.get(i).getLatitud();
            double longitud = sismos.get(i).getLongitud();
            double magnitud = sismos.get(i).getMagnitud();
            double profundidad = sismos.get(i).getProfundidad();
            Object[] data = {id,sc,fecha,latitud,longitud,magnitud,profundidad};
            tableModel.addRow(data);
        }

        JTable table = new JTable(tableModel);
        
        
        
        JScrollPane scroll = new JScrollPane(table);
        table.setSize(200,200);
        
        c.add(scroll);
    }
    
    
    
}
