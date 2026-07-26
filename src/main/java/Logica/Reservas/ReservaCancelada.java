package Logica.Reservas;
import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.Estudiante.Estudiante;
import Logica.Perfiles.Tutor.Tutor;

/**
 * Define el estado cancelado de una Reserva
 * <p>Lanza IllegalStateException cuando se intenta modificar de alguna manera</p>
 */
public class ReservaCancelada implements EstadoReserva{
    public static final ReservaCancelada INSTANCIA = new ReservaCancelada();

    public ReservaCancelada(){}

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
    }
    public void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede quitar estudiantes en una clase ya cancelada");
    }
    public EstadoReserva getEstado(Reserva reserva){
        return reserva.getEstado();
    }
}

