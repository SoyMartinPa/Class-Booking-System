package Logica.Enumeraciones;

/**
 * Representa los días disponibles para agendar reservas
 */
public enum Dias {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES;
    
    @Override
    public String toString() {
        String texto = name().toLowerCase();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
