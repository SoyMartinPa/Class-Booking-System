package Logica.Filtros;

import Logica.Enumeraciones.Materias;
import Logica.GestorReserva.Reserva;
import Logica.Perfiles.PerfilBasico;

import java.rmi.server.RemoteRef;
import java.rmi.server.RemoteServer;

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
