package Logica.Gestores;
import Excepciones.NotFoundException;
import Excepciones.RemoveException;
import Logica.Reservas.Reserva;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;
import java.util.ArrayList;
import java.util.List;

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
    public void resetInstancia() { //principalmente para los Test Unitarios
        instancia = null;
        getGestorEstudiantes().getListaCompletaInterna().clear();
        
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

            for (Estudiante estudiante : reserva.getListaEstudiantes()) {
                reserva.quitarListaEstudiantes(estudiante);
                estudiante.quitarReserva(reserva);
            }
            tutor.quitarReserva(reserva);
            reserva.cancelar();
            gestorReservas.quitarListaPendiente(reserva);
            gestorReservas.agregarListaCancelada(reserva);
        }
        gestorTutores.quitarDeLista(tutor);
        getGestorTutores().getListaCompletaInterna().remove(tutor);
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
            estudiante.quitarReserva(reserva);
        }
        gestorEstudiantes.quitarDeLista(estudiante);
        getGestorEstudiantes().getListaCompletaInterna().remove(estudiante);
    }
    /**
     * Busca un tutor mediante su correo electrónico.
     *
     * @param email correo electrónico del tutor.
     * @return tutor encontrado.
     * @throws NotFoundException si el tutor no fue encontrado.
     */
    public Tutor buscarTutorPorEmail(String email) throws NotFoundException{
        for (Tutor t : gestorTutores.getLista()) {
            if (t.getEmail().equals(email)) {
                return t;
            }
        }
        throw new NotFoundException("El email ingresado no se asocia a ningun tutor");
    }
     /**
     * Busca un tutor mediante su correo electrónico.
     *
     * @param id Identificador del tutor.
     * @return tutor encontrado.
      * @throws NotFoundException si el tutor no fue encontrado.
     */
    public Tutor buscarTutorPorId(String id) throws NotFoundException{
    for (Tutor t : gestorTutores.getLista()) {
        if (t.getId().equals(id)) {
            return t;
        }
    }
        throw new NotFoundException("El ID ingresado no se asocia a ningun tutor");
    }

    /**
     * Busca un tutor mediante su Nombre
     *
     * @param nombre nombre del tutor.
     * @return tutor encontrado
     * @throws NotFoundException si el tutor no fue encontrado
     */
    public Tutor buscarTutorPorNombre(String nombre) throws NotFoundException{
        for (Tutor t : gestorTutores.getLista()) {
            if (t.getNombre().equals(nombre)) {
                return t;
            }
        }
        throw new NotFoundException("El nombre ingresado no se asocia a ningun tutor");
    }
    /**
     * Busca un estudiante mediante su nombre y apellido.
     *
     * @param nombre nombre del estudiante.
     * @return estudiante encontrado
     * @throws NotFoundException si estudiante no encontrado
     */
    public Estudiante buscarEstudiantePorNombre(String nombre) throws NotFoundException{
        for (Estudiante e : gestorEstudiantes.getLista()) {
            if (e.getNombre().equals(nombre)) {
                return e;
            }
        }
        throw new NotFoundException("El nombre ingresado no se asocia a ningun estudiante");
    }
    /**
     * Busca un estudiante mediante su correo electrónico.
     *
     * @param email correo electrónico del estudiante.
     * @return estudiante encontrado.
     * @throws NotFoundException si estudiante no encontrado
     */
    public Estudiante buscarEstudiantePorEmail(String email) throws NotFoundException {
        for (Estudiante e : gestorEstudiantes.getLista()) {
            if (e.getEmail().equals(email)) {
                return e;
            }
        }
        throw new NotFoundException("El email ingresado no se asocia a ningun estudiante");
    }
    /**
     * Busca un estudiante mediante su correo electrónico.
     *
     * @param id Identificador del estudiante.
     * @return estudiante encontrado.
     * @throws NotFoundException si estudiante no encontrado
     */
    public Estudiante buscarEstudiantePorId(String id) throws NotFoundException {
    for (Estudiante e : gestorEstudiantes.getLista()) {
        if (e.getId().equals(id)) {
            return e;
        }
    }
        throw new NotFoundException("El ID ingresado no se asocia a ningun estudiante");
    
    
    }
    /**
     * Obtiene las reservas asociadas a un tutor.
     *
     * <p>Permite incluir o excluir reservas pendientes dependiendo del parámetro
     * recibido. Las reservas completadas y canceladas siempre son consideradas.</p>
     *
     * @param tutor tutor cuyo calendario será consultado.
     *
     * @return lista de reservas asociadas al tutor.
     */
    public List<Reserva> verCalendarioTutor(Tutor tutor) {
        List<Reserva> resultado = new ArrayList<>();

        for (Reserva r : gestorReservas.getListaReservas()) {
            if (r.getTutorAsociado() == tutor) resultado.add(r);
        }
        return resultado;
    }
    /**
     * Obtiene las reservas asociadas a un estudiante.
     *
     * @param estudiante estudiante cuyo calendario será consultado.
     *
     * @return lista de reservas donde participa el estudiante.
     */
    public List<Reserva> verCalendarioEstudiante(Estudiante estudiante) {
        List<Reserva> resultado = new ArrayList<>();
        List<Reserva> todas = gestorReservas.getListaReservas();


        for (Reserva r : todas) {
            if (r.getListaEstudiantes().contains(estudiante)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
    /**
     * Busca una reserva utilizando su identificador único.
     *
     * <p>La búsqueda considera reservas pendientes, completadas y canceladas.</p>
     *
     * @param id identificador de la reserva.
     * @return reserva encontrada o {@code null} si no existe.
     */
    public Reserva buscarReservaPorId(String id) throws NotFoundException{
        List<Reserva> todas = gestorReservas.getListaReservas();

        for (Reserva r : todas) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        throw new NotFoundException("El ID ingresado no se asocia a ninguna Reserva");
    }

    public GestorTutor getGestorTutores() {
        return gestorTutores;
    }

    public GestorEstudiante getGestorEstudiantes() {
        return gestorEstudiantes;
    }

    public GestorReserva getGestorReservas() {
        return gestorReservas;
    }

    @Override
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
