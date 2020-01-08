/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorterremotos.util;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import simuladorterremotos.clases.Mapa;

/**
 *
 * @author Kevin
 */
public class XmlUtil {

    private static XmlUtil INSTANCIA = null;
    private final String XML = "map.xml"; //nombre del XML ubicado dentro de la carpeta de resources el cual va a ser leido
    private Mapa mapa;

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

    public Mapa getMapa() {
        return mapa;
    }

    private void leerXml() {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Mapa.class);
            Unmarshaller mrs = ctx.createUnmarshaller();
            mapa = (Mapa) mrs.unmarshal(new File(PathUtils.getWorkingDirectory() + "/src/simuladorterremotos/resource/" + XML));
        } catch (JAXBException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

    }
}
