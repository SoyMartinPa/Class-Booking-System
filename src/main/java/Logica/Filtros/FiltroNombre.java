package Logica.Filtros;
import Logica.Reservas.Reserva;

public class FiltroNombre implements FiltroInterface<Reserva> {
    private final String nombreAFiltrar;

    public FiltroNombre(String nombre) {
        this.nombreAFiltrar = nombre;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        return (reserva.getTutorAsociado().getNombre().equals(nombreAFiltrar));
    }
}
