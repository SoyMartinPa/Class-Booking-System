package Logica.Perfiles;

import Excepciones.IncompatibilityException;
import Logica.Perfiles.GestorEstudiante.Estudiante;

import java.util.List;

public abstract class GestorBasico {

    private List<PerfilBasico> lista;

    public GestorBasico(){}


    public void verificarNombreYEmail(String nombre, String email){
        if (nombre == null || email == null){
            throw new NullPointerException("Nombre o email no pueden ser vacios");
        }
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*") ){
            throw new IncompatibilityException("Se debe ingresar nombre y apellido");
        }

        if(!email.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$")){
            throw new IncompatibilityException("Email no valido");
        }
        for (PerfilBasico objeto : lista){
            if(objeto.getEmail().equals(email) || objeto.getNombre().equals(nombre)){
                throw new IncompatibilityException("Nombre o email ya registrado");
            }
        }



    }
}
