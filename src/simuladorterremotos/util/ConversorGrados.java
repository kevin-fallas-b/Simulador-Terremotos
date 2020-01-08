package simuladorterremotos.util;

import simuladorterremotos.clases.Latitud;
import simuladorterremotos.clases.Longitud;



/**
 *
 * @author Kenneth Sibaja
 */
public class ConversorGrados {

    //  Los siguientes dos metodos son conversiones realcionadas a la Longitud
    /**
     * Este metodo convierte un pixel del eje x de la pantalla en una coordenada
     * geografica decimal de logitud
     *
     * @param x valor del pixel entrante
     * @return valor de la longitud resultante
     */
    public static double convertirPixeles_GeograficasLongitud(int x) {
        double t = x - 86;
        t = t / 577;
        t *= 3;
        return -86 + t;
    }

    /**
     * Este metodo convierte la coordenada decimal de la longitud a un pixel del
     * eje x de la pantalla
     *
     * @param longitud coordenada a convertir
     * @return valor del pixel del eje x resultante
     */
    public static int convertirLongitud_Pixeles(double longitud) {
        double t = longitud, aux = 577, aux2 = 86;
        t += aux2;
        t /= 3;
        t *= aux;
        t += aux2;
        return (int) t;
    }

    //  Los siguientes dos metodos son conversiones realcionadas a la Latitud
    /**
     * Este metodo convierte un pixel del eje y de la pantalla en una coordenada
     * geografica decimal de latitud
     *
     * @param y valor del pixel entrante
     * @return valor de la latitud resultante
     */
    public static double convertirPixeles_GeograficasLatitud(int y) {
        double t = y - 67;
        t = t / 569;
        t *= -3;
        return 11 + t;
    }

    /**
     * Este metodo convierte la coordenada decimal de la latitud a un pixel del
     * eje y de la pantalla
     *
     * @param latitud coordenada a convertir
     * @return valor del pixel del eje x resultante
     */
    public static int convertirLatitud_Pixeles(double latitud) {
        double t = -latitud + 11;
        t /= 3;
        t *= 569;
        t += 67;
        return (int) t;
    }

    /**
     * Este ultimo metodo convierte coordenadas decimales a coordenadas
     * sexagecimales
     *
     * @param latitud
     * @return string que contiene latitud sexagecimal
     */
    public static Latitud convertirLatitud_Sexagecimal(double latitud) {

        double min, seg;
        //  Convertimos los grados de la latitud        
        min = latitud % 1;
        min *= 60;
        seg = min % 1;
        seg *= 60;

        return new Latitud((int) latitud, (int) min, (int) seg, "N");
    }

    public static double convertirLatitudSexagecimal_Decimal(Latitud latitud) {
        double aux = latitud.getMinutos();
        aux /= 60;
        double aux2 = latitud.getSegundos();
        aux2 /= 3600;
        aux += aux2;
        aux += latitud.getGrados();
        return aux;
//          return  (latitud.getGrados() + (latitud.getMinutos()/60) + (latitud.getSegundos() / 60));
    }

    public static int convertirLatitudSexagecimal_pixel(Latitud latitud) {
        double aux = convertirLatitudSexagecimal_Decimal(latitud);
        return convertirLatitud_Pixeles(aux);
    }

    /**
     * Este metodo convierte coordenadas decimales a coordenadas sexagecimales
     *
     * @param longitud
     * @return string que contiene longitud sexagecimal
     */
    public static Longitud convertirLongitud_Sexagecimal(double longitud) {

        double min, seg;
        longitud = -longitud;
        //  Ahora, convertimos los grados de la longitud        
        min = longitud % 1;
        min *= 60;
        seg = min % 1;
        seg *= 60;
        return new Longitud((int) longitud, (int) min, (int) seg, "W");
    }

    public static double convertirLongitudSexagecimal_Decimal(Longitud longitud) {
        double aux = longitud.getMinutos();
        aux /=  60;
        double aux2 = longitud.getSegundos();
        aux2 /= 3600;
        aux += aux2;
        aux += longitud.getGrados();
        return -aux;
//        return -(longitud.getGrados() + (longitud.getMinutos() / 60) + (longitud.getSegundos() / 60));
    }

    public static int convertirLongitudSexagecimal_pixel(Longitud longitud) {
        double aux = convertirLongitudSexagecimal_Decimal(longitud);
        return convertirLongitud_Pixeles(aux);
    }

}
