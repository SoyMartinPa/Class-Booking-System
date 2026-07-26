package Logica.Reservas;
import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Horario;
import Logica.Perfiles.Estudiante.Estudiante;
import Logica.Perfiles.Tutor.Tutor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Reserva que conecta un tutor con una lista de estudiantes en un determinado horario
 * <p>Esta clase incorpora una identificación única, un tutor, una matería, una lista de
 * estudiantes, un horario y el estado actual de la reserva</p>
 */
public class Reserva{
    private final String id;
    private Tutor tutorAsociado;
    private Materias materia;
    private final List<Estudiante> listaEstudiantes = new ArrayList<>();
    private Horario horario;
    private EstadoReserva estado;


    public Reserva(Tutor tutor, Materias materia, Horario horario) {
        UUID uuid = UUID.randomUUID(); //Podria haber otro sistema de ID más interesante
        this.id = uuid.toString();
        this.tutorAsociado = tutor;
        this.materia = materia;
        this.horario = horario;
        this.estado = new ReservaPendiente();
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
        estado.completar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    protected void setEstado(EstadoReserva estado){
        this.estado = estado;
    }
}



