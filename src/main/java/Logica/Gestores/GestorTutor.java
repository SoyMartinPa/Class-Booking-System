package Logica.Gestores;

import Excepciones.IncompatibilityException;
import Logica.Perfiles.Tutor.Tutor;

public class GestorTutor extends GestorBasico<Tutor> {
    protected GestorTutor() {
        super();
    }

    @Override
    public void registrar(String nombre, String email) throws IncompatibilityException {
        verificarNombre(nombre);
        verificarEmail(email);
        Tutor nuevoTutor = new Tutor(nombre, email);
        lista.add(nuevoTutor);
        listaUsuarios.add(nuevoTutor);
    }

}