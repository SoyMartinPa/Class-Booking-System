package Logica.Reservas;
import Logica.Enumeraciones.Materias;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;

/**
 * Define el estado Inicial (Pendiente) de una Reserva
 * <p>Es el estado por default que sirve de puente a los demás estados</p>
 */
public class ReservaPendiente implements EstadoReserva{
    public static final ReservaPendiente INSTANCIA = new ReservaPendiente();
    public ReservaPendiente(){}
    
    @Override
    public void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario){
        reserva.setTutorAsociado(tutor);
        reserva.setMateria(materia);
        reserva.setHorario(horario);
    }
    @Override
    public void completar(Reserva reserva){
        reserva.setEstado(ReservaCompletada.INSTANCIA);
    }
    @Override
    public void cancelar(Reserva reserva){
        reserva.setEstado(ReservaCancelada.INSTANCIA);
    }
    @Override
    public EstadoReserva getEstado(Reserva reserva){
        return reserva.getEstado();
    }

    @Override
    public void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante) {
        reserva.getListaEstudiantes().add(estudiante);
    }
    @Override
    public void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante){
        reserva.getListaEstudiantes().remove(estudiante);
    }
    
    @Override
    public String toString(){
        return "Pendiente";
    }
}
