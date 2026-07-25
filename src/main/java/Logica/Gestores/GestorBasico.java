package Logica.Gestores;
import Excepciones.IncompatibilityException;
import Excepciones.RemoveException;
import Logica.Perfiles.PerfilBasico;

import java.util.ArrayList;
import java.util.List;

public abstract class GestorBasico<T extends PerfilBasico> {

    protected List<T> lista;
    protected static List<PerfilBasico> listaUsuarios = new ArrayList<>();

    public GestorBasico(){
        this.lista = new ArrayList<>();
    }

    protected void verificarNombre(String nombre) throws IncompatibilityException{
        if (nombre == null){
            throw new NullPointerException("Nombre no pueden ser vacios");
        }
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+ [a-zA-ZáéíóúÁÉÍÓÚñÑ]+" )){
            throw new IncompatibilityException("Se debe ingresar nombre y apellido");
        }

        for (T objeto : lista){
            if(objeto.getNombre().equals(nombre)){
                throw new IncompatibilityException("Nombre o email ya registrado");
            }
        }
    }

    protected void verificarEmail(String email) throws IncompatibilityException{
        if (email == null){
            throw new NullPointerException("Email no pueden ser vacios");
        }
        if(!email.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$")){
            throw new IncompatibilityException("Email no valido");
        }
        for (PerfilBasico objeto : listaUsuarios){
            if(objeto.getEmail().equals(email)){
                throw new IncompatibilityException("Email ya registrado");
            }
        }
    }
    public void cambiarEmail(T usuario, String email) throws IncompatibilityException{
        verificarEmail(email);
        usuario.setEmail(email);
    }

    public List<T> getLista() {
        return lista;
    }

    public abstract void registrar(String nombre, String email) throws IncompatibilityException;
}
