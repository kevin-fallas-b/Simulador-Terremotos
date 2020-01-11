package simuladorterremotos.util;

import simuladorterremotos.clases.Latitud;
import simuladorterremotos.clases.Longitud;



public class ConversionUtil {

    //  Conversiones entre pixeles y longitud
    public static double pixelesALongitud(int x) {
        double t = x - 86;
        t = t / 577;
        t *= 3;
        return -86 + t;
    }

   
    public static int longitudAPixeles(double longitud) {
        double t = longitud, aux = 577, aux2 = 86;
        t += aux2;
        t /= 3;
        t *= aux;
        t += aux2;
        return (int) t;
    }

    //  Conversiones entre Pixeles y latitud

    public static double pixelesALatitud(int y) {
        double t = y - 67;
        t = t / 569;
        t *= -3;
        return 11 + t;
    }

    
    public static int latitudAPixeles(double latitud) {
        double t = -latitud + 11;
        t /= 3;
        t *= 569;
        t += 67;
        return (int) t;
    }

   
    // conversiones relaciones a sexagecimal
    
    public static Latitud latitudASexagecimal(double latitud) {

        double min, seg;       
        min = latitud % 1;
        min *= 60;
        seg = min % 1;
        seg *= 60;

        return new Latitud((int) latitud, (int) min, (int) seg, "N");
    }

    public static double latitudSexagecimal_Decimal(Latitud latitud) {
        double aux = latitud.getMinutos();
        aux /= 60;
        double aux2 = latitud.getSegundos();
        aux2 /= 3600;
        aux += aux2;
        aux += latitud.getGrados();
        return aux;
    }

    public static int latitudSexagecimal_Pixel(Latitud latitud) {
        double aux = latitudSexagecimal_Decimal(latitud);
        return latitudAPixeles(aux);
    }

    
    public static Longitud longitudASexadecimal(double longitud) {

        double min, seg;
        longitud = -longitud;
        min = longitud % 1;
        min *= 60;
        seg = min % 1;
        seg *= 60;
        return new Longitud((int) longitud, (int) min, (int) seg, "W");
    }

    public static double longitudSexagecimal_Decimal(Longitud longitud) {
        double aux = longitud.getMinutos();
        aux /=  60;
        double aux2 = longitud.getSegundos();
        aux2 /= 3600;
        aux += aux2;
        aux += longitud.getGrados();
        return -aux;
    }

    public static int longitudSexagecimal_Pixel(Longitud longitud) {
        double aux = longitudSexagecimal_Decimal(longitud);
        return longitudAPixeles(aux);
    }

}
