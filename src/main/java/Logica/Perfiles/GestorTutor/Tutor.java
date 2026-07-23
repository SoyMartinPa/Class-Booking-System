package Logica.Perfiles.GestorTutor;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Dias;
import Logica.Enumeraciones.Materias;
import Logica.GestorReserva.Reserva;
import Logica.Perfiles.PerfilBasico;

import java.util.*;

public class Tutor extends PerfilBasico {
    private Map<Materias, OfertaMateria> oferta;
    private Map<Dias, Set<BloquesHorarios>> disponibilidad = new EnumMap<>(Dias.class);
    private List<Reserva> reservasActivas;

    Tutor(String nombre, String email) {
        super(nombre, email);
        this.oferta = new EnumMap<>(Materias.class);
    }

    public void ofrecerMateria(Materias materia, int tarifa, int cuposMax) {
        oferta.put(materia, new OfertaMateria(tarifa, cuposMax));
    }

    public void dejarDeOfrecer(Materias materia) {
        oferta.remove(materia);
    }

    public boolean dictaMateria(Materias materia) {
        return oferta.containsKey(materia);
    }

    public OfertaMateria getOferta(Materias materia) {
        return oferta.get(materia);
    }

    public void toggleDisponibilidad(Dias dia, BloquesHorarios bloque) {
        if (!disponibilidad.containsKey(dia)) {
            disponibilidad.put(dia, new HashSet<>());
        }
        Set<BloquesHorarios> bloquesDelDia = disponibilidad.get(dia);
        if (bloquesDelDia.contains(bloque)) {
            bloquesDelDia.remove(bloque);
        } else {
            bloquesDelDia.add(bloque);
        }
    }
    public boolean estaDisponible(Dias dia, BloquesHorarios bloque) {
        if (!disponibilidad.containsKey(dia)) {
            return false;
        }
        return disponibilidad.get(dia).contains(bloque);
    }
}

