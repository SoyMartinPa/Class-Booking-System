package Logica.Perfiles;

/**
 * Representa un Estudiante dentro del sistema.
 *
 * <p>Actualmente, no difiere de PerfilBasico, pero se espera que en un futuro pueda tener
 * una identidad más fuerte.</p>
 */

public class Estudiante extends PerfilBasico {

    public Estudiante(String nombre, String email){
        super(nombre,email);
    }

}
