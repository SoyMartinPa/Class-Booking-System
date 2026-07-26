package Logica.Filtros;
import Logica.Reservas.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 * Filtra las reservas utilizando una lista de filtros.
 */

public class FiltroCompuesto implements FiltroInterface<Reserva> {

    private final List<FiltroInterface<Reserva>> listaFiltros;

    public FiltroCompuesto() {
        this.listaFiltros = new ArrayList<>();
    }

    /**
     * Agrega un filtro no incorporado a la lista de filtros
     * @param filtro filtro a incorporar
     */
    public void agregarFiltro(FiltroInterface<Reserva> filtro){
        if (!listaFiltros.contains(filtro)) {
            this.listaFiltros.add(filtro);
        }
    }
    /**
     * Elimina un filtro ya incorporado a la lista de filtros
     * @param filtro filtro a eliminar
     */
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
