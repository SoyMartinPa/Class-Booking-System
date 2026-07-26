package Logica.Reservas;
import Logica.Enumeraciones.Materias;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;
/**
 * Define el estado completado de una Reserva
 * <p>Lanza IllegalStateException cuando se intenta modificar de alguna manera, no obstante,
 * se espera que el estado proximamente pueda incluir modificaciones</p>
 */

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

