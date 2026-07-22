package Logica.Gestores.Reservas;

import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor;

import java.util.List;
import java.util.UUID;

public class Reserva {
    private String id;
    private Tutor tutorAsociado;
    private Materias materia;
    private List<Estudiante> listaEstudiantes = null;
    private Horario horario;
    private EstadoReserva estado;


    public void Reserva(Tutor tutor, Materias materia, Horario horario){
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.tutorAsociado = tutor;
        this.materia = materia;
        this.horario = horario;
        this.estado = new ReservaPendiente();
    }

}
