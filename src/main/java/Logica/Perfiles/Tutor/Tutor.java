package Logica.Perfiles.Tutor;
import Excepciones.IncompatibilityException;
import Excepciones.NoValidNumberException;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Dias;
import Logica.Enumeraciones.Materias;
import Logica.Perfiles.PerfilBasico;

import java.time.LocalDate;
import java.util.*;

public class Tutor extends PerfilBasico {
    private Map<Materias, OfertaMateria> oferta;
    private Map<Dias, Set<BloquesHorarios>> disponibilidad = new EnumMap<>(Dias.class);

    public Tutor(String nombre, String email) {
        super(nombre, email);
        this.oferta = new EnumMap<>(Materias.class);
    }

    public void ofrecerMateria(Materias materia, int tarifa, int cuposMax) throws NoValidNumberException{
        if (tarifa <= 0) {
            throw new NoValidNumberException("La tarifa debe ser positiva");
        }
        if (cuposMax <= 0) {
            throw new NoValidNumberException("Los cupos deben ser mayor que zero");
        }
        oferta.put(materia, new OfertaMateria(tarifa, cuposMax));
    }

    public void dejarDeOfrecer(Materias materia) throws IncompatibilityException{
        if (!dictaMateria(materia)) {
            throw new IncompatibilityException("El tutor no imparte esta materia");
        }
        oferta.remove(materia);
    }

    public boolean dictaMateria(Materias materia) {
        return oferta.containsKey(materia);
    }

    public OfertaMateria getOferta(Materias materia) {
        return oferta.get(materia);
    }

    public void agregarDisponibilidad(Dias dia, BloquesHorarios bloque) {
        if (!disponibilidad.containsKey(dia)) {
            disponibilidad.put(dia, new HashSet<>());
        }
        Set<BloquesHorarios> bloquesDelDia = disponibilidad.get(dia);
        bloquesDelDia.add(bloque);
    }

    private Dias diasDesdeFecha(LocalDate fecha) {
        return switch (fecha.getDayOfWeek()) {
            case MONDAY -> Dias.LUNES;
            case TUESDAY -> Dias.MARTES;
            case WEDNESDAY -> Dias.MIERCOLES;
            case THURSDAY -> Dias.JUEVES;
            case FRIDAY -> Dias.VIERNES;
            default -> null;
        };
    }
    public boolean estaDisponible(LocalDate fecha, BloquesHorarios bloque) {
        if (!disponibilidad.containsKey(diasDesdeFecha(fecha))) {
            return false;
        }
        return disponibilidad.get(diasDesdeFecha(fecha)).contains(bloque);
    }
}

