package Logica.Gestores.Reservas;

import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor;

public class ReservaCompletada implements EstadoReserva{

    public ReservaCompletada(){};

    public void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario, int tarifa, int CuposMax)
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
        };
        public void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante)
                throws IllegalStateException{
            throw new IllegalStateException("No se puede quitar estudiantes en una clase ya realizada");
        };
    public EstadoReserva getEstado(Reserva reserva){
        return reserva.getEstado();
    }
}

