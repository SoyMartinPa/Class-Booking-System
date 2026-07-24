package Logica.Filtros;

import Logica.GestorReserva.Reserva;

public class FiltroTarifaMax<T extends Reserva> implements FiltroInterface<T>{
    private final int tarifaAFiltrar;

    public FiltroTarifaMax(int tarifa) {
        this.tarifaAFiltrar = tarifa;
    }

    @Override
    public boolean esFiltrado(Reserva reserva) {
        return (reserva.getTarifa() <= tarifaAFiltrar);
    }
}
