package Logica.Gestores;
import Excepciones.EmailException;
import Excepciones.NameException;
import Excepciones.NoRepeatException;
import Logica.Perfiles.PerfilBasico;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que define la estructura común para gestores de perfiles.
 *
 * <p>Permite administrar una colección de objetos que heredan de
 * {@link PerfilBasico}, proporcionando funcionalidades compartidas como
 * validación de nombres y correos electrónicos.</p>
 *
 * <p>El parámetro genérico permite que cada gestor trabaje con un tipo
 * específico de perfil manteniendo seguridad de tipos.</p>
 *
 * @param <T> tipo de perfil administrado por el gestor.
 */

public abstract class GestorBasico<T extends PerfilBasico> {

    protected List<T> lista;
    /**
     * Lista global de usuarios registrados en el sistema.
     *
     * <p>Permite verificar información que debe ser única entre todos los
     * tipos de perfiles, como el correo electrónico.</p>
     */
    protected static List<PerfilBasico> listaUsuarios = new ArrayList<>();

    public GestorBasico(){
        this.lista = new ArrayList<>();
    }
    /**
     * Verifica que un nombre cumpla con las restricciones del sistema.
     *
     * <p>El nombre debe contener nombres y apellidos separados por un espacio,
     * además de no estar registrado previamente dentro del gestor.</p>
     *
     * @param nombre nombre que será validado.
     * @throws NullPointerException si el nombre es nulo.
     * @throws NameException si el formato del nombre es inválido
     *         o ya existe un perfil con ese nombre.
     */
    public void verificarNombre(String nombre) throws NameException, NullPointerException, NoRepeatException {

        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo");
        }

        nombre = nombre.trim();

        String[] partes = nombre.split("\\s+");

        if (partes.length < 3) {
            throw new NameException(
                    "Debe ingresar al menos un nombre y dos apellidos");
        }

        for (String parte : partes) {
            if (!parte.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                throw new NameException("El nombre contiene caracteres inválidos");
            }
            if (parte.length() <= 1){
                throw new NameException("El nombre no puede ser una letra");
            }
        }

        for (PerfilBasico objeto : listaUsuarios) {
            if (objeto.getNombre().equalsIgnoreCase(nombre)) {
                throw new NoRepeatException("Nombre ya registrado");
            }
        }
    }

    /**
     * Verifica que un correo electrónico sea válido y no esté registrado.
     *
     * <p>La validación se realiza contra la lista global de usuarios,
     * debido a que un correo no puede pertenecer a más de un perfil.</p>
     *
     * @param email correo electrónico que será validado (Solo @gmail.com valido de momento).
     * @throws NullPointerException si el correo es nulo.
     * @throws EmailException si el formato del correo es inválido
     * @throws NoRepeatException si el correo ya está registrado
     */
    public void verificarEmail(String email) throws NoRepeatException, NullPointerException, EmailException {
        if (email == null){
            throw new NullPointerException("Email no pueden ser vacios");
        }
        if (!email.matches("^[\\w.+-]+@gmail\\.com$")) {
            throw new EmailException("Solo se permiten correos Gmail");
        }
        for (PerfilBasico objeto : listaUsuarios){
            if(objeto.getEmail().equals(email)){
                throw new NoRepeatException("Email ya registrado");
            }
        }
    }
    /**
     * Actualiza el correo electrónico de un usuario verificando previamente
     * que el nuevo correo sea válido y no esté ocupado.
     *
     * @param usuario perfil cuyo correo será modificado.
     * @param email nuevo correo electrónico.
     * @throws EmailException si el correo no cumple las reglas de validación.
     * @throws NoRepeatException si el correo ya está registrado
     */
    public void cambiarEmail(T usuario, String email) throws NoRepeatException,NullPointerException,EmailException{
        verificarEmail(email);
        usuario.setEmail(email);
    }
    
    /**
     * Actualiza el nombre de un usuario verificando previamente
     * que el nuevo nombre sea válido y no esté ocupado.
     *
     * @param usuario perfil cuyo correo será modificado.
     * @param nombre nombre del nuevo usuario.
     * @throws NameException si el nombre no cumple las reglas de validación.
     * @throws NoRepeatException si el nombre ya está registrado
     */
    public void cambiarNombre(T usuario, String nombre) throws NoRepeatException,NullPointerException,NameException{
    verificarNombre(nombre);
    usuario.setNombre(nombre);
    }

    /**
     * Registra un nuevo perfil dentro del gestor.
     *
     * <p>Cada implementación concreta debe definir la forma específica
     * de creación y almacenamiento del perfil.</p>
     *
     * @param nombre nombre del nuevo perfil.
     * @param email correo electrónico del nuevo perfil.
     */
    public abstract void registrar(String nombre, String email) throws NoRepeatException, NullPointerException, EmailException, NameException;
    public List<T> getLista() {
        return this.lista;
    }
    public List<PerfilBasico> getListaCompleta() {
        return listaUsuarios;
    }
}
