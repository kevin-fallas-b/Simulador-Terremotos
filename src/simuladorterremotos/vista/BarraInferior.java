/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.vista;

import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import simuladorterremotos.util.ConversionUtil;

/**
 *
 * @author Kevin
 */
public class BarraInferior extends JPanel {

    private Label etiquetaMensaje = new Label();

    public BarraInferior() {
        super();
        configurar();
    }

    private void configurar() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        add(etiquetaMensaje);
        mostrarMensaje(0, 0);
    }

    public void mostrarMensaje(Integer x, Integer y) {
        //aqui falta hacer la conversion de cordenadas x,y a cordenadas que pide el profe

        etiquetaMensaje.setText(ConversionUtil.latitudASexagecimal(ConversionUtil.pixelesALatitud(y)) + ConversionUtil.longitudASexadecimal(ConversionUtil.pixelesALongitud(x)).toString());
    }
}
