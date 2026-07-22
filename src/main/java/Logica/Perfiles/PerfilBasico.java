package Logica.Perfiles;

import java.util.UUID;

public abstract class PerfilBasico {
    String id;
    String nombre;
    String email;

    PerfilBasico(String nombre, String email){
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
