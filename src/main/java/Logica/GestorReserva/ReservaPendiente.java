package Logica.GestorReserva;
import Excepciones.MaxCapacityReachedException;
import Excepciones.NoRepeatException;
import Excepciones.RemoveException;
import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.GestorTutor.Tutor;

public class ReservaPendiente implements EstadoReserva{
    public static final ReservaPendiente INSTANCIA = new ReservaPendiente();
    public ReservaPendiente(){};

    public void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario){
        reserva.setTutorAsociado(tutor);
        reserva.setMateria(materia);
        reserva.setHorario(horario);
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

    public void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante) {
        reserva.getListaEstudiantes().add(estudiante);
    };
    public void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante){
        reserva.getListaEstudiantes().remove(estudiante);
    };
}
