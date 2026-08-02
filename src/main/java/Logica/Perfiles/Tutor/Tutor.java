package Logica.Perfiles.Tutor;
import Excepciones.IncompatibilityException;
import Excepciones.NoValidNumberException;
import Excepciones.RemoveException;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Dias;
import Logica.Enumeraciones.Materias;
import Logica.Perfiles.PerfilBasico;
import Logica.Reservas.Horario;

import java.time.LocalDate;
import java.util.*;

/**
 * Representa un tutor dentro del sistema.
 *
 * <p>Un tutor es un tipo de perfil que puede ofrecer materias,
 * estableciendo una tarifa y una cantidad máxima de estudiantes permitidos
 * para cada una de ellas.</p>
 *
 * <p>Además, mantiene una disponibilidad horaria, representada mediante
 * días de la semana y bloques horarios en los que puede realizar reservas.</p>
 *
 * <p>La disponibilidad permite determinar si el tutor puede aceptar una
 * reserva en una fecha específica, convirtiendo dicha fecha al día de la
 * semana correspondiente y verificando los bloques disponibles.</p>
 *
 * <p>Hereda la información básica {@link PerfilBasico} y agrega la gestión
 * de ofertas académicas y horarios disponibles.</p>
 */

public class Tutor extends PerfilBasico {
    private final Map<Materias, OfertaMateria> oferta = new EnumMap<>(Materias.class);
    private final Map<Dias, Set<BloquesHorarios>> disponibilidad = new EnumMap<>(Dias.class);

    public Tutor(String nombre, String email) {
        super(nombre, email);
    }
    
    public OfertaMateria getOferta(Materias materia) {
        return oferta.get(materia);
    }
    public Map<Materias, OfertaMateria> getOfertaTotal(){
        return oferta;
    }

    public Map<Dias, Set<BloquesHorarios>> getDisponibilidad() {
        return disponibilidad;
    }
    
    /**
     * Verifica si el tutor actualmente ofrece una determinada materia.
     *
     * @param materia materia que será consultada.
     * @return {@code true} si la materia está dentro de la oferta del tutor,
     *         {@code false} en caso contrario.
     */
    public boolean dictaMateria(Materias materia) {
        return oferta.containsKey(materia);
    }

    /**
     * Permite al tutor ofrecer una nueva materia indicando su tarifa y cantidad
     * máxima de estudiantes permitidos.
     * @param materia materia que será ofrecida.
     * @param tarifa costo asociado a la clase.
     * @param cuposMax cantidad máxima de estudiantes permitidos.
     * @throws NoValidNumberException si la tarifa o los cupos son menores
     *         o iguales a cero.
     */

    public void ofrecerMateria(Materias materia, int tarifa, int cuposMax) throws NoValidNumberException{
        if (tarifa <= 0) {
            throw new NoValidNumberException("La tarifa debe ser positiva");
        }
        if (cuposMax <= 0) {
            throw new NoValidNumberException("Los cupos deben ser mayor que zero");
        }
        oferta.put(materia, new OfertaMateria(tarifa, cuposMax));
    }

    /**
     * Elimina una materia de las ofertas disponibles del tutor.
     *
     * @param materia materia que dejará de ser ofrecida.
     * @throws IncompatibilityException si el tutor no tiene dicha materia
     *         dentro de sus ofertas.
     */
    public void dejarDeOfrecer(Materias materia) throws IncompatibilityException{
        if (!dictaMateria(materia)) {
            throw new IncompatibilityException("El tutor no imparte esta materia");
        }
        oferta.remove(materia);
    }

    /**
     * Agrega un bloque horario a la disponibilidad del tutor.
     *
     * <p>Si el día no posee bloques registrados previamente, se crea
     * automáticamente una nueva colección para almacenar sus horarios.</p>
     *
     * @param dia día de la semana disponible.
     * @param bloque bloque horario disponible.
     */
    public void agregarDisponibilidad(Dias dia, BloquesHorarios bloque) {
        if (!disponibilidad.containsKey(dia)) {
            disponibilidad.put(dia, new HashSet<>());
        }
        Set<BloquesHorarios> bloquesDelDia = disponibilidad.get(dia);
        bloquesDelDia.add(bloque);
    }
    
    /**
     * Eliminaun bloque horario a la disponibilidad del tutor.
     *
     * <p>Si el tutor tiene disponibilidad en el dia y bloque asignado.
     * este se eliminará.</p>
     *
     * @param dia día de la semana disponible.
     * @param bloque bloque horario disponible.
     * @throws RemoveException si no tiene disponibilidad en ese día
     */
    public void quitarDisponibilidad(Dias dia, BloquesHorarios bloque) throws RemoveException{
        if (!disponibilidad.containsKey(dia)) {
            throw new RemoveException("No existe disponibilidad en ese momento");
        }
        Set<BloquesHorarios> bloquesDelDia = disponibilidad.get(dia);
        bloquesDelDia.remove(bloque);
    }

    /**
     * Convierte un objeto de fecha al día de la semana utilizado por el sistema.
     * @param fecha fecha que será convertida.
     * @return día equivalente dentro de la enumeración {@link Dias}.
     */

    public Dias diasDesdeFecha(LocalDate fecha) {
        return switch (fecha.getDayOfWeek()) {
            case MONDAY -> Dias.LUNES;
            case TUESDAY -> Dias.MARTES;
            case WEDNESDAY -> Dias.MIERCOLES;
            case THURSDAY -> Dias.JUEVES;
            case FRIDAY -> Dias.VIERNES;
            default -> null;
        };
    }
    /**
     * Verifica si el tutor tiene disponibilidad para un bloque horario
     * específico en una fecha determinada.
     *
     * @param fecha fecha que será consultada.
     * @param bloque bloque horario requerido.
     * @return {@code true} si el tutor está disponible en ese horario,
     *         {@code false} si no posee disponibilidad registrada.
     */
    public boolean estaDisponible(LocalDate fecha, BloquesHorarios bloque) {
        if (!disponibilidad.containsKey(diasDesdeFecha(fecha))) {
            return false;
        }
        if (!disponibilidad.get(diasDesdeFecha(fecha)).contains(bloque)){
            return false;
        }
        Horario horarioTemporal = new Horario(bloque,fecha);
        return !this.reservaSeSolapa(horarioTemporal);
    }
    
    public boolean estaDisponible(Dias dia, BloquesHorarios bloque) {
    if (!disponibilidad.containsKey(dia)) {
        return false;
    }
    if (!disponibilidad.get(dia).contains(bloque)){
        return false;
    }
    return true;
    }
}

