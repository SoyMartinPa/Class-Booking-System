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

    private Sistema() {
        this.gestorTutores = new GestorTutor();
        this.gestorEstudiantes = new GestorEstudiante();
        this.gestorReservas = new GestorReserva();
    }

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

    public Tutor buscarTutorPorEmail(String email) {
        for (Tutor t : gestorTutores.getLista()) {
            if (t.getEmail().equals(email)) {
                return t;
            }
        }
        return null;
    }
    public Estudiante buscarEstudiantePorNombre(String nombre) {
        for (Estudiante e : gestorEstudiantes.getLista()) {
            if (e.getNombre().equals(nombre)) {
                return e;
            }
        }
        return null;
    }

    public Estudiante buscarEstudiantePorEmail(String email) {
        for (Estudiante e : gestorEstudiantes.getLista()) {
            if (e.getEmail().equals(email)) {
                return e;
            }
        }
        return null;
    }

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

    public List<Reserva> filtrarReservasPendientes(FiltroCompuesto filtro) {
        return filtrarReservas(filtro, true, false, false);
    }

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
