package Logica.Filtros;

import Logica.GestorReserva.Reserva;

import java.util.ArrayList;
import java.util.List;

public class FiltroCompuesto<T extends Reserva> implements FiltroInterface<T> {

    private final List<FiltroInterface<Reserva>> listaFiltros;

    public FiltroCompuesto() {
        this.listaFiltros = new ArrayList<>();
    }
    public void agregarFiltro(FiltroInterface<Reserva> filtro){
        if (!listaFiltros.contains(filtro)) {
            this.listaFiltros.add(filtro);
        }
    }
    public void quitarFiltro(FiltroInterface<Reserva> filtro){
        if (listaFiltros.contains(filtro)) {
            this.listaFiltros.remove(filtro);
        }
    }

    @Override
    public boolean esFiltrado(Reserva reserva) {

        for (FiltroInterface<Reserva> filtro : listaFiltros){
            if (!filtro.esFiltrado(reserva)) {
                return false;
            }
        }
        return true;
    }
}
