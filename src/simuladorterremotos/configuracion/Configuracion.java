package simuladorterremotos.configuracion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import simuladorterremotos.util.PathUtils;

public class Configuracion extends Properties {

    private Configuracion() {
    }

    public static Configuracion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
            try {
                System.out.println("Cargando configuración por defecto..");
                instancia.load(Configuracion.class.getResourceAsStream(ARCHIVO_CONFIGURACION));

                    rutaConfiguracion = PathUtils.getUserPath(instancia.getProperty("archivo_configuracion"));
                System.out.printf("Cargando configuración del usuario: '%s'..%n", rutaConfiguracion);
                instancia.load(new FileInputStream(rutaConfiguracion));

            } catch (IOException ex) {
                System.err.printf("No se pudo cargar el archivo de configuración: '%s'..%n", ARCHIVO_CONFIGURACION);
                System.err.println(ex.getMessage());
            }
        }
        return instancia;
    }

    public void cambiarArchivoDatos(String rutaArchivo) {
        setProperty("archivo_datos", rutaArchivo);
    }

    public void guardarConfiguracion() {
        if (rutaConfiguracion != null) {
            try {
                System.out.println("Actualizando archivo de configuración..");
                store(new FileOutputStream(rutaConfiguracion), getClass().getCanonicalName());
            } catch (IOException ex) {
                System.err.printf("No se pudo actualizar el archivo de configuración: '%s'..%n", ARCHIVO_CONFIGURACION);
                System.err.println(ex.getMessage());
            }
        } else {
            System.err.printf("No está definida la ruta del archivo de configuración..");
        }
    }

    private static final String ARCHIVO_CONFIGURACION = "config.properties";
    private static Configuracion instancia = null;
    private static String rutaConfiguracion = null;
}
