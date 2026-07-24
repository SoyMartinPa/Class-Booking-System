package Logica.GestorReserva;
import Excepciones.IncompatibilityException;
import Excepciones.MaxCapacityReachedException;
import Excepciones.NoRepeatException;
import Excepciones.RemoveException;
import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.GestorTutor.Tutor;

import java.util.List;

public class GestorReserva {
    private static List<Reserva> listaReservasPendientes;
    private static List<Reserva> listaReservasCompletadas;
    private static List<Reserva> listaReservasCanceladas;

    public GestorReserva() {
    }

    public Boolean tutorPuedeReservar(Tutor tutor, Materias materia, Horario horario) {

        if (tutor.reservaSeSolapa(horario)) {
            return false;
        }
        if (!tutor.dictaMateria(materia)) {
            return false;
        }
        return true;
    }

    public void registrarReserva(Tutor tutor, Materias materia, Horario horario)
            throws IncompatibilityException {

        if (!tutorPuedeReservar(tutor, materia, horario)) {
            throw new IncompatibilityException("El profesor no puede reservar esa materia en ese horario");
        }

        listaReservasPendientes.add(new Reserva(tutor, materia, horario));
    }

    public void cancelarReserva(Reserva reserva) throws IncompatibilityException {
        if (!this.listaReservasPendientes.contains(reserva)) {
            throw new IncompatibilityException("La reserva no existe o ya no puede ser cancelada");
        }

        this.listaReservasPendientes.remove(reserva);
        this.listaReservasCanceladas.add(reserva);
        reserva.cancelar();
    }

    public void completarReserva(Reserva reserva) throws IncompatibilityException {
        if (!this.listaReservasPendientes.contains(reserva)) {
            throw new IncompatibilityException("La reserva no existe o ya no puede ser completada");
        }

        this.listaReservasPendientes.remove(reserva);
        this.listaReservasCompletadas.add(reserva);
        reserva.completar();
    }

    public void modificarReserva(Reserva reserva, Tutor tutor, Materias materia, Horario horario) {
        if (!tutorPuedeReservar(tutor, materia, horario)) {
            throw new IncompatibilityException("El profesor no puede reservar esa materia en ese horario");
        } else {
            reserva.modificar(tutor, materia, horario);
        }
    }

    public void agregarEstudiantesReserva(Reserva reserva, Estudiante estudiante)
            throws MaxCapacityReachedException, NoRepeatException {

        if (reserva.getListaEstudiantes().size() >= reserva.getCuposMax()) {
            throw new MaxCapacityReachedException("No se puede agregar al estudiante debido a un sobrecupo");
        }
        if (reserva.getListaEstudiantes().contains(estudiante)) {
            throw new NoRepeatException("Se intenta agregar un alumno que ya pertenece a la reserva");
        }
        reserva.agregarListaEstudiantes(estudiante);
    }

    public void quitarEstudianteReserva(Reserva reserva, Estudiante estudiante)
            throws RemoveException{

        if (!reserva.getListaEstudiantes().contains(estudiante)){
            throw new RemoveException("Se intenta quitar un alumno que no pertenece a la reserva");
        }
        reserva.quitarListaEstudiantes(estudiante);
    }
}
