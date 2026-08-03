import Excepciones.NotFoundException;
import Excepciones.RemoveException;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Materias;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;
import Logica.Reservas.Horario;
import Logica.Reservas.Reserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaTest {

    Sistema sistema;
    Horario horarioFuturo;
    Horario horarioFuturo2;

    @BeforeEach
    void setUp() {
        Sistema.resetInstancia();
        sistema = Sistema.getInstancia();
        horarioFuturo = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 12));
        horarioFuturo2 = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 15));
    }

    private Tutor crearTutorDisponible(String nombre, String email) throws Exception {
        sistema.getGestorTutores().registrar(nombre, email);
        Tutor tutor = sistema.buscarTutorPorEmail(email);
        tutor.ofrecerMateria(Materias.FISICA, 1000, 5);
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloqueHorario());
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horarioFuturo2.getFecha()),
                horarioFuturo2.getBloqueHorario());
        return tutor;
    }

    private Estudiante crearEstudiante(String nombre, String email) throws Exception {
        sistema.getGestorEstudiantes().registrar(nombre, email);
        return sistema.buscarEstudiantePorEmail(email);
    }


    @Test
    void eliminarTutorSinReservasSeEliminaDeLista() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        sistema.eliminarTutor(tutor);
        assertFalse(sistema.getGestorTutores().getLista().contains(tutor));
    }

    @Test
    void eliminarTutorConReservasPendientesPasanACanceladas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        sistema.eliminarTutor(tutor);
        assertTrue(sistema.getGestorReservas().getListaReservasCanceladas().contains(reserva));
        assertFalse(sistema.getGestorReservas().getListaReservasPendientes().contains(reserva));
    }

    @Test
    void eliminarTutorConReservasEstudiantePierdeReservaDeActivas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        sistema.getGestorReservas().agregarEstudiantesReserva(reserva, estudiante);
        sistema.eliminarTutor(tutor);
        assertFalse(estudiante.getReservasActivas().contains(reserva));
    }

    @Test
    void eliminarTutorNoRegistradoException() throws Exception {
        crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Tutor tutorFantasma = new Tutor("Ana Garcia Lopez", "ana@gmail.com");
        assertThrows(RemoveException.class, () -> sistema.eliminarTutor(tutorFantasma));
    }

    @Test
    void eliminarEstudianteSinReservasSeEliminaDeLista() throws Exception {
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        sistema.eliminarEstudiante(estudiante);
        assertFalse(sistema.getGestorEstudiantes().getLista().contains(estudiante));
    }

    @Test
    void eliminarEstudianteConReservasSeDesvinculaDeLasReservas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        sistema.getGestorReservas().agregarEstudiantesReserva(reserva, estudiante);
        sistema.eliminarEstudiante(estudiante);
        assertFalse(reserva.getListaEstudiantes().contains(estudiante));
        assertFalse(sistema.getGestorEstudiantes().getLista().contains(estudiante));
    }

    @Test
    void eliminarEstudianteNoRegistradoException() {
        Estudiante estudianteFantasma = new Estudiante("Ana Garcia Lopez", "ana@gmail.com");
        assertThrows(RemoveException.class, () -> sistema.eliminarEstudiante(estudianteFantasma));
    }

    @Test
    void verCalendarioTutorContieneReserva() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        List<Reserva> calendario = sistema.verCalendarioTutor(tutor);
        assertTrue(calendario.contains(reserva));
    }

    @Test
    void verCalendarioTutorSoloVeReservasDelTutorNoMezclaConOtros() throws Exception {
        Tutor tutor1 = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        sistema.getGestorTutores().registrar("Ana Garcia Lopez", "ana@gmail.com");
        Tutor tutor2 = sistema.buscarTutorPorEmail("ana@gmail.com");
        tutor2.ofrecerMateria(Materias.FISICA, 1000, 5);
        tutor2.agregarDisponibilidad(tutor2.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloqueHorario());

        Reserva reservaTutor1 = sistema.getGestorReservas().registrarReserva(tutor1, Materias.FISICA, horarioFuturo);
        Reserva reservaTutor2 = sistema.getGestorReservas().registrarReserva(tutor2, Materias.FISICA, horarioFuturo);

        List<Reserva> calendario = sistema.verCalendarioTutor(tutor1);
        assertTrue(calendario.contains(reservaTutor1));
        assertFalse(calendario.contains(reservaTutor2));
    }

    @Test
    void verCalendarioEstudianteConReserva() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        sistema.getGestorReservas().agregarEstudiantesReserva(reserva, estudiante);
        List<Reserva> calendario = sistema.verCalendarioEstudiante(estudiante);
        assertTrue(calendario.contains(reserva));
    }

    @Test
    void buscarReservaPorIdReservaPendienteLaEncuentra() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        assertEquals(reserva, sistema.buscarReservaPorId(reserva.getId()));
    }

    @Test
    void buscarReservaPorIdReservaCompletadaLaEncuentra() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        sistema.getGestorReservas().completarReserva(reserva);
        assertEquals(reserva, sistema.buscarReservaPorId(reserva.getId()));
    }
    @Test
    void buscarReservaPorIdReservaCanceladaLaEncuentra() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        sistema.getGestorReservas().cancelarReserva(reserva);
        assertEquals(reserva, sistema.buscarReservaPorId(reserva.getId()));
    }

    @Test
    void buscarReservaPorId_idInexistente() {
        assertThrows(NotFoundException.class, () -> sistema.buscarReservaPorId("id-que-no-existe"));
    }
}

