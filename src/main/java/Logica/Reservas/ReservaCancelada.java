package Logica.Reservas;
import Logica.Enumeraciones.Materias;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;

/**
 * Define el estado cancelado de una Reserva
 * <p>Lanza IllegalStateException cuando se intenta modificar de alguna manera</p>
 */
public class ReservaCancelada implements EstadoReserva{
    public static final ReservaCancelada INSTANCIA = new ReservaCancelada();

    public ReservaCancelada(){}

    @Override
    public void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario)
            throws IllegalStateException {
        throw new IllegalStateException("No se puede modificar una reserva ya cancelada");
    }
    @Override
    public void completar(Reserva reserva)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede completar una reserva ya cancelada");
    }
    @Override
    public void cancelar(Reserva reserva)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede cancelar una clase ya cancelada");
    }
    @Override
    public void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede agregar estudiantes en una clase ya cancelada");
    }
    @Override
    public void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante)
            throws IllegalStateException{
        throw new IllegalStateException("No se puede quitar estudiantes en una clase ya cancelada");
    }
    @Override
    public EstadoReserva getEstado(Reserva reserva){
        return reserva.getEstado();
    }
}

