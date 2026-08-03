package Logica.Filtros;
import Logica.Reservas.Reserva;

/**
 * Filtra las reservas cuyos cupos maximos coincidan con el de la reserva.
 */
public class FiltroCuposMax implements FiltroInterface<Reserva> {
    private final int cuposAFiltrar;


    public FiltroCuposMax(int cupos) {
        this.cuposAFiltrar = cupos;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        if (cuposAFiltrar <= 0 ) {return true;}
        return (reserva.getCuposMax() <= (cuposAFiltrar));
    }
}
