package Logica.Gestores;
import Excepciones.RemoveException;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Materias;
import Logica.Filtros.*;
import Logica.GestorHorarios.Horario;
import Logica.Reservas.Reserva;
import Logica.Perfiles.Estudiante.Estudiante;
import Logica.Perfiles.Tutor.Tutor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static Logica.Gestores.GestorBasico.listaUsuarios;
/**
 * Clase principal de acceso al sistema de gestión de tutorías.
 *
 * <p>Centraliza la interacción entre gestores de tutores, estudiantes y
 * reservas, permitiendo realizar operaciones como búsqueda de perfiles,
 * administración de reservas, filtrado y consulta de calendarios.</p>
 *
 * <p>Utiliza el patrón Singleton para garantizar que exista una única
 * instancia del sistema durante la ejecución del programa.</p>
 *
 * <p>La instancia mantiene referencias a los gestores encargados de manejar
 * cada tipo de entidad del sistema.</p>
 */

public class Sistema {
    private static Sistema instancia;
    private final GestorTutor gestorTutores;
    private final GestorEstudiante gestorEstudiantes;
    private final GestorReserva gestorReservas;

    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }
    public static void resetInstancia() { //principalmente para los Test Unitarios
        instancia = null;
        GestorBasico.listaUsuarios.clear();
    }

    private Sistema() {
        this.gestorTutores = new GestorTutor();
        this.gestorEstudiantes = new GestorEstudiante();
        this.gestorReservas = new GestorReserva();
    }
    /**
     * Elimina un tutor del sistema.
     *
     * <p>Antes de eliminarlo, cancela todas sus reservas activas y actualiza
     * las relaciones existentes con los estudiantes asociados.</p>
     *
     * @param tutor tutor que será eliminado.
     *
     * @throws RemoveException si el tutor no se encuentra registrado.
     */
    public void eliminarTutor(Tutor tutor) throws RemoveException{

        if (!gestorTutores.getLista().contains(tutor)) {
            throw new RemoveException("Se intenta eliminar un tutor no registrado");
        }

        List<Reserva> listaTemporal = new ArrayList<>(tutor.getReservasActivas());

        for (Reserva reserva : listaTemporal) {

            for (Estudiante estudiante : new ArrayList<>(reserva.getListaEstudiantes())) {
                reserva.quitarListaEstudiantes(estudiante);
                estudiante.getReservasActivas().remove(reserva);
            }
            tutor.getReservasActivas().remove(reserva);
            reserva.cancelar();
            gestorReservas.getListaReservasPendientes().remove(reserva);
            gestorReservas.getListaReservasCanceladas().add(reserva);
        }
        gestorTutores.getLista().remove(tutor);
        listaUsuarios.remove(tutor);
    }
    /**
     * Elimina un estudiante del sistema.
     *
     * <p>Al eliminarlo, se remueve su participación en las reservas activas
     * existentes.</p>
     *
     * @param estudiante estudiante que será eliminado.
     *
     * @throws RemoveException si el estudiante no está registrado.
     */
    public void eliminarEstudiante(Estudiante estudiante) throws RemoveException{
        if (!gestorEstudiantes.getLista().contains(estudiante)) {
            throw new RemoveException("Se intenta eliminar un estudiante no registrado");
        }
        List<Reserva> listaTemporal = new ArrayList<>(estudiante.getReservasActivas());
        for (Reserva reserva : listaTemporal) {
            reserva.quitarListaEstudiantes(estudiante);
            estudiante.getReservasActivas().remove(reserva);
        }
        gestorEstudiantes.getLista().remove(estudiante);
        listaUsuarios.remove(estudiante);
    }
    /**
     * Busca un tutor mediante su correo electrónico.
     *
     * @param email correo electrónico del tutor.
     * @return tutor encontrado o {@code null} si no existe.
     */
    public Tutor buscarTutorPorEmail(String email) {
        for (Tutor t : gestorTutores.getLista()) {
            if (t.getEmail().equals(email)) {
                return t;
            }
        }
        return null;
    }
    /**
     * Busca un estudiante mediante su nombre y apellido.
     *
     * @param nombre nombre del estudiante.
     * @return estudiante encontrado o {@code null} si no existe.
     */
    public Estudiante buscarEstudiantePorNombre(String nombre) {
        for (Estudiante e : gestorEstudiantes.getLista()) {
            if (e.getNombre().equals(nombre)) {
                return e;
            }
        }
        return null;
    }
    /**
     * Busca un estudiante mediante su correo electrónico.
     *
     * @param email correo electrónico del estudiante.
     * @return estudiante encontrado o {@code null} si no existe.
     */
    public Estudiante buscarEstudiantePorEmail(String email) {
        for (Estudiante e : gestorEstudiantes.getLista()) {
            if (e.getEmail().equals(email)) {
                return e;
            }
        }
        return null;
    }
    /**
     * Busca tutores que cumplen las condiciones necesarias para una reserva.
     *
     * <p>Un tutor es considerado compatible si:</p>
     * <ul>
     *     <li>Ofrece la materia solicitada.</li>
     *     <li>Tiene disponibilidad en la fecha y bloque indicados.</li>
     *     <li>No posee otra reserva en el mismo horario.</li>
     *     <li>Su tarifa no supera el límite indicado, si este existe.</li>
     * </ul>
     *
     * <p>Los resultados son ordenados desde la menor tarifa hasta la mayor.</p>
     *
     * @param materia materia requerida.
     * @param fecha fecha de la reserva.
     * @param bloque bloque horario requerido.
     * @param tarifaMax tarifa máxima aceptada. Un valor menor o igual a cero
     *                  indica que no existe límite.
     *
     * @return lista de tutores compatibles ordenados por tarifa.
     */
    public List<Tutor> buscarTutoresCompatibles(Materias materia, LocalDate fecha,
                                                 BloquesHorarios bloque, int tarifaMax) {

        List<Tutor> compatibles = new ArrayList<>();

        for (Tutor tutor : gestorTutores.getLista()) {
            if (!tutor.dictaMateria(materia)) {
                continue;
            }
            if (!tutor.estaDisponible(fecha, bloque)) {
                continue;
            }
            if (tutor.reservaSeSolapa(new Horario(bloque, fecha))) {
                continue;
            }
            int tarifa = tutor.getOferta(materia).getTarifa();

            if (tarifaMax > 0 && tarifa > tarifaMax) {
                continue;
            }
            compatibles.add(tutor);
        }

        compatibles.sort(Comparator.comparingInt(t -> t.getOferta(materia).getTarifa())
        );
        return compatibles;
    }

    public List<Tutor> buscarTutoresCompatibles(Materias materia, LocalDate fecha,
                                                 BloquesHorarios bloque) {
        return buscarTutoresCompatibles(materia, fecha, bloque, -1);
    }

    /**
     * Obtiene las reservas asociadas a un tutor.
     *
     * <p>Permite incluir o excluir reservas pendientes dependiendo del parámetro
     * recibido. Las reservas completadas y canceladas siempre son consideradas.</p>
     *
     * @param tutor tutor cuyo calendario será consultado.
     * @param pendientes indica si deben incluirse reservas pendientes.
     *
     * @return lista de reservas asociadas al tutor.
     */
    public List<Reserva> verCalendarioTutor(Tutor tutor, boolean pendientes) {
        List<Reserva> resultado = new ArrayList<>();

        if (pendientes) {
            for (Reserva r : gestorReservas.getListaReservasPendientes()) {
                if (r.getTutorAsociado() == tutor) resultado.add(r);
            }
        }
        for (Reserva r : gestorReservas.getListaReservasCompletadas()) {
            if (r.getTutorAsociado() == tutor) resultado.add(r);
        }
        for (Reserva r : gestorReservas.getListaReservasCanceladas()) {
            if (r.getTutorAsociado() == tutor) resultado.add(r);
        }

        return resultado;
    }
    /**
     * Obtiene las reservas asociadas a un estudiante.
     *
     * @param estudiante estudiante cuyo calendario será consultado.
     * @param pendientes indica si deben incluirse reservas pendientes.
     *
     * @return lista de reservas donde participa el estudiante.
     */
    public List<Reserva> verCalendarioEstudiante(Estudiante estudiante, boolean pendientes) {
        List<Reserva> resultado = new ArrayList<>();

        List<Reserva> todas = new ArrayList<>();
        if (pendientes) {
            todas.addAll(gestorReservas.getListaReservasPendientes());
        }
        todas.addAll(gestorReservas.getListaReservasCompletadas());
        todas.addAll(gestorReservas.getListaReservasCanceladas());

        for (Reserva r : todas) {
            if (r.getListaEstudiantes().contains(estudiante)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
    /**
     * Filtra reservas utilizando un conjunto de criterios definidos externamente.
     *
     * <p>Permite seleccionar qué estados de reserva considerar y aplicar un filtro
     * compuesto mediante {@link FiltroCompuesto}.</p>
     *
     * @param filtro criterio compuesto de filtrado.
     * @param incluirPendientes indica si se incluyen reservas pendientes.
     * @param incluirCompletadas indica si se incluyen reservas completadas.
     * @param incluirCanceladas indica si se incluyen reservas canceladas.
     *
     * @return lista de reservas que cumplen los filtros.
     */
    public List<Reserva> filtrarReservas(FiltroCompuesto filtro,
                                          boolean incluirPendientes,
                                          boolean incluirCompletadas,
                                          boolean incluirCanceladas) {
        List<Reserva> todas = new ArrayList<>();
        if (incluirPendientes) {
            todas.addAll(gestorReservas.getListaReservasPendientes());
        }
        if (incluirCompletadas) {
            todas.addAll(gestorReservas.getListaReservasCompletadas());
        }
        if (incluirCanceladas) {
            todas.addAll(gestorReservas.getListaReservasCanceladas());
        }
        return gestorReservas.filtrador(todas, filtro);
    }
    /**
     * Busca una reserva utilizando su identificador único.
     *
     * <p>La búsqueda considera reservas pendientes, completadas y canceladas.</p>
     *
     * @param id identificador de la reserva.
     * @return reserva encontrada o {@code null} si no existe.
     */
    public Reserva buscarReservaPorId(String id) {
        List<Reserva> todas = new ArrayList<>();
        todas.addAll(gestorReservas.getListaReservasPendientes());
        todas.addAll(gestorReservas.getListaReservasCompletadas());
        todas.addAll(gestorReservas.getListaReservasCanceladas());

        for (Reserva r : todas) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public String toString() {

        int totalTutores = gestorTutores.getLista().size();
        int totalEstudiantes = gestorEstudiantes.getLista().size();
        int pendientes = gestorReservas.getListaReservasPendientes().size();
        int completadas = gestorReservas.getListaReservasCompletadas().size();
        int canceladas = gestorReservas.getListaReservasCanceladas().size();

        return String.format(
            "=== RESUMEN DEL SISTEMA ===%n" +
            "Tutores registrados: %d%n" +
            "Estudiantes registrados: %d%n" +
            "Reservas pendientes: %d%n" +
            "Reservas completadas: %d%n" +
            "Reservas canceladas: %d%n" +
            "Total reservas: %d",
            totalTutores, totalEstudiantes, pendientes, completadas, canceladas,
            pendientes + completadas + canceladas
        );
    }

}
