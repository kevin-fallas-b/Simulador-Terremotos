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
public class CordenadaUtil {

    private static CordenadaUtil INSTANCE;
    private Integer anchoMapa;
    private Integer altoMapa;

    private void CordenadaUtil() {
        anchoMapa = (Integer) AppContext.getInstance().get("anchoMapa");
        altoMapa = (Integer) AppContext.getInstance().get("altoMapa");
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (CordenadaUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CordenadaUtil();
                }
            }
        }
    }

    public static CordenadaUtil getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public String convertirXaLongitud(Integer x) {
        return null;
    }
}
