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
        horarioFuturo = new Horario(BloquesHorarios.BLOQUE1, LocalDate.of(3000, 12, 12));
        horarioFuturo2 = new Horario(BloquesHorarios.BLOQUE1, LocalDate.of(3000, 12, 15));
    }

    private Tutor crearTutorDisponible(String nombre, String email) throws Exception {
        sistema.getGestorTutores().registrar(nombre, email);
        Tutor tutor = sistema.buscarTutorPorEmail(email);
        tutor.ofrecerMateria(Materias.FISICA, 1000, 5);
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloquehorario());
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horarioFuturo2.getFecha()),
                horarioFuturo2.getBloquehorario());
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
    void eliminarTutorConReservasReservasPasanACanceladas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        sistema.eliminarTutor(tutor);
        assertTrue(sistema.getGestorReservas().getListaReservasCanceladas().contains(reserva));
        assertFalse(sistema.getGestorReservas().getListaReservasPendientes().contains(reserva));
    }

    @Test
    void eliminarTutorConReservasRstudiantePierdeReservaDeActivas() throws Exception {
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
    void buscarTutoresCompatiblesTutorCompatibleAparecEnResultado() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        List<Tutor> resultado = sistema.buscarTutoresCompatibles(
                Materias.FISICA, horarioFuturo.getFecha(), horarioFuturo.getBloquehorario());
        assertTrue(resultado.contains(tutor));
    }

    @Test
    void buscarTutoresCompatiblesTutorSinMateriaNoAparece() throws Exception {
        crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        List<Tutor> resultado = sistema.buscarTutoresCompatibles(
                Materias.MATEMATICAS, horarioFuturo.getFecha(), horarioFuturo.getBloquehorario());
        assertTrue(resultado.isEmpty());
    }

    @Test
    void buscarTutoresCompatiblesConTarifaMaxs() throws Exception {
        Tutor tutorBarato = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        sistema.getGestorTutores().registrar("Ana Garcia Lopez", "ana@gmail.com");
        Tutor tutorCaro = sistema.buscarTutorPorEmail("ana@gmail.com");
        tutorCaro.ofrecerMateria(Materias.FISICA, 99999, 5);
        tutorCaro.agregarDisponibilidad(tutorCaro.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloquehorario());

        List<Tutor> resultado = sistema.buscarTutoresCompatibles(
                Materias.FISICA, horarioFuturo.getFecha(), horarioFuturo.getBloquehorario(), 5000);

        assertTrue(resultado.contains(tutorBarato));
        assertFalse(resultado.contains(tutorCaro));
    }

    @Test
    void buscarTutoresCompatiblesOrdenadosPorTarifa() throws Exception {
        crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        sistema.getGestorTutores().registrar("Ana Garcia Lopez", "ana@gmail.com");
        Tutor tutorBarato = sistema.buscarTutorPorEmail("ana@gmail.com");
        tutorBarato.ofrecerMateria(Materias.FISICA, 500, 5); // más barato
        tutorBarato.agregarDisponibilidad(tutorBarato.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloquehorario());

        List<Tutor> resultado = sistema.buscarTutoresCompatibles(
                Materias.FISICA, horarioFuturo.getFecha(), horarioFuturo.getBloquehorario());

        assertEquals(tutorBarato, resultado.get(0)); // el más barato primero
    }

    @Test
    void buscarTutoresCompatiblestutorConReservaEnEseHorarioNoAparece() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        List<Tutor> resultado = sistema.buscarTutoresCompatibles(
                Materias.FISICA, horarioFuturo.getFecha(), horarioFuturo.getBloquehorario());
        assertFalse(resultado.contains(tutor));
    }

    @Test
    void verCalendarioTutorConPendientesIncluyePendientes() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        List<Reserva> calendario = sistema.verCalendarioTutor(tutor);
        assertTrue(calendario.contains(reserva));
    }

    @Test
    void verCalendarioTutorSinPendientesExcluyePendientesIncluyeHistorial() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva pendiente = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        Reserva completada = sistema.getGestorReservas().registrarReserva(tutor, Materias.FISICA, horarioFuturo2);
        sistema.getGestorReservas().completarReserva(completada);

        List<Reserva> calendario = sistema.verCalendarioTutor(tutor);
        assertFalse(calendario.contains(pendiente));
        assertTrue(calendario.contains(completada));
    }

    @Test
    void verCalendarioTutorSoloVeReservasDelTutorNoMezclaConOtros() throws Exception {
        Tutor tutor1 = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        sistema.getGestorTutores().registrar("Ana Garcia Lopez", "ana@gmail.com");
        Tutor tutor2 = sistema.buscarTutorPorEmail("ana@gmail.com");
        tutor2.ofrecerMateria(Materias.FISICA, 1000, 5);
        tutor2.agregarDisponibilidad(tutor2.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloquehorario());

        Reserva reservaTutor1 = sistema.getGestorReservas().registrarReserva(tutor1, Materias.FISICA, horarioFuturo);
        Reserva reservaTutor2 = sistema.getGestorReservas().registrarReserva(tutor2, Materias.FISICA, horarioFuturo);

        List<Reserva> calendario = sistema.verCalendarioTutor(tutor1);
        assertTrue(calendario.contains(reservaTutor1));
        assertFalse(calendario.contains(reservaTutor2));
    }

    @Test
    void verCalendarioEstudianteConPendientesIncluyePendientes() throws Exception {
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
    void buscarReservaPorId_idInexistente_retornaNull() {
        assertNull(sistema.buscarReservaPorId("id-que-no-existe"));
    }
}

