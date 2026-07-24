package Logica.Perfiles;

import Excepciones.IncompatibilityException;
import Logica.Perfiles.GestorEstudiante.Estudiante;

import java.util.ArrayList;
import java.util.List;

public abstract class GestorBasico {

    private List<PerfilBasico> lista = new ArrayList<>();

    public GestorBasico(){}


    public void verificarNombre(String nombre){
        if (nombre == null){
            throw new NullPointerException("Nombre no pueden ser vacios");
        }
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*") ){
            throw new IncompatibilityException("Se debe ingresar nombre y apellido");
        }

        for (PerfilBasico objeto : lista){
            if(objeto.getNombre().equals(nombre)){
                throw new IncompatibilityException("Nombre o email ya registrado");
            }
        }
    }
    public void verificarEmail(String email){
        if (email == null){
            throw new NullPointerException("Email no pueden ser vacios");
        }
        if(!email.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$")){
            throw new IncompatibilityException("Email no valido");
        }
        for (PerfilBasico objeto : lista){
            if(objeto.getEmail().equals(email)){
                throw new IncompatibilityException("Email ya registrado");
            }
        }
    }
}
