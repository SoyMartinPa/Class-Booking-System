package Logica.Perfiles;
import Logica.GestorHorarios.Horario;
import Logica.Reservas.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class PerfilBasico {

    protected String id;
    protected String nombre;
    protected String email;
    protected List<Reserva> reservasActivas;

    public PerfilBasico(String nombre, String email){
        UUID uuid = UUID.randomUUID(); //Tal vés podría hacer que cada perfil tenga un identificador unico
        this.id = uuid.toString();
        this.nombre = nombre;
        this.email = email;
        this.reservasActivas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean reservaSeSolapa(Horario horario){
        if (reservasActivas == null) { return false;}

        for (Reserva cadaReserva : reservasActivas){
            if (cadaReserva.getHorario().equals(horario) ){ return true;}
            // no sería más fácil con un map?... Definitivamente, auch
        }

        return false;
    }
    public List<Reserva> getReservasActivas(){
        return reservasActivas;
    }
}
