package Logica.Filtros;

import Logica.Reservas.Reserva;

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
