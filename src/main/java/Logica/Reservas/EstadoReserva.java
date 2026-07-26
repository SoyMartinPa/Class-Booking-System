package Logica.Reservas;
import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.Estudiante.Estudiante;
import Logica.Perfiles.Tutor.Tutor;

/**
 * Define el comportamiento asociado a los distintos estados de una reserva.
 *
 * <p>Cada implementación determina qué operaciones son válidas según el
 * estado actual de la reserva y cómo afectan su ciclo de vida. En un futuro se pueden extender
 * los estados 'pagoPendiente','completadaParcialmente', etc.</p>
 */
public interface EstadoReserva {
    /**
     * Modifica la información de una reserva.
     *
     * @param reserva reserva que será modificada.
     * @param tutor nuevo tutor asociado.
     * @param materia nueva materia de la tutoría.
     * @param horario nuevo horario de la reserva.
     */
    void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario);
    /**
     * Marca la reserva como completada.
     *
     * @param reserva reserva que será completada.
     */
    void completar(Reserva reserva);
    /**
     * Cancela la reserva.
     *
     * @param reserva reserva que será cancelada.
     */
    void cancelar(Reserva reserva);
    /**
     * Obtiene el estado actual de la reserva.
     *
     * @param reserva reserva cuyo estado se desea obtener.
     * @return estado actual de la reserva.
     */
    EstadoReserva getEstado(Reserva reserva);
    /**
     * Agrega un estudiante a la reserva.
     *
     * @param reserva reserva a la que se agregará el estudiante.
     * @param estudiante estudiante que se incorporará a la reserva.
     */
    void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante);
    /**
     * Elimina un estudiante de la reserva.
     *
     * @param reserva reserva de la que se eliminará el estudiante.
     * @param estudiante estudiante que será eliminado de la reserva.
     */
    void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante);
}
