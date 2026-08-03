import Logica.Enumeraciones.BloquesHorarios;
import Logica.Gestores.Sistema;
import Logica.Reservas.Horario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HorarioTest {


    @BeforeEach
    void setUp() {
        Sistema.resetInstancia();
    }
    @Test
    void verificarHorarioVigenteConFechaPasada() {
        Horario pasado = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(2000, 1, 1));
        assertFalse(pasado.horarioVigente());
    }

    @Test
    void verificarHorarioVigenteConFechaFutura() {
        Horario futuro = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 12));
        assertTrue(futuro.horarioVigente());
    }

    @Test
    void verificarEqualHorario() {
        Horario h1 = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 12));
        Horario h2 = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 12));
        assertEquals(h1, h2);
    }


    @Test
    void verificarNotEqualHorario() {
        Horario h1 = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 12));
        Horario h2 = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 13));
        assertNotEquals(h1, h2);
    }
}
