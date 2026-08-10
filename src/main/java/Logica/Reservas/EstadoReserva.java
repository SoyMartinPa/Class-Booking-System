package Logica.Reservas;
import Logica.Enumeraciones.Materias;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;

/**
 * Define el comportamiento asociado a los distintos estados de una reserva.
 *
 * <p>Cada implementación determina qué operaciones son válidas según el
 * estado actual de la reserva y cómo afectan su ciclo de vida. En un futuro se pueden
 * extender los estados ('pagoPendiente', 'completadaParcialmente', etc.) sin modificar
 * la clase {@code GestorReserva}, ya que esta delega el comportamiento en su estado actual
 * en lugar de conocer las reglas específicas de cada uno, disminuyendo así el
 * acoplamiento entre ambas.</p>
 *
 * <p>Los estados de la reserva se pueden separar entre "Finalizados" y "Pendientes".
 * Entre los primeros están los estados 'Cancelada' y 'Completada', y en el grupo de
 * "Pendientes" se puede encontrar el estado 'Pendiente'. Las reservas "Finalizadas"
 * lanzarán excepciones al intentar realizar modificaciones sobre la reserva (como
 * agregar estudiantes o cambios de estado), mientras que las "Pendientes" dependerán
 * de su estado específico, pero no lanzarán excepciones.</p>
 *
 * <p>Este comportamiento se documenta explícitamente como parte del contrato de
 * {@code EstadoReserva}, de modo que ninguna implementación viola las expectativas
 * del cliente que la invoca (Principio de Sustitución de Liskov).</p>
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
