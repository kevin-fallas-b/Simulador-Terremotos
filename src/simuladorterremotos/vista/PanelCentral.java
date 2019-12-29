/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Kevin
 */
public class PanelCentral extends JPanel {

    public PanelCentral() {
        super();
        configurar();
    }

    private void configurar() {
        setLayout(new GridLayout(1, 1));
        this.add(new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        ));
    }

}
