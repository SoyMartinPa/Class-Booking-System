package Logica.Filtros;
import Logica.GestorReserva.Reserva;

public class FiltroNombre<T extends Reserva> implements FiltroInterface<T> {
    private final String nombreAFiltrar;

    public FiltroNombre(String nombre) {
        this.nombreAFiltrar = nombre;
    }

    @Override
    public boolean esFiltrado(Reserva reserva) {
        return (reserva.getTutorAsociado().getNombre().equals(nombreAFiltrar));
    }
}
