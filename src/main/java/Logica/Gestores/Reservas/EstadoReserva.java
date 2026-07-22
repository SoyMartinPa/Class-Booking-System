package Logica.Gestores.Reservas;

public interface EstadoReserva {
    void modificar();
    void completar();
    void cancelar();
    void getEstado();
}
