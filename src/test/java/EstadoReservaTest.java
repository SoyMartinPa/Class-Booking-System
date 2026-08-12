import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Materias;
import Logica.Gestores.GestorReserva;
import Logica.Gestores.GestorTutor;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Tutor.Tutor;
import Logica.Reservas.Horario;
import Logica.Reservas.Reserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
public class EstadoReservaTest {

    GestorTutor gestorTutor;
    GestorReserva gestorReserva;

    @BeforeEach
    void setUp() {
        Sistema.getInstancia().resetInstancia();
        gestorTutor = Sistema.getInstancia().getGestorTutores();
        gestorReserva = Sistema.getInstancia().getGestorReservas();
    }

    private Reserva crearReservaFutura() throws Exception {
        gestorTutor.registrar("Juan Pedro Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        tutor.ofrecerMateria(Materias.FISICA, 1000, 5);
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(LocalDate.of(3000, 12, 12)),
                BloquesHorarios.BLOQUE8_9);
        Horario horario = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 12));
        return gestorReserva.registrarReserva(tutor, Materias.FISICA, horario);
    }

    @Test
    void reservaCompletadaModificarException() throws Exception {
        Reserva reserva = crearReservaFutura();
        gestorReserva.completarReserva(reserva);
        assertThrows(IllegalStateException.class,
                () -> reserva.modificar(reserva.getTutorAsociado(),
                        Materias.FISICA,
                        new Horario(BloquesHorarios.BLOQUE9_10, LocalDate.of(3000, 12, 12))));
    }
    @Test
    void reservaCompletadaCancelarException() throws Exception {
        Reserva reserva = crearReservaFutura();
        gestorReserva.completarReserva(reserva);
        assertThrows(IllegalStateException.class, reserva::cancelar);
    }

    @Test
    void reservaCanceladaModificarException() throws Exception {
        Reserva reserva = crearReservaFutura();
        gestorReserva.cancelarReserva(reserva);
        assertThrows(IllegalStateException.class,
                () -> reserva.modificar(reserva.getTutorAsociado(),
                        Materias.FISICA,
                        new Horario(BloquesHorarios.BLOQUE9_10, LocalDate.of(3000, 12, 12))));
    }

    @Test
    void reservaCanceladaCompletarException() throws Exception {
        Reserva reserva = crearReservaFutura();
        gestorReserva.cancelarReserva(reserva);
        assertThrows(IllegalStateException.class, reserva::completar);
    }
}
