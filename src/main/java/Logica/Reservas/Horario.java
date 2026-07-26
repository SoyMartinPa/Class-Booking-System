package Logica.Reservas;
import Excepciones.TimeException;
import Logica.Enumeraciones.BloquesHorarios;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Representa un horario específico dentro del sistema.
 *
 * <p>Un horario está compuesto por una fecha determinada y un bloque horario,
 * donde el bloque define el intervalo de tiempo en el que ocurre la actividad.</p>
 *
 * <p>Esta clase permite consultar la vigencia de un horario y modificarlo
 * siempre que el nuevo horario corresponda a una fecha futura o al bloque
 * horario actual aún no iniciado.</p>
 */

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

    /**
     * Determina si el horario todavía puede ser utilizado.
     *
     * <p>Un horario se considera vigente si pertenece a una fecha futura,
     * o si corresponde al día actual pero su hora de inicio aún no ha ocurrido.</p>
     *
     * @return {@code true} si el horario sigue disponible,
     *         {@code false} si ya pasó.
     */
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
    /**
     * Reemplaza el horario actual por otro horario válido.
     *
     * @param otroHorario nuevo horario que será asignado.
     * @throws TimeException si el horario recibido ya ocurrió.
     */
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
