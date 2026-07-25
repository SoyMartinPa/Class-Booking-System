package Logica.Filtros;

import Logica.Enumeraciones.Materias;
import Logica.Reservas.Reserva;

public class FiltroMateria implements FiltroInterface<Reserva>{

    private final Materias materiaAFiltrar;

    public FiltroMateria(Materias materia) {
        this.materiaAFiltrar = materia;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        return (reserva.getMateria() == (materiaAFiltrar));
    }
}
