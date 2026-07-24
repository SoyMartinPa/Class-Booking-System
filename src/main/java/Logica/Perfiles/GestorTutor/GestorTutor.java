package Logica.Perfiles.GestorTutor;

import Excepciones.RemoveException;
import Logica.GestorReserva.Reserva;
import Logica.Perfiles.GestorBasico;
import Logica.Perfiles.GestorEstudiante.Estudiante;
import Logica.Perfiles.PerfilBasico;

import java.util.ArrayList;
import java.util.List;

public class GestorTutor extends GestorBasico {
    private List<Tutor> lista;

    public GestorTutor(){
        this.lista = new ArrayList<>();
    }


    public void registar(String nombre, String email) throws NullPointerException{
        verificarNombreYEmail(nombre, email);
        lista.add(new Tutor(nombre,email));
    }

    public void eliminar(Tutor tutor){

        if (!lista.contains(tutor)){
            throw new RemoveException("Se intenta elimnar un estudiante no registrado");
        }
        for(Reserva reservasActivas : tutor.getReservasActivas()){
            tutor.quitarRerservaActiva(reservasActivas);
            reservasActivas = null;
        }
        lista.remove(tutor);

        tutor = null;
    }
    public void cambiarEmail(Tutor tutor, String email){
        verificarNombreYEmail(tutor.getNombre(), email);
        tutor.setEmail(email);
    }

    public List<Tutor> getLista(){
        return lista;
    }
}
