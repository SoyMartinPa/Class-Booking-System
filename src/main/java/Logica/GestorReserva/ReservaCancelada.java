package Logica.GestorReserva;

import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.GestorTutor.Tutor;

public class ReservaCancelada implements EstadoReserva{

    public ReservaCancelada(){};

    public void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario)
            throws IllegalStateException {
        throw new IllegalStateException("No se puede modificar una reserva ya cancelada");
    }
    public void completar(Reserva reserva)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede completar una reserva ya cancelada");
    }
    public void cancelar(Reserva reserva)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede cancelar una clase ya cancelada");
    }
    public void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede agregar estudiantes en una clase ya cancelada");
    };
    public void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede quitar estudiantes en una clase ya cancelada");
    };
    public EstadoReserva getEstado(Reserva reserva){
        return reserva.getEstado();
    }
}

