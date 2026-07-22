package Logica.GestorHorarios;
import Logica.Enumeraciones.BloquesHorarios;
import java.time.LocalDate;
import java.time.LocalTime;

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
    public void setBloqueHorario(BloquesHorarios bloque){
        this.bloqueHorario = bloque;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
