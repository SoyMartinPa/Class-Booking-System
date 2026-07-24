package Logica.GestorReserva;
import Excepciones.IncompatibilityException;
import Excepciones.MaxCapacityReachedException;
import Excepciones.NoRepeatException;
import Excepciones.RemoveException;
import Logica.Enumeraciones.Materias;
import Logica.Filtros.FiltroInterface;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.GestorTutor.Tutor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestorReserva {
    private  List<Reserva> listaReservasPendientes;
    private List<Reserva> listaReservasCompletadas;
    private List<Reserva> listaReservasCanceladas;

    public GestorReserva() {
    }

    public Boolean reservaValidar(Tutor tutor, Materias materia, Horario horario){

        if ( horario.getFecha().isBefore(LocalDate.now()) ){
            return false;
        }
        if (horario.getFecha().equals(LocalDate.now())){
            if (horario.getBloquehorario().getHoraInicio().isBefore(LocalTime.now())){
                return false;
            }
        }
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

        if (!reservaValidar(tutor, materia, horario)) {
            throw new IncompatibilityException("El profesor no puede reservar esa materia en ese horario");
        }
        Reserva nuevaReserva = new Reserva(tutor, materia, horario);
        listaReservasPendientes.add(nuevaReserva);
        tutor.addReservaActiva(nuevaReserva);
    }

    public void cancelarReserva(Reserva reserva) throws IncompatibilityException {
        if (!this.listaReservasPendientes.contains(reserva)) {
            throw new IncompatibilityException("La reserva no existe o ya no puede ser cancelada");
        }

        this.listaReservasPendientes.remove(reserva);
        this.listaReservasCanceladas.add(reserva);
        reserva.getTutorAsociado().quitarRerservaActiva(reserva);
        for (Estudiante estudiante : reserva.getListaEstudiantes()){
            estudiante.quitarRerservaActiva(reserva);
        }

        reserva.cancelar();
    }

    public void completarReserva(Reserva reserva) throws IncompatibilityException {
        if (!this.listaReservasPendientes.contains(reserva)) {
            throw new IncompatibilityException("La reserva no existe o ya no puede ser completada");
        }

        this.listaReservasPendientes.remove(reserva);
        this.listaReservasCompletadas.add(reserva);
        reserva.getTutorAsociado().quitarRerservaActiva(reserva);
        for (Estudiante estudiante : reserva.getListaEstudiantes()){
            estudiante.quitarRerservaActiva(reserva);
        }

        reserva.completar();
    }


    public void modificarReserva(Reserva reserva, Tutor tutor, Materias materia, Horario horario) {
        if (!reservaValidar(tutor, materia, horario)) {
            throw new IncompatibilityException("El profesor no puede reservar esa materia en ese horario");
        }
        if (reserva.getListaEstudiantes().size() > tutor.getOferta(materia).getCuposMax()) {
            throw new MaxCapacityReachedException("El nuevo tutor tiene menos cupos que estudiantes actuales");
        }
        reserva.getTutorAsociado().quitarRerservaActiva(reserva);
        reserva.modificar(tutor, materia, horario);
        tutor.addReservaActiva(reserva);
    }

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
        estudiante.addReservaActiva(reserva);
    }

    public void quitarEstudianteReserva(Reserva reserva, Estudiante estudiante)
            throws RemoveException{

        if (!reserva.getListaEstudiantes().contains(estudiante)){
            throw new RemoveException("Se intenta quitar un alumno que no pertenece a la reserva");
        }
        reserva.quitarListaEstudiantes(estudiante);
        estudiante.quitarRerservaActiva(reserva);
    }

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
}
