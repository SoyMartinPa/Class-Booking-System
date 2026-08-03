package Logica.Filtros;
import Logica.Reservas.Reserva;
/**
 * Filtra las reservas cuyo nombre del tutor asociado coincida con el nombre especificado.
 */
public class FiltroNombre implements FiltroInterface<Reserva> {
    private final String nombreAFiltrar;

    public FiltroNombre(String nombre) {
        this.nombreAFiltrar = nombre;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        if (nombreAFiltrar.equals("")){return true;}
        return (reserva.getTutorAsociado().getNombre().equals(nombreAFiltrar));
    }
}
