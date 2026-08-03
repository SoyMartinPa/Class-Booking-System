package Logica.Filtros;
import Logica.Enumeraciones.Materias;
import Logica.Reservas.Reserva;

/**
 * Filtra las reservas cuya materia coincida con la materia especificada.
 */
public class FiltroMateria implements FiltroInterface<Reserva>{

    private final Materias materiaAFiltrar;

    public FiltroMateria(Materias materia) {
        this.materiaAFiltrar = materia;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        if (materiaAFiltrar == null){return true;}
        return (reserva.getMateria() == (materiaAFiltrar));
    }
}
