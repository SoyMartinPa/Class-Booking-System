package Logica.Reservas;
import Logica.Enumeraciones.Materias;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;

/**
 * Define el estado Inicial (Pendiente) de una Reserva
 * <p>Es el estado por default que sirve de puente a los demás estados</p>
 */
public class ReservaPendiente implements EstadoReserva{
    private static ReservaPendiente INSTANCIA;

    private ReservaPendiente(){}

    public static ReservaPendiente getInstancia(){
        if (INSTANCIA == null){ INSTANCIA = new ReservaPendiente();}
        return INSTANCIA;
    }

    @Override
    public void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario){
        reserva.setTutorAsociado(tutor);
        reserva.setMateria(materia);
        reserva.setHorario(horario);
    }
    @Override
    public void completar(Reserva reserva){
        reserva.setEstado(ReservaCompletada.getInstancia());
    }
    @Override
    public void cancelar(Reserva reserva){
        reserva.setEstado(ReservaCancelada.getInstancia());
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
