/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import simuladorterremotos.control.ControlSimulador;

/**
 *
 * @author Kevin
 */
public class VentanaDatos extends JFrame implements Observer {

    private ControlSimulador gestor;
    private JButton btnSeleccionarArchivo;
    private JTextField campoArchivoSeleccionado;

    public VentanaDatos(ControlSimulador gestor) {
        super("Seleccion de archivo de datos");
        this.gestor = gestor;
        configurar();
    }

    private void configurar() {
        setSize(new Dimension(600, 250));
        setResizable(false);
        setMinimumSize(new Dimension(300, 50));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gestor.suprimir(VentanaDatos.this);
                dispose();
            }

        });
        ajustarComponents(getContentPane());
    }
    
     private void ajustarComponents(Container c) {
         c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;

        c.add(new JLabel("Archivo Seleccionado: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        c.add(campoArchivoSeleccionado = new JTextField(), gbc);
        campoArchivoSeleccionado.setEditable(false);
        
        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        c.add(btnSeleccionarArchivo = new JButton("Seleccionar Archivo"), gbc);

       
        c.add(new JPanel(), gbc);

       

        btnSeleccionarArchivo.addActionListener((ActionEvent e) -> {
            escogerArchivo();
        });

    }
    
    public void init(){
         gestor.registrar(this);
         setVisible(true);
         campoArchivoSeleccionado.setText(gestor.solicitarNombreArchivoDatos());
    }
    
    private void escogerArchivo(){
         JFileChooser fc = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
         fc.setAcceptAllFileFilterUsed(false);
         fc.setFileFilter(filter);
         if(fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION){
             gestor.cambiarArchivoDeDatos(fc.getSelectedFile());
             campoArchivoSeleccionado.setText(fc.getSelectedFile().getName());
         }
    }

    @Override
    public void update(Observable o, Object arg) {
    }

}
