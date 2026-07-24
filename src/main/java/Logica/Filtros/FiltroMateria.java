package Logica.Filtros;

import Logica.Enumeraciones.Materias;
import Logica.GestorReserva.Reserva;
import Logica.Perfiles.PerfilBasico;

import java.rmi.server.RemoteRef;
import java.rmi.server.RemoteServer;

public class FiltroMateria<T extends Reserva> implements FiltroInterface<T>{

    private final Materias materiaAFiltrar;

    public FiltroMateria(Materias materia) {
        this.materiaAFiltrar = materia;
    }

    @Override
    public boolean esFiltrado(Reserva reserva) {
        return (reserva.getMateria().equals(materiaAFiltrar));
    }
}
