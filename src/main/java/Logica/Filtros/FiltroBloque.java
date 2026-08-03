package Logica.Filtros;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Reservas.Reserva;


/**
 * Filtra las reservas cuyo bloque horario coincide con el bloque especificado.
 */
public class FiltroBloque implements FiltroInterface<Reserva> {
    private final BloquesHorarios bloqueAFiltrar;


    public FiltroBloque(BloquesHorarios bloque) {
        this.bloqueAFiltrar = bloque;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        if (bloqueAFiltrar == null){return true;}        
        return (reserva.getHorario().getBloqueHorario() == (bloqueAFiltrar));
    }

    
    
    
}
