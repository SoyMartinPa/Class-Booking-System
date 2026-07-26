package Logica.Gestores;
import Excepciones.IncompatibilityException;
import Logica.Perfiles.Estudiante.Estudiante;

/**
 * Gestor encargado de administrar perfiles de tipo {@link Estudiante}.
 *
 * <p>Hereda las funcionalidades generales de validación y almacenamiento
 * definidas por {@link GestorBasico}, especializando el proceso de registro
 * para crear nuevos estudiantes y, futuramente, en otras cosas más.</p>
 */

public class GestorEstudiante extends GestorBasico<Estudiante> {

    public GestorEstudiante() {
        super();
    }

    @Override
    public void registrar(String nombre, String email) throws IncompatibilityException {
        verificarNombre(nombre);
        verificarEmail(email);
        Estudiante nuevoEstudiante = new Estudiante(nombre,email);
        lista.add(nuevoEstudiante);
        listaUsuarios.add(nuevoEstudiante);
    }
}