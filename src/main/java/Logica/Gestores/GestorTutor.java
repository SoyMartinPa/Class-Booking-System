package Logica.Gestores;

import Excepciones.EmailException;
import Excepciones.NoRepeatException;
import Logica.Perfiles.Tutor.Tutor;
/**
 * Gestor encargado de administrar perfiles de tipo {@link Tutor}.
 *
 * <p>Hereda las funcionalidades generales de validación y almacenamiento
 * definidas por {@link GestorBasico}, especializando el proceso de registro
 * para crear nuevos tutores y, futuramente, otras cosas más.</p>
 */
public class GestorTutor extends GestorBasico<Tutor> {
    protected GestorTutor() {
        super();
    }

    @Override
    public void registrar(String nombre, String email) throws NoRepeatException, NullPointerException, EmailException {
        verificarNombre(nombre);
        verificarEmail(email);
        Tutor nuevoTutor = new Tutor(nombre, email);
        getListaInterna().add(nuevoTutor);
        getListaCompletaInterna().add(nuevoTutor);
    }
    public void quitarDeLista(Tutor tutor){
        getListaInterna().remove(tutor);
    }
}