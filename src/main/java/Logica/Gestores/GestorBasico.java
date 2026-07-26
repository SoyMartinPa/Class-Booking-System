package Logica.Gestores;
import Excepciones.IncompatibilityException;
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
     * <p>El nombre debe contener nombre y apellido separados por un espacio,
     * además de no estar registrado previamente dentro del gestor.</p>
     *
     * @param nombre nombre que será validado.
     * @throws NullPointerException si el nombre es nulo.
     * @throws IncompatibilityException si el formato del nombre es inválido
     *         o ya existe un perfil con ese nombre.
     */
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
    /**
     * Verifica que un correo electrónico sea válido y no esté registrado.
     *
     * <p>La validación se realiza contra la lista global de usuarios,
     * debido a que un correo no puede pertenecer a más de un perfil.</p>
     *
     * @param email correo electrónico que será validado.
     * @throws NullPointerException si el correo es nulo.
     * @throws IncompatibilityException si el formato del correo es inválido
     *         o ya existe un usuario con ese correo.
     */
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
    /**
     * Actualiza el correo electrónico de un usuario verificando previamente
     * que el nuevo correo sea válido y no esté ocupado.
     *
     * @param usuario perfil cuyo correo será modificado.
     * @param email nuevo correo electrónico.
     * @throws IncompatibilityException si el correo no cumple las reglas
     *         de validación.
     */
    public void cambiarEmail(T usuario, String email) throws IncompatibilityException{
        verificarEmail(email);
        usuario.setEmail(email);
    }

    /**
     * Registra un nuevo perfil dentro del gestor.
     *
     * <p>Cada implementación concreta debe definir la forma específica
     * de creación y almacenamiento del perfil.</p>
     *
     * @param nombre nombre del nuevo perfil.
     * @param email correo electrónico del nuevo perfil.
     * @throws IncompatibilityException si los datos no cumplen las reglas
     *         del sistema.
     */
    public abstract void registrar(String nombre, String email) throws IncompatibilityException;
    public List<T> getLista() {
        return lista;
    }
}
