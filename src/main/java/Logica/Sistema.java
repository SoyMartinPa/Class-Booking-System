package Logica;

import Excepciones.*;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Dias;
import Logica.Enumeraciones.Materias;
import Logica.Filtros.*;
import Logica.GestorHorarios.Horario;
import Logica.GestorReserva.GestorReserva;
import Logica.GestorReserva.Reserva;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.GestorEstudiante.GestorEstudiante;
import Logica.Perfiles.GestorTutor.GestorTutor;
import Logica.Perfiles.GestorTutor.Tutor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public String registrarTutor(String nombre, String email) {
        try {
            gestorTutores.registar(nombre, email);
            return "Tutor registrado exitosamente.";
        } catch (NullPointerException | IncompatibilityException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String eliminarTutor(Tutor tutor) {
        try {
            for (Reserva r : tutor.getReservasActivas()) {
                cancelarReserva(r);
            }
            gestorTutores.eliminar(tutor);
            return "Tutor eliminado exitosamente.";
        } catch (RemoveException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al eliminar tutor: " + e.getMessage();
        }
    }

    public String cambiarEmailTutor(Tutor tutor, String email) {
        try {
            gestorTutores.cambiarEmail(tutor, email);
            return "Email del tutor actualizado exitosamente.";
        } catch (IncompatibilityException | NullPointerException e) {
            return "Error: " + e.getMessage();
        }
    }

    public List<Tutor> getListaTutores() {
        return gestorTutores.getLista();
    }

    public Tutor buscarTutorPorNombre(String nombre) {
        for (Tutor t : gestorTutores.getLista()) {
            if (t.getNombre().equals(nombre)) {
                return t;
            }
        }
        return null;
    }

    public Tutor buscarTutorPorEmail(String email) {
        for (Tutor t : gestorTutores.getLista()) {
            if (t.getEmail().equals(email)) {
                return t;
            }
        }
        return null;
    }

    public String asignarMateriaTutor(Tutor tutor, Materias materia, int tarifa, int cuposMax) {
        try {
            if (tarifa <= 0) {
                return "Error: La tarifa debe ser mayor a 0.";
            }
            if (cuposMax <= 0) {
                return "Error: Los cupos máximos deben ser mayor a 0.";
            }
            tutor.ofrecerMateria(materia, tarifa, cuposMax);
            return "Materia asignada al tutor exitosamente.";
        } catch (Exception e) {
            return "Error al asignar materia: " + e.getMessage();
        }
    }

    public String quitarMateriaTutor(Tutor tutor, Materias materia) {
        try {
            if (!tutor.dictaMateria(materia)) {
                return "Error: El tutor no dicta esa materia.";
            }
            tutor.dejarDeOfrecer(materia);
            return "Materia removida de la oferta del tutor.";
        } catch (Exception e) {
            return "Error al quitar materia: " + e.getMessage();
        }
    }

    public String toggleDisponibilidadTutor(Tutor tutor, Dias dia, BloquesHorarios bloque) {
        try {
            boolean estabaDisponible = tutor.estaDisponible(dia, bloque);
            tutor.toggleDisponibilidad(dia, bloque);
            boolean ahoraDisponible = tutor.estaDisponible(dia, bloque);
            if (ahoraDisponible) {
                return "Disponibilidad ACTIVADA para " + dia + " en el bloque " + bloque.name() + ".";
            } else {
                return "Disponibilidad DESACTIVADA para " + dia + " en el bloque " + bloque.name() + ".";
            }
        } catch (Exception e) {
            return "Error al modificar disponibilidad: " + e.getMessage();
        }
    }

    public String registrarEstudiante(String nombre, String email) {
        try {
            gestorEstudiantes.registar(nombre, email);
            return "Estudiante registrado exitosamente.";
        } catch (NullPointerException | IncompatibilityException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String eliminarEstudiante(Estudiante estudiante) {
        try {
            for (Reserva r :estudiante.getReservasActivas()) {
                try {
                    gestorReservas.quitarEstudianteReserva(r, estudiante);
                    if (r.getListaEstudiantes().isEmpty()) {
                        cancelarReserva(r);
                    }
                } catch (RemoveException | IncompatibilityException e) {
                    return "Error: " + e.getMessage();
                }
            }
            gestorEstudiantes.eliminar(estudiante);
            return "Estudiante eliminado exitosamente.";
        } catch (RemoveException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al eliminar estudiante: " + e.getMessage();
        }
    }

    public String cambiarEmailEstudiante(Estudiante estudiante, String email) {
        try {
            gestorEstudiantes.cambiarEmail(estudiante, email);
            return "Email del estudiante actualizado exitosamente.";
        } catch (IncompatibilityException | NullPointerException e) {
            return "Error: " + e.getMessage();
        }
    }

    public List<Estudiante> obtenerEstudiantes() {
        return gestorEstudiantes.getLista();
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
        Dias dia = diasDesdeFecha(fecha);

        for (Tutor tutor : gestorTutores.getLista()) {
            if (!tutor.dictaMateria(materia)) {
                continue;
            }
            if (!tutor.estaDisponible(dia, bloque)) {
                continue;
            }
            Horario horarioPropuesto = new Horario(bloque, fecha);
            if (tutor.reservaSeSolapa(horarioPropuesto)) {
                continue;
            }
            int tarifa = tutor.getOferta(materia).getTarifa();
            if (tarifaMax > 0 && tarifa > tarifaMax) {
                continue;
            }
            compatibles.add(tutor);
        }

        // Ordenar por tarifa ascendente
        compatibles.sort((t1, t2) -> {
            return Integer.compare(t1.getOferta(materia).getTarifa(),
                                   t2.getOferta(materia).getTarifa());
        });

        return compatibles;
    }

    public List<Tutor> buscarTutoresCompatibles(Materias materia, LocalDate fecha,
                                                 BloquesHorarios bloque) {
        return buscarTutoresCompatibles(materia, fecha, bloque, -1);
    }


    private Dias diasDesdeFecha(LocalDate fecha) {
        return switch (fecha.getDayOfWeek()) {
            case MONDAY -> Dias.LUNES;
            case TUESDAY -> Dias.MARTES;
            case WEDNESDAY -> Dias.MIERCOLES;
            case THURSDAY -> Dias.JUUEVES;
            case FRIDAY -> Dias.VIERNES;
            default -> null;
        };
    }

    public Reserva crearReserva(Tutor tutor, Materias materia, Horario horario) {
        try {
            Dias dia = diasDesdeFecha(horario.getFecha());
            if (dia != null && !tutor.estaDisponible(dia, horario.getBloquehorario())) {
                System.out.println("Error: El tutor no está disponible en ese horario.");
                return null;
            }
            gestorReservas.registrarReserva(tutor, materia, horario);
            for (Reserva r : gestorReservas.getListaReservasPendientes()) {
                if (r.getTutorAsociado().equals(tutor) &&
                    r.getMateria() == materia &&
                    r.getHorario().equals(horario)) {
                    return r;
                }
            }
            return null;
        } catch (IncompatibilityException e) {
            System.out.println("Error al crear reserva: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error inesperado al crear reserva: " + e.getMessage());
            return null;
        }

    }
    public String modificarReserva(Reserva reserva, Tutor tutor, Materias materia, Horario horario) {
        try {
            Tutor tutorAnterior = reserva.getTutorAsociado();
            gestorReservas.modificarReserva(reserva, tutor, materia, horario);

            if (!tutorAnterior.equals(tutor)) {
                tutorAnterior.quitarRerservaActiva(reserva);
                tutor.addReservaActiva(reserva);
            }
            return "Reserva modificada exitosamente.";
        } catch (IncompatibilityException | NoRepeatException | MaxCapacityReachedException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al modificar reserva: " + e.getMessage();
        }
    }

    public String cancelarReserva(Reserva reserva) {
        try {
            gestorReservas.cancelarReserva(reserva);
            return "Reserva cancelada exitosamente.";
        } catch (IncompatibilityException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al cancelar reserva: " + e.getMessage();
        }
    }

    public String completarReserva(Reserva reserva) {
        try {
            gestorReservas.completarReserva(reserva);
            return "Reserva completada exitosamente.";
        } catch (IncompatibilityException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al completar reserva: " + e.getMessage();
        }
    }

    public String agregarEstudianteAReserva(Reserva reserva, Estudiante estudiante) {
        try {
            gestorReservas.agregarEstudiantesReserva(reserva, estudiante);
            return "Estudiante agregado a la reserva exitosamente.";
        } catch (MaxCapacityReachedException | IncompatibilityException | NoRepeatException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado: " + e.getMessage();
        }
    }


    public String quitarEstudianteDeReserva(Reserva reserva, Estudiante estudiante) {
        try {
            gestorReservas.quitarEstudianteReserva(reserva, estudiante);
            if (reserva.getListaEstudiantes().isEmpty()) {
                return cancelarReserva(reserva) + " (La reserva quedó vacía y fue cancelada).";
            }
            return "Estudiante removido de la reserva exitosamente.";
        } catch (RemoveException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado: " + e.getMessage();
        }
    }

    public List<Reserva> obtenerReservasPendientes() {
        return gestorReservas.getListaReservasPendientes();
    }


    public List<Reserva> obtenerReservasCompletadas() {
        return gestorReservas.getListaReservasCompletadas();
    }

    public List<Reserva> obtenerReservasCanceladas() {
        return gestorReservas.getListaReservasCanceladas();
    }

    public List<Reserva> verCalendarioTutor(Tutor tutor, boolean pendientes) {
        List<Reserva> resultado = new ArrayList<>();
        FiltroInterface<Reserva> filtroNombre = new FiltroNombre(tutor.getNombre());

        if (pendientes) {
            resultado.addAll(gestorReservas.filtrador(
                gestorReservas.getListaReservasPendientes(), filtroNombre));
        }
        resultado.addAll(gestorReservas.filtrador(
            gestorReservas.getListaReservasCompletadas(), filtroNombre));
        resultado.addAll(gestorReservas.filtrador(
            gestorReservas.getListaReservasCanceladas(), filtroNombre));

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
