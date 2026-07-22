package Logica.Perfiles;
import Logica.Enumeraciones.Materias;
import Logica.GestorHorarios.Disponibilidad;
import Logica.Gestores.Reservas.Reserva;
import java.util.List;

public class Tutor extends PerfilBasico{
    private List<Materias> materias;
    private List<Disponibilidad> disponibilidad;
    private List<Reserva> reservasActivas;

    Tutor(String nombre, String email) {
        super(nombre, email);
    }

    public List<Materias> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materias> materias) {
        this.materias = materias;
    }

    public List<Disponibilidad> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(List<Disponibilidad> disponibilidad) {
        this.disponibilidad = disponibilidad; //Siempre y cuando ese bloque no este usado
    }

    public List<Reserva> getReservasActivas() {
        return reservasActivas;
    }

}

