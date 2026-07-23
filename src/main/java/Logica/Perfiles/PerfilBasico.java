package Logica.Perfiles;

import Excepciones.NoRepeatException;
import Excepciones.RemoveException;
import Logica.GestorReserva.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class PerfilBasico {
    String id;
    String nombre;
    String email;
    List<Reserva> reservasActivas;

    public PerfilBasico(String nombre, String email){
        UUID uuid = UUID.randomUUID();
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean reservaSeSolapa(Reserva reserva){
        if (this.reservasActivas.contains(reserva)){
            return false;
        }
        for (Reserva cadaReserva : reservasActivas){
            if (cadaReserva.getHorario().equals(reserva.getHorario())){ return  false;}
        }
        return true;
    }

    public void addReservaActiva(Reserva reserva) throws NoRepeatException {
        if (!reservaSeSolapa(reserva)){
            throw new NoRepeatException("No se puede generar esta reserva en este horario");
        }
        this.reservasActivas.add(reserva);
    }
    public void quitarRerservaActiva(Reserva reserva) throws RemoveException {
        if (this.reservasActivas.contains(reserva) ){
            throw new RemoveException("La reserva no existe");
        }
        this.reservasActivas.remove(reserva);
    }
    public List<Reserva> getReservasActivas(){
        return reservasActivas;
    }
}
