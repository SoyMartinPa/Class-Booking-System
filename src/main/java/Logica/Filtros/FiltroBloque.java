package Logica.Filtros;

import Logica.Enumeraciones.BloquesHorarios;
import Logica.GestorHorarios.Horario;
import Logica.GestorReserva.Reserva;

public class FiltroBloque<T extends Reserva> implements FiltroInterface<T>{
    private final BloquesHorarios bloqueAFiltrar;

    public FiltroBloque(BloquesHorarios bloque) {
        this.bloqueAFiltrar = bloque;
    }

    @Override
    public boolean esFiltrado(Reserva reserva) {
        return (reserva.getHorario().getBloquehorario().equals(bloqueAFiltrar));
    }
}
