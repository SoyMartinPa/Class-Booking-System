package Logica.Gestores;
import Excepciones.IncompatibilityException;
import Excepciones.MaxCapacityReachedException;
import Excepciones.NoRepeatException;
import Excepciones.RemoveException;
import Logica.Enumeraciones.Materias;
import Logica.Filtros.FiltroInterface;
import Logica.Reservas.Horario;
import Logica.Reservas.Reserva;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona el ciclo de vida de las reservas dentro del sistema.
 *
 * <p>Permite crear, modificar, cancelar y completar reservas, además de
 * administrar la relación entre tutores, estudiantes y horarios.</p>
 *
 * <p>Las reservas son clasificadas según su estado actual en tres listas:
 * pendientes, completadas y canceladas.</p>
 */
public class GestorReserva {
    private final List<Reserva> listaReservasPendientes = new ArrayList<>();
    private final List<Reserva> listaReservasCompletadas = new ArrayList<>();
    private final List<Reserva> listaReservasCanceladas = new ArrayList<>();


    protected GestorReserva() {
    }

    /**
     * Verifica si un tutor puede realizar una reserva para una materia
     * y horario determinado.
     *
     * <p>Una reserva es válida cuando el horario sigue vigente, el tutor
     * ofrece la materia solicitada y posee disponibilidad para ese bloque.</p>
     *
     * @param tutor tutor asociado a la reserva.
     * @param materia materia que se desea reservar.
     * @param horario horario solicitado.
     * @return {@code true} si la reserva cumple todas las condiciones,
     *         {@code false} en caso contrario.
     */

    public Boolean reservaValidar(Tutor tutor, Materias materia, Horario horario){

        if (!horario.horarioVigente()){
            return false;
        }
        return tutor.dictaMateria(materia);
    }
    /**
     * Crea una nueva reserva pendiente y la asocia al tutor correspondiente.
     *
     * <p>Antes de registrar la reserva se valida que el tutor pueda impartir
     * la materia en el horario indicado y que no tenga otra reserva en el mismo
     * bloque horario.</p>
     *
     * @param tutor tutor encargado de la reserva.
     * @param materia materia asociada a la reserva.
     * @param horario horario de la reserva.
     * @return reserva creada.
     *
     * @throws IncompatibilityException si el tutor no cumple las condiciones
     *         necesarias para realizar la reserva.
     */
    public Reserva registrarReserva(Tutor tutor, Materias materia, Horario horario)
            throws IncompatibilityException {

        if (!reservaValidar(tutor, materia, horario)) {
            throw new IncompatibilityException("El profesor no puede reservar esa materia en ese horario");
        }
        if (tutor.reservaSeSolapa(horario)) {
            throw new IncompatibilityException("Al profesor se le solapa el horario");
        }
        if (!tutor.estaDisponible(horario.getFecha(), horario.getBloqueHorario())){
            throw new IncompatibilityException("El profesor no está disponible en ese horario");
        }

        Reserva nuevaReserva = new Reserva(tutor, materia, horario);
        listaReservasPendientes.add(nuevaReserva);
        tutor.getReservasActivas().add(nuevaReserva);
        return nuevaReserva;
    }
    /**
     * Cancela una reserva pendiente.
     *
     * <p>Al cancelar una reserva, esta deja de estar activa para el tutor
     * y los estudiantes asociados, y pasa al registro de reservas canceladas.</p>
     *
     * @param reserva reserva que será cancelada.
     *
     * @throws IncompatibilityException si la reserva no existe dentro de las
     *         reservas pendientes.
     */
    public void cancelarReserva(Reserva reserva) throws IncompatibilityException {

        if (!listaReservasPendientes.contains(reserva)) {
            throw new IncompatibilityException("La reserva no existe o ya no puede ser cancelada");
        }

        listaReservasPendientes.remove(reserva);
        listaReservasCanceladas.add(reserva);
        reserva.getTutorAsociado().getReservasActivas().remove(reserva);
        for (Estudiante estudiante : reserva.getListaEstudiantes()){
            estudiante.getReservasActivas().remove(reserva);
        }

        reserva.cancelar();
    }
    /**
     * Marca una reserva pendiente como completada.
     *
     * <p>La reserva deja de considerarse activa para los participantes y pasa
     * al historial de reservas completadas.</p>
     *
     * @param reserva reserva que será completada.
     *
     * @throws IncompatibilityException si la reserva no puede ser completada.
     */
    public void completarReserva(Reserva reserva) throws IncompatibilityException {

        if (!this.listaReservasPendientes.contains(reserva)) {
            throw new IncompatibilityException("La reserva no existe o ya no puede ser completada");
        }

        this.listaReservasPendientes.remove(reserva);
        this.listaReservasCompletadas.add(reserva);
        reserva.getTutorAsociado().getReservasActivas().remove(reserva);
        for (Estudiante estudiante : reserva.getListaEstudiantes()){
            estudiante.getReservasActivas().remove(reserva);
        }
        reserva.completar();
    }

    /**
     * Modifica la información principal de una reserva existente.
     *
     * <p>Permite cambiar tutor, materia u horario siempre que las nuevas
     * condiciones sean compatibles con las reglas del sistema.</p>
     *
     * @param reserva reserva que será modificada.
     * @param tutor nuevo tutor asociado.
     * @param materia nueva materia asociada.
     * @param horario nuevo horario.
     *
     * @throws IncompatibilityException si el nuevo horario o tutor no son
     *         compatibles con la reserva.
     * @throws MaxCapacityReachedException si el nuevo tutor no posee suficientes
     *         cupos para los estudiantes actuales.
     */
    public void modificarReserva(Reserva reserva, Tutor tutor, Materias materia, Horario horario)
            throws IncompatibilityException, MaxCapacityReachedException{

        if (!reservaValidar(tutor, materia, horario)) {
            throw new IncompatibilityException("El profesor no puede reservar esa materia en ese horario");
        }
        if (reserva.getListaEstudiantes().size() > tutor.getOferta(materia).cuposMax()) {
            throw new MaxCapacityReachedException("El nuevo tutor tiene menos cupos que estudiantes actuales");
        }
        for (Reserva r : tutor.getReservasActivas()) {
            if (r != reserva && r.getHorario().equals(horario)) {
                throw new IncompatibilityException("El tutor ya tiene una reserva en ese horario");
            }
        }
        if (reserva.getTutorAsociado() != (tutor)) {
            reserva.getTutorAsociado().getReservasActivas().remove(reserva);
            tutor.getReservasActivas().add(reserva);
        }
        reserva.modificar(tutor, materia, horario);
    }
    /**
     * Agrega un estudiante a una reserva existente.
     *
     * <p>El estudiante solo puede ser agregado si existe disponibilidad de
     * cupos, no pertenece previamente a la reserva y no posee conflictos
     * horarios.</p>
     *
     * @param reserva reserva a la que se agregará el estudiante.
     * @param estudiante estudiante que será agregado.
     *
     * @throws MaxCapacityReachedException si la reserva alcanzó su capacidad.
     * @throws NoRepeatException si el estudiante ya pertenece a la reserva.
     * @throws IncompatibilityException si existe conflicto horario.
     */
    public void agregarEstudiantesReserva(Reserva reserva, Estudiante estudiante)
            throws MaxCapacityReachedException, NoRepeatException, IncompatibilityException{

        if (reserva.getListaEstudiantes().size() >= reserva.getCuposMax()) {
            throw new MaxCapacityReachedException("No se puede agregar al estudiante debido a un sobrecupo");
        }
        if (reserva.getListaEstudiantes().contains(estudiante)) {
            throw new NoRepeatException("Se intenta agregar un alumno que ya pertenece a la reserva");
        }
        if (estudiante.reservaSeSolapa(reserva.getHorario())){
            throw new IncompatibilityException("El estudiante no puede acceder a la clase en ese horario");
            }

        reserva.agregarListaEstudiantes(estudiante);
        estudiante.getReservasActivas().add(reserva);
    }
    /**
     * Elimina un estudiante de una reserva.
     *
     * @param reserva reserva desde la cual se eliminará el estudiante.
     * @param estudiante estudiante que será eliminado.
     *
     * @throws RemoveException si el estudiante no pertenece a la reserva.
     */
    public void quitarEstudianteReserva(Reserva reserva, Estudiante estudiante)
            throws RemoveException{

        if (!reserva.getListaEstudiantes().contains(estudiante)){
            throw new RemoveException("Se intenta quitar un alumno que no pertenece a la reserva");
        }
        reserva.quitarListaEstudiantes(estudiante);
        estudiante.getReservasActivas().remove(reserva);
    }
    /**
     * Filtra una lista de reservas utilizando una estrategia de filtrado.
     *
     * <p>El criterio de filtrado es definido externamente mediante
     * {@link FiltroInterface}, permitiendo aplicar diferentes filtros sin
     * modificar esta clase.</p>
     *
     * @param listaReserva lista de reservas a filtrar.
     * @param filtro condición que determina si una reserva debe incluirse.
     *
     * @return nueva lista que contiene únicamente las reservas aceptadas
     *         por el filtro.
     */
    public List<Reserva> filtrador(List<Reserva> listaReserva, FiltroInterface<Reserva> filtro){
        List<Reserva> listaFiltrada = new ArrayList<>();
        for (Reserva r : listaReserva){
            if (filtro.pasaElFiltro(r)){ listaFiltrada.add(r);}
        }
        return listaFiltrada;
    }

    public List<Reserva> getListaReservasPendientes() {
        return listaReservasPendientes;
    }

    public List<Reserva> getListaReservasCompletadas() {
        return listaReservasCompletadas;
    }

    public List<Reserva> getListaReservasCanceladas() {
        return listaReservasCanceladas;
    }

    public List<Reserva> getListaReservas(){
        List<Reserva> listaTotal = new ArrayList<>();
        listaTotal.addAll(getListaReservasPendientes());
        listaTotal.addAll(getListaReservasCanceladas());
        listaTotal.addAll(getListaReservasCompletadas());
        return listaTotal;
    }
}
