package simuladorterremotos.util;

import simuladorterremotos.clases.Latitud;
import simuladorterremotos.clases.Longitud;



public class ConversorGrados {

    //  Los siguientes dos metodos son conversiones realcionadas a la Longitud
    public static double convertirPixeles_GeograficasLongitud(int x) {
        double t = x - 86;
        t = t / 577;
        t *= 3;
        return -86 + t;
    }

   
    public static int convertirLongitud_Pixeles(double longitud) {
        double t = longitud, aux = 577, aux2 = 86;
        t += aux2;
        t /= 3;
        t *= aux;
        t += aux2;
        return (int) t;
    }

    //  Los siguientes dos metodos son conversiones realcionadas a la Latitud

    public static double convertirPixeles_GeograficasLatitud(int y) {
        double t = y - 67;
        t = t / 569;
        t *= -3;
        return 11 + t;
    }

    
    public static int convertirLatitud_Pixeles(double latitud) {
        double t = -latitud + 11;
        t /= 3;
        t *= 569;
        t += 67;
        return (int) t;
    }

   
    public static Latitud convertirLatitud_Sexagecimal(double latitud) {

        double min, seg;       
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
    }

    public static int convertirLatitudSexagecimal_pixel(Latitud latitud) {
        double aux = convertirLatitudSexagecimal_Decimal(latitud);
        return convertirLatitud_Pixeles(aux);
    }

    
    public static Longitud convertirLongitud_Sexagecimal(double longitud) {

        double min, seg;
        longitud = -longitud;
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
    }

    public static int convertirLongitudSexagecimal_pixel(Longitud longitud) {
        double aux = convertirLongitudSexagecimal_Decimal(longitud);
        return convertirLongitud_Pixeles(aux);
    }

}
