package Logica.GestorReserva;

import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.GestorTutor.Tutor;

public class ReservaCompletada implements EstadoReserva{
    public static final ReservaCompletada INSTANCIA = new ReservaCompletada();

    public ReservaCompletada(){}

    public void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario)
            throws IllegalStateException {
        throw new IllegalStateException("No se puede modificar una reserva ya realizada");
    }
    public void completar(Reserva reserva)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede completar una reserva ya realizada");
    }
    public void cancelar(Reserva reserva)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede cancelar una clase ya realizada");
    }
        public void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante)
                throws IllegalStateException{
            throw new IllegalStateException("No se puede agregar estudiantes en una clase ya realizada");
        }
        public void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante)
                throws IllegalStateException{
            throw new IllegalStateException("No se puede quitar estudiantes en una clase ya realizada");
        }
    public EstadoReserva getEstado(Reserva reserva){
        return reserva.getEstado();
    }
}

