package Logica.Gestores;
import Excepciones.IncompatibilityException;
import Logica.Perfiles.Estudiante.Estudiante;


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