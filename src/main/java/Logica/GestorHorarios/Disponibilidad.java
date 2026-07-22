package Logica.GestorHorarios;

import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Dias;

import java.time.LocalDate;
import java.time.LocalTime;

public class Disponibilidad {
    private Dias dia;
    private BloquesHorarios bloqueHorario;

    Disponibilidad(Dias dia, BloquesHorarios bloqueHorario){
        this.dia = dia;
        this.bloqueHorario = bloqueHorario;
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
    public void setBloqueHorario(BloquesHorarios bloqueHorario){
        this.bloqueHorario = bloqueHorario;
    }

    public Dias getdia() {
        return dia;
    }
    public void setDia(Dias dia) {
        this.dia = dia;
    }

    // principio DRY roto con Horario y Diponibilidad, arreglar
}


