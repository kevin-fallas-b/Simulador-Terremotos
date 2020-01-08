/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.util;

/**
 *
 * @author Kevin
 */
public class XmlUtil {

    private static XmlUtil INSTANCIA = null;
    private final String XML = "map.xml"; //nombre del XML ubicado dentro de la carpeta de resources el cual va a ser leido

    private XmlUtil() {
        leerXml();
    }

    private static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new XmlUtil();
        }
    }

    public static XmlUtil getInstance() {
        if (INSTANCIA == null) {
            createInstance();
        }
        return INSTANCIA;
    }

    private void leerXml() {

    }
}
