package Logica.GestorReserva;

import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.GestorTutor.Tutor;

public interface EstadoReserva {
    void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario);
    void completar(Reserva reserva);
    void cancelar(Reserva reserva);
    EstadoReserva getEstado(Reserva reserva);
    void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante);
    void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante);
}
