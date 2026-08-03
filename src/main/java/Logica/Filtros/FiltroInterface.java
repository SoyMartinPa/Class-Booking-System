package Logica.Filtros;

import java.util.List;

/**
 * Define un criterio de filtrado para objetos de un tipo determinado.
 *
 * @param <T> tipo de objeto que puede evaluarse mediante el filtro.
 */

public interface FiltroInterface<T> {


    /**
     * Determina si un objeto cumple el criterio definido por el filtro.
     *
     * @param objeto objeto que será evaluado (principalmente objeto 'Reserva').
     * @return {@code true} si el objeto satisface el criterio del filtro;
     *         {@code false} en caso contrario.
     */
    boolean pasaElFiltro(T objeto);
    
    
}
