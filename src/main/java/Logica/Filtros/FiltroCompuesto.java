package Logica.Filtros;

import Logica.Reservas.Reserva;

import java.util.ArrayList;
import java.util.List;

public class FiltroCompuesto implements FiltroInterface<Reserva> {

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
    public boolean pasaElFiltro(Reserva reserva) {

        for (FiltroInterface<Reserva> filtro : listaFiltros){
            if (!filtro.pasaElFiltro(reserva)) {
                return false;
            }
        }
        return true;
    }
}
