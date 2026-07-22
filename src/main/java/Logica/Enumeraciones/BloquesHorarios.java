package Logica.Enumeraciones;

import java.time.LocalTime;

public enum BloquesHorarios {
    BLOQUE1( LocalTime.of(8,0) , LocalTime.of(9,0) ),
    BLOQUE2( LocalTime.of(9,0) , LocalTime.of(10,0) ),
    BLOQUE3( LocalTime.of(10,0) , LocalTime.of(11,0) ),
    BLOQUE4( LocalTime.of(11,0) , LocalTime.of(12,0) ),
    BLOQUE5( LocalTime.of(12,0) , LocalTime.of(13,0) ),
    BLOQUE6( LocalTime.of(13,0) , LocalTime.of(14,0) ),
    BLOQUE7( LocalTime.of(14,0) , LocalTime.of(15,0) ),
    BLOQUE8( LocalTime.of(15,0) , LocalTime.of(16,0) ),
    BLOQUE9( LocalTime.of(16,0) , LocalTime.of(17,0) ),
    BLOQUE10( LocalTime.of(17,0) , LocalTime.of(18,0) ),
    BLOQUE11( LocalTime.of(18,0) , LocalTime.of(19,0) ),
    BLOQUE12( LocalTime.of(19,0) , LocalTime.of(20,0) );

    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    BloquesHorarios(LocalTime horaInicio, LocalTime horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public LocalTime getHoraFin() {
        return horaFin;
    }
}

