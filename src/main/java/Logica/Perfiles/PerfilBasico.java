package Logica.Perfiles;
import Logica.Reservas.Horario;
import Logica.Reservas.Reserva;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Clase abstracta que representa las características comunes de los perfiles
 * dentro del sistema.
 *
 * <p>Un perfil básico posee información identificatoria como nombre, correo
 * electrónico e identificador único, además de mantener un registro de sus
 * reservas activas.</p>
 */

public abstract class PerfilBasico {

    protected String id;
    protected String nombre;
    protected String email;
    protected List<Reserva> reservasActivas;

    /**
     * Crea un nuevo perfil básico asignándole un identificador único generado
     * mediante UUID e inicializando su lista de reservas activas.
     *
     * @param nombre nombre asociado al perfil.
     * @param email correo electrónico asociado al perfil.
     */

    public PerfilBasico(String nombre, String email){
        UUID uuid = UUID.randomUUID(); //Tal vés podría hacer que cada perfil tenga un identificador unico
        this.id = uuid.toString().replace("-", "").substring(0,12);
        this.nombre = nombre;
        this.email = email;
        this.reservasActivas = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getEmail() {
        return this.email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reserva> getReservasActivas(){
        return this.reservasActivas;
    }

    /**
     * Verifica si el perfil posee una reserva activa que utiliza el mismo horario
     * recibido como parámetro.
     *
     * <p>Este método permite evitar que un perfil tenga reservas simultáneas
     * en un mismo bloque horario.</p>
     *
     * @param horario horario que será comparado con las reservas activas.
     * @return {@code true} si existe una reserva activa con el mismo horario,
     *         {@code false} en caso contrario.
     */
    public boolean reservaSeSolapa(Horario horario){
        if (this.reservasActivas == null) { return false;}

        for (Reserva cadaReserva : this.reservasActivas){
            if (cadaReserva.getHorario().equals(horario) ){ return true;}
        }

        return false;
    }

}
