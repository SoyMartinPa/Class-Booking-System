import Excepciones.IncompatibilityException;
import Excepciones.MaxCapacityReachedException;
import Excepciones.NoRepeatException;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Materias;
import Logica.Gestores.GestorEstudiante;
import Logica.Gestores.GestorReserva;
import Logica.Gestores.GestorTutor;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Estudiante;
import Logica.Perfiles.Tutor.Tutor;
import Logica.Reservas.Horario;
import Logica.Reservas.Reserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class GestorReservaTest {

    GestorTutor gestorTutor;
    GestorEstudiante gestorEstudiante;
    GestorReserva gestorReserva;

    Horario horarioFuturo;
    Horario horarioPasado;
    Horario horarioFuturo2;

    @BeforeEach
    void setUp() {
        Sistema.resetInstancia();
        gestorTutor = Sistema.getInstancia().getGestorTutores();
        gestorEstudiante = Sistema.getInstancia().getGestorEstudiantes();
        gestorReserva = Sistema.getInstancia().getGestorReservas();
        horarioFuturo = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000, 12, 12));
        horarioPasado = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(2000, 1, 1));
        horarioFuturo2 = new Horario(BloquesHorarios.BLOQUE9_10, LocalDate.of(3000, 12, 12));
    }

    private Tutor crearTutorDisponible(String nombre, String email) throws Exception {
        gestorTutor.registrar(nombre, email);
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail(email);
        tutor.ofrecerMateria(Materias.FISICA, 1000, 5);
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloquehorario());
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horarioFuturo2.getFecha()),
                horarioFuturo2.getBloquehorario());
        return tutor;
    }

    private Estudiante crearEstudiante(String nombre, String email) throws Exception {
        gestorEstudiante.registrar(nombre, email);
        return Sistema.getInstancia().buscarEstudiantePorEmail(email);
    }

    @Test
    void registrarReservaExitosaDesdePendiente() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        assertNotNull(reserva);
        assertTrue(gestorReserva.getListaReservasPendientes().contains(reserva));
    }

    @Test
    void registrarReservTutorLaTieneEnReservasActivas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        assertTrue(tutor.getReservasActivas().contains(reserva));
    }

    @Test
    void registrarReservahorarioPasadoException() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        assertThrows(IncompatibilityException.class,
                () -> gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioPasado));
    }

    @Test
    void registrarReservaTutorSinDisponibilidadException() throws Exception {
        gestorTutor.registrar("Juan Perez Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        tutor.ofrecerMateria(Materias.FISICA, 1000, 5);
        // no agrega disponibilidad
        assertThrows(IncompatibilityException.class,
                () -> gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo));
    }

    @Test
    void registrarReservaTutorNoDictaMateriaException() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        assertThrows(IncompatibilityException.class,
                () -> gestorReserva.registrarReserva(tutor, Materias.MATEMATICAS, horarioFuturo));
    }

    @Test
    void registrarReservaSolapamientoHorarioException() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        assertThrows(IncompatibilityException.class,
                () -> gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo));
    }
    @Test
    void reservaPasaDePendientesACanceladas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.cancelarReserva(reserva);
        assertFalse(gestorReserva.getListaReservasPendientes().contains(reserva));
        assertTrue(gestorReserva.getListaReservasCanceladas().contains(reserva));
    }

    @Test
    void cancelarReservaTutorLaPierdeDeActivas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.cancelarReserva(reserva);
        assertFalse(tutor.getReservasActivas().contains(reserva));
    }

    @Test
    void cancelarReservaEstudianteLaPierdeDeActivas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.agregarEstudiantesReserva(reserva, estudiante);
        gestorReserva.cancelarReserva(reserva);
        assertFalse(estudiante.getReservasActivas().contains(reserva));
    }

    @Test
    void cancelarReservaYaCompletadaException() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.completarReserva(reserva);
        assertThrows(IncompatibilityException.class,
                () -> gestorReserva.cancelarReserva(reserva));
    }
    @Test
    void completarReservaPasaACompletadas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.completarReserva(reserva);
        assertFalse(gestorReserva.getListaReservasPendientes().contains(reserva));
        assertTrue(gestorReserva.getListaReservasCompletadas().contains(reserva));
    }

    @Test
    void completarReservaTutorLaPierdeDeActivas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.completarReserva(reserva);
        assertFalse(tutor.getReservasActivas().contains(reserva));
    }

    @Test
    void completarReservaYaCanceladaException() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.cancelarReserva(reserva);
        assertThrows(IncompatibilityException.class,
                () -> gestorReserva.completarReserva(reserva));
    }

    @Test
    void modificarReservaCambiarHorarioHorarioSeActualiza() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.modificarReserva(reserva, tutor, Materias.FISICA, horarioFuturo2);
        assertEquals(horarioFuturo2, reserva.getHorario());
    }

    @Test
    void modificarReservaCambiarTutorTutorAnteriorLaPierdeNuevoLaGana() throws Exception {
        Tutor tutor1 = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Tutor tutor2 = crearTutorDisponible("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor1, Materias.FISICA, horarioFuturo);
        gestorReserva.modificarReserva(reserva, tutor2, Materias.FISICA, horarioFuturo);
        assertFalse(tutor1.getReservasActivas().contains(reserva));
        assertTrue(tutor2.getReservasActivas().contains(reserva));
    }

    @Test
    void modificarReservaSoloMateriaHorarioIgual() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        tutor.ofrecerMateria(Materias.MATEMATICAS, 2000, 5);
        tutor.ofrecerMateria(Materias.FISICA, 2000, 5);
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        assertDoesNotThrow(() ->
                gestorReserva.modificarReserva(reserva, tutor, Materias.MATEMATICAS, horarioFuturo));
    }

    @Test
    void modificarReservaNuevoTutorConMenosCuposQueEstudiantesException() throws Exception {
        Tutor tutor1 = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        gestorTutor.registrar("Ana Garcia Lopez", "ana@gmail.com");
        Tutor tutor2 = Sistema.getInstancia().buscarTutorPorEmail("ana@gmail.com");
        tutor2.ofrecerMateria(Materias.FISICA, 1000, 1); // solo 1 cupo
        tutor2.agregarDisponibilidad(tutor2.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloquehorario());

        Reserva reserva = gestorReserva.registrarReserva(tutor1, Materias.FISICA, horarioFuturo);
        gestorReserva.agregarEstudiantesReserva(reserva,
                crearEstudiante("Carlos Ruiz Lopez", "carlos@gmail.com"));
        gestorReserva.agregarEstudiantesReserva(reserva,
                crearEstudiante("Pedro Diaz Lopez", "pedro@gmail.com"));

        assertThrows(MaxCapacityReachedException.class,
                () -> gestorReserva.modificarReserva(reserva, tutor2, Materias.FISICA, horarioFuturo));
    }

    @Test
    void agregarEstudianteApareceEnReservaYEnSusActivas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.agregarEstudiantesReserva(reserva, estudiante);
        assertTrue(reserva.getListaEstudiantes().contains(estudiante));
        assertTrue(estudiante.getReservasActivas().contains(reserva));
    }

    @Test
    void agregarEstudianteReservaLlena() throws Exception {
        gestorTutor.registrar("Juan Perez Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        tutor.ofrecerMateria(Materias.FISICA, 1000, 1); // solo 1 cupo
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloquehorario());
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.agregarEstudiantesReserva(reserva,
                crearEstudiante("Ana Garcia Lopez", "ana@gmail.com"));
        assertThrows(MaxCapacityReachedException.class, () ->
                gestorReserva.agregarEstudiantesReserva(reserva,
                        crearEstudiante("Pedro Diaz Lopez", "pedro@gmail.com")));
    }

    @Test
    void agregarEstudianteUltimoCup() throws Exception {
        gestorTutor.registrar("Juan Perez Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        tutor.ofrecerMateria(Materias.FISICA, 1000, 1);
        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horarioFuturo.getFecha()),
                horarioFuturo.getBloquehorario());
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        assertDoesNotThrow(() ->
                gestorReserva.agregarEstudiantesReserva(reserva,
                        crearEstudiante("Ana Garcia Lopez", "ana@gmail.com")));
    }

    @Test
    void agregarEstudianteDuplicadoException() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.agregarEstudiantesReserva(reserva, estudiante);
        assertThrows(NoRepeatException.class,
                () -> gestorReserva.agregarEstudiantesReserva(reserva, estudiante));
    }

    @Test
    void agregarEstudianteConflictoHorarioException() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Tutor tutor2 = crearTutorDisponible("Ana Garcia Lopez", "ana@gmail.com");
        Estudiante estudiante = crearEstudiante("Carlos Ruiz Lopez", "carlos@gmail.com");

        Reserva reserva1 = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        Reserva reserva2 = gestorReserva.registrarReserva(tutor2, Materias.FISICA, horarioFuturo);
        gestorReserva.agregarEstudiantesReserva(reserva1, estudiante);

        assertThrows(IncompatibilityException.class,
                () -> gestorReserva.agregarEstudiantesReserva(reserva2, estudiante));
    }

    @Test
    void quitarEstudianteDesapareceDeReservaYDeActivas() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        gestorReserva.agregarEstudiantesReserva(reserva, estudiante);
        gestorReserva.quitarEstudianteReserva(reserva, estudiante);
        assertFalse(reserva.getListaEstudiantes().contains(estudiante));
        assertFalse(estudiante.getReservasActivas().contains(reserva));
    }

    @Test
    void quitarEstudianteNoPerteneceException() throws Exception {
        Tutor tutor = crearTutorDisponible("Juan Perez Lopez", "juan@gmail.com");
        Estudiante estudiante = crearEstudiante("Ana Garcia Lopez", "ana@gmail.com");
        Reserva reserva = gestorReserva.registrarReserva(tutor, Materias.FISICA, horarioFuturo);
        assertThrows(Excepciones.RemoveException.class,
                () -> gestorReserva.quitarEstudianteReserva(reserva, estudiante));
    }
}

