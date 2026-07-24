package Logica.Filtros;

import Logica.Enumeraciones.BloquesHorarios;
import Logica.GestorHorarios.Horario;
import Logica.GestorReserva.Reserva;

public class FiltroBloque implements FiltroInterface<Reserva>{
    private final BloquesHorarios bloqueAFiltrar;

    public FiltroBloque(BloquesHorarios bloque) {
        this.bloqueAFiltrar = bloque;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        return (reserva.getHorario().getBloquehorario() == (bloqueAFiltrar));
    }
}
