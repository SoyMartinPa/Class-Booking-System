package Logica.Filtros;
import Logica.Reservas.Reserva;

/**
 * Filtra las reservas cuya tarifa sea inferior a la tarifa ingresada.
 */
public class FiltroTarifaMax implements FiltroInterface<Reserva>{
    private final int tarifaAFiltrar;

    public FiltroTarifaMax(int tarifa) {
        this.tarifaAFiltrar = tarifa;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        return (reserva.getTarifa() <= tarifaAFiltrar);
    }
}
