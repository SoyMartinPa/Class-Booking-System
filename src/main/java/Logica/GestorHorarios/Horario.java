package Logica.GestorHorarios;
import Excepciones.TimeException;
import Logica.Enumeraciones.BloquesHorarios;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Horario {
    private LocalDate fecha;
    private BloquesHorarios bloqueHorario;

    public Horario(BloquesHorarios bloqueHorario, LocalDate fecha){
        this.bloqueHorario = bloqueHorario;
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return bloqueHorario.getHoraInicio();
    }
    public LocalTime getHoraFin() {
        return bloqueHorario.getHoraFin();
    }
    public BloquesHorarios getBloquehorario(){
        return bloqueHorario;
    }
    public LocalDate getFecha() {
        return fecha;
    }


    public boolean horarioVigente(){
        if (this.getFecha().isBefore(LocalDate.now()) ){
            return false;
        }
        if (this.getFecha().isEqual(LocalDate.now())) {

            if (this.getBloquehorario().getHoraInicio().isBefore(LocalTime.now())) {
                return false;
            }
        }
        return true;
    }
    public void setHorario(Horario otroHorario) throws TimeException {
        if (!otroHorario.horarioVigente()){
            throw new TimeException("El horario se encuentra en el pasado");
        }
        this.fecha = otroHorario.getFecha();
        this.bloqueHorario = otroHorario.getBloquehorario();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Horario otro = (Horario) obj;
        return ( this.bloqueHorario == otro.bloqueHorario
                && this.fecha.equals(otro.fecha) );
    }

    @Override
    public int hashCode() {
        return Objects.hash(bloqueHorario, fecha);
    }
}
