package Logica.Gestores.Reservas;
import Excepciones.MaxCapacityReachedException;
import Excepciones.NoRepeatException;
import Excepciones.RemoveException;
import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor;

public class ReservaPendiente implements EstadoReserva{

    public ReservaPendiente(){};

    public void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario, int tarifa, int cuposmax){
        reserva.setTutorAsociado(tutor);
        reserva.setMateria(materia);
        reserva.setHorario(horario);
        reserva.setTarifa(tarifa);
        reserva.setCuposMax(cuposmax);
    }
    public void completar(Reserva reserva){
        reserva.setEstado(new ReservaCompletada());
        //Añadir a completados general
    }
    public void cancelar(Reserva reserva){
        reserva.setEstado(new ReservaCancelada());
        //Añadir a cancelados general
    }
    public EstadoReserva getEstado(Reserva reserva){
        return reserva.getEstado();
    }
    public void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante)
            throws MaxCapacityReachedException, NoRepeatException{
        if (reserva.getListaEstudiantes().size() >= reserva.getCuposMax()){
            throw new MaxCapacityReachedException("No se puede agregar al estudiante debido a un sobrecupo");
        }
        if (reserva.getListaEstudiantes().contains(estudiante)){
            throw new NoRepeatException("Se intenta agregar un alumno que ya pertenece a la reserva");
        }
        reserva.getListaEstudiantes().add(estudiante);
    };
    public void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante)
            throws RemoveException {
        if (!reserva.getListaEstudiantes().contains(estudiante)){
            throw new RemoveException("Se intenta quitar un alumno que no pertenece a la reserva");
        }
        reserva.getListaEstudiantes().remove(estudiante);
    };
}
