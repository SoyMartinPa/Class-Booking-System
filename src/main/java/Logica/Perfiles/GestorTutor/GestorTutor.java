package Logica.Perfiles.GestorTutor;

import Excepciones.RemoveException;
import Logica.GestorReserva.Reserva;
import Logica.Perfiles.GestorBasico;

import java.util.ArrayList;
import java.util.List;

public class GestorTutor extends GestorBasico {
    private List<Tutor> lista;

    public GestorTutor(){
        this.lista = new ArrayList<>();
    }


    public void registar(String nombre, String email) throws NullPointerException{
        verificarNombre(nombre);
        verificarEmail(email);
        lista.add(new Tutor(nombre,email));
    }

    public void eliminar(Tutor tutor){
        List<Reserva> listaTemporal = new ArrayList<>(tutor.getReservasActivas());

        if (!lista.contains(tutor)){
            throw new RemoveException("Se intenta eliminar un tutor no registrado");
        }

        for(Reserva reservasActivas : listaTemporal){
            tutor.quitarRerservaActiva(reservasActivas);
            reservasActivas = null;
        }

    }
    public void cambiarEmail(Tutor tutor, String email){
        verificarEmail(email);
        tutor.setEmail(email);
    }

    public List<Tutor> getLista(){
        return lista;
    }
}
