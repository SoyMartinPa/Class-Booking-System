package Logica.Enumeraciones;

import java.time.LocalTime;

/**
 * Representa los bloques horarios disponibles para las tutorías.
 *
 * <p>Cada bloque tiene una duración fija de una hora y se identifica
 * por un horario de inicio y uno de término.
 */
public enum BloquesHorarios {
    BLOQUE8_9( LocalTime.of(8,0) , LocalTime.of(9,0) ),
    BLOQUE9_10( LocalTime.of(9,0) , LocalTime.of(10,0) ),
    BLOQUE10_11( LocalTime.of(10,0) , LocalTime.of(11,0) ),
    BLOQUE11_12( LocalTime.of(11,0) , LocalTime.of(12,0) ),
    BLOQUE12_13( LocalTime.of(12,0) , LocalTime.of(13,0) ),
    BLOQUE13_14( LocalTime.of(13,0) , LocalTime.of(14,0) ),
    BLOQUE14_15( LocalTime.of(14,0) , LocalTime.of(15,0) ),
    BLOQUE15_16( LocalTime.of(15,0) , LocalTime.of(16,0) ),
    BLOQUE16_17( LocalTime.of(16,0) , LocalTime.of(17,0) ),
    BLOQUE17_18( LocalTime.of(17,0) , LocalTime.of(18,0) ),
    BLOQUE18_19( LocalTime.of(18,0) , LocalTime.of(19,0) ),
    BLOQUE19_20( LocalTime.of(19,0) , LocalTime.of(20,0) );

    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    BloquesHorarios(LocalTime horaInicio, LocalTime horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    /**
     * Obtiene la hora de inicio del bloque horario.
     *
     * @return hora en que comienza el bloque.
     */

    public LocalTime getHoraInicio() {

        return horaInicio;
    }

    /**
     * Obtiene la hora de término del bloque horario.
     *
     * @return hora en que finaliza el bloque.
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    @Override
    public String toString() {
        String texto = name().substring(0,1) + name().substring(6);
        return texto;
    }
}

