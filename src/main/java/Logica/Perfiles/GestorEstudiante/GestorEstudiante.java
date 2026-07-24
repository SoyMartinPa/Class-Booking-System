package Logica.Perfiles.GestorEstudiante;

import Excepciones.RemoveException;
import Logica.GestorReserva.Reserva;
import Logica.Perfiles.GestorBasico;

import java.util.ArrayList;
import java.util.List;

public class GestorEstudiante extends GestorBasico {
    private List<Estudiante> lista;

    public GestorEstudiante() {
        this.lista = new ArrayList<>();
    }

    public void registar(String nombre, String email) throws NullPointerException{
        verificarNombreYEmail(nombre, email);
        lista.add(new Estudiante(nombre,email));
    }

    public void eliminar(Estudiante estudiante){
        List<Reserva> listaTemporal = new ArrayList<>(estudiante.getReservasActivas());

        if (!lista.contains(estudiante)){
            throw new RemoveException("Se intenta eliminar un estudiante no registrado");
        }
        
        for(Reserva reservasActivas : listaTemporal){
            estudiante.quitarRerservaActiva(reservasActivas);
            reservasActivas.quitarListaEstudiantes(estudiante);
        }




        lista.remove(estudiante);

        estudiante = null;
    }
    public void cambiarEmail(Estudiante estudiante, String email){
        verificarNombreYEmail(estudiante.getNombre(), email);
        estudiante.setEmail(email);

    }

    public List<Estudiante> getLista(){
        return lista;
    }




}
