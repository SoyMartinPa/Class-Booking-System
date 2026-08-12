package Logica.Gestores;
import Excepciones.EmailException;
import Excepciones.NameException;
import Excepciones.NoRepeatException;
import Logica.Perfiles.Estudiante;

/**
 * Gestor encargado de administrar perfiles de tipo {@link Estudiante}.
 *
 * <p>Hereda las funcionalidades generales de validación y almacenamiento
 * definidas por {@link GestorBasico}, especializando el proceso de registro
 * para crear nuevos estudiantes y, futuramente, en otras cosas más.</p>
 */

public class GestorEstudiante extends GestorBasico<Estudiante> {

    protected GestorEstudiante() {
        super();
    }

    @Override
    public void registrar(String nombre, String email) throws NullPointerException, EmailException, NameException, NoRepeatException{
        verificarNombre(nombre);
        verificarEmail(email);
        Estudiante nuevoEstudiante = new Estudiante(nombre,email);
        getListaInterna().add(nuevoEstudiante);
        getListaCompletaInterna().add(nuevoEstudiante);
    }
    public void quitarDeLista(Estudiante estudiante){
        getListaInterna().remove(estudiante);
    }
}