package Logica.Gestores.Reservas;

import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor;
import java.util.List;
import java.util.UUID;

public class Reserva{
    private int cuposMax;
    private int tarifa;
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
        return cuposMax;
    }

    public int getTarifa() {
        return tarifa;
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

    public void setCuposMax(int cuposMax) {
        this.cuposMax = cuposMax;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public void modificar(Tutor tutor, Materias materia, Horario horario, int tarifa, int cuposMax) {
        this.estado.modificar(this,tutor,materia,horario,tarifa,cuposMax);
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



