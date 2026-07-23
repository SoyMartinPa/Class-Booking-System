package Logica.GestorReserva;

import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.GestorTutor.Tutor;
import java.util.List;
import java.util.UUID;

public class Reserva{
    private String id;
    private Tutor tutorAsociado;
    private Materias materia;
    private List<Estudiante> listaEstudiantes = null;
    private Horario horario;
    private EstadoReserva estado;


    public Reserva(Tutor tutor, Materias materia, Horario horario) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.tutorAsociado = tutor;
        this.materia = materia;
        this.horario = horario;
        this.estado = new ReservaPendiente();
        //Agegar a lista pendiente
    }

    public String getId() {
        return id;
    }

    public int getCuposMax() {
        return tutorAsociado.getOferta(materia).getCuposMax();
    }
    public Boolean estaLlena(){
        return (listaEstudiantes.size() >= this.getCuposMax());
    }

    public int getTarifa() {
        return tutorAsociado.getOferta(materia).getTarifa();
    }

    public Tutor getTutorAsociado() {
        return tutorAsociado;
    }

    public void setTutorAsociado(Tutor tutorAsociado) {
        this.tutorAsociado = tutorAsociado;
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void agregarListaEstudiantes(Estudiante estudiante) {
        estado.agregarListaEstudiantes(this, estudiante);
    }

    public void quitarListaEstudiantes(Estudiante estudiante) {
        estado.quitarListaEstudiantes(this, estudiante);
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void modificar(Tutor tutor, Materias materia, Horario horario) {
        this.estado.modificar(this,tutor,materia,horario);
    }

    public void completar() {
        this.estado.completar(this);
    }

    public void cancelar() {
        this.estado.cancelar(this);
    }

    public EstadoReserva getEstado(Reserva reserva) {
        return reserva.getEstado();
    }
    public void setEstado(EstadoReserva estado){
        this.estado = estado;
    }
}



