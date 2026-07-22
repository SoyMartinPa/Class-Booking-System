package Logica.Gestores.Reservas;

import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor;

import java.util.List;

public interface EstadoReserva {
    void modificar(Reserva reserva, Tutor tutor, Materias materia, Horario horario, int tarifa, int cuposMax);
    void completar(Reserva reserva);
    void cancelar(Reserva reserva);
    EstadoReserva getEstado(Reserva reserva);
    void agregarListaEstudiantes(Reserva reserva, Estudiante estudiante);
    void quitarListaEstudiantes(Reserva reserva, Estudiante estudiante);
}
