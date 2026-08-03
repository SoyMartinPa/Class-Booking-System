import Excepciones.IncompatibilityException;
import Excepciones.NoValidNumberException;
import Logica.Enumeraciones.BloquesHorarios;
import Logica.Enumeraciones.Dias;
import Logica.Enumeraciones.Materias;
import Logica.Gestores.GestorReserva;
import Logica.Gestores.GestorTutor;
import Logica.Gestores.Sistema;
import Logica.Perfiles.Tutor.Tutor;
import Logica.Reservas.Horario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TutorTest {
    GestorTutor gestorTutor;
    GestorReserva gestorReserva;
    Horario horarioPorDefecto;

    private void RegistrarTutorEnReserva(String nombre, String email, Materias materia, Horario horario,int tarifa, int cuposMax)
            throws Exception
    {

        gestorTutor.registrar(nombre, email);
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail(email);
        //Sería útil si al registrar tutor lo retornara en vez de buscarlo -.-

        tutor.ofrecerMateria(materia, tarifa, cuposMax); //Puede tirar error

        tutor.agregarDisponibilidad(tutor.diasDesdeFecha(horario.getFecha()), horario.getBloquehorario());
        gestorReserva.registrarReserva(tutor, materia, horario);
    }

    @BeforeEach
    void setUp(){
        Sistema.resetInstancia();
        this.gestorReserva = Sistema.getInstancia().getGestorReservas();
        this.gestorTutor = Sistema.getInstancia().getGestorTutores();
        this.horarioPorDefecto = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000,12,12));
        gestorTutor.getLista().clear();
        gestorReserva.getListaReservasPendientes().clear();
        gestorReserva.getListaReservasCanceladas().clear();
        gestorReserva.getListaReservasCompletadas().clear();
        gestorTutor.getListaCompleta().clear();

    }
    @Test
    void verificarTarifaNegativa(){
        assertThrows(NoValidNumberException.class, () ->
                RegistrarTutorEnReserva("Prueba numero uno", "uno@gmail.com", Materias.FISICA, horarioPorDefecto, -1, 10));
    }
    @Test
    void verificarTarifaZero(){
        assertThrows(NoValidNumberException.class, () ->
                RegistrarTutorEnReserva("Prueba numero uno", "uno@gmail.com", Materias.FISICA, horarioPorDefecto, 0, 10));
    }
    @Test
    void verificarCuposNegativos(){
        assertThrows(NoValidNumberException.class, () ->
                RegistrarTutorEnReserva("Prueba numero uno", "uno@gmail.com", Materias.FISICA, horarioPorDefecto, 1000, -1));
    }
    @Test
    void verificarCuposZero(){
        assertThrows(NoValidNumberException.class, () ->
                RegistrarTutorEnReserva("Prueba numero uno", "uno@gmail.com", Materias.FISICA, horarioPorDefecto, 1000, 0));
    }
    @Test
    void verificarSesolapaConSiMismo(){

        assertDoesNotThrow(() ->
                RegistrarTutorEnReserva("Prueba numero uno", "uno@gmail.com", Materias.FISICA, horarioPorDefecto, 1000, 10));
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("uno@gmail.com");

        Horario horario = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000,12,12));

        assertTrue(tutor.reservaSeSolapa(horario));

    }
    @Test
    void verificarSeSolapaMismoDiaDiferenteBloque(){
        assertDoesNotThrow(() ->
                RegistrarTutorEnReserva("Prueba numero uno", "uno@gmail.com", Materias.FISICA, horarioPorDefecto, 1000, 10));
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("uno@gmail.com");

        Horario horarioMismoDiaDiferenteBloque
                = new Horario(BloquesHorarios.BLOQUE9_10, LocalDate.of(3000,12,12));

        assertFalse(tutor.reservaSeSolapa(horarioMismoDiaDiferenteBloque));
    }
    @Test
    void verificarSeSolapaMismoBloqueDiferenteDia(){

        assertDoesNotThrow(() ->
                RegistrarTutorEnReserva("Prueba numero uno", "uno@gmail.com", Materias.FISICA, horarioPorDefecto, 1000, 10));
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("uno@gmail.com");

        Horario horarioMismoBloqueDiferenteDia
                = new Horario(BloquesHorarios.BLOQUE8_9, LocalDate.of(3000,12,13));
        assertFalse(tutor.reservaSeSolapa(horarioMismoBloqueDiferenteDia));
    }
    @Test
    void verificarSeSolapaHorarioDiferente(){
        assertDoesNotThrow(() ->
                RegistrarTutorEnReserva("Prueba numero uno", "uno@gmail.com", Materias.FISICA, horarioPorDefecto, 1000, 10));
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("uno@gmail.com");
        Horario horarioDiferente
                = new Horario(BloquesHorarios.BLOQUE9_10, LocalDate.of(3000,12,13));
        assertFalse(tutor.reservaSeSolapa(horarioDiferente));
    }

    @Test
    void validarOfrecerMateria() throws Exception {
        gestorTutor.registrar("Juan Pedro Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        tutor.ofrecerMateria(Materias.FISICA, 10000, 5);
        assertTrue(tutor.dictaMateria(Materias.FISICA));
    }
    @Test
    void validarDejarOfrecerMateria() throws Exception {
        gestorTutor.registrar("Juan Pedro Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        assertFalse(tutor.dictaMateria(Materias.FISICA));
    }

    @Test
    void validarEstaDisponibleDeFechaADia() throws Exception {
        gestorTutor.registrar("Juan Pedro Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        // 3000-12-12 es día viernes
        tutor.agregarDisponibilidad(Dias.VIERNES, BloquesHorarios.BLOQUE8_9);
        assertTrue(tutor.estaDisponible(LocalDate.of(3000, 12, 12), BloquesHorarios.BLOQUE8_9));
    }

    @Test
    void validarEstaDisponibleMismoBloqueDiaDiferente() throws Exception {
        gestorTutor.registrar("Juan Pedro Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        tutor.agregarDisponibilidad(Dias.VIERNES, BloquesHorarios.BLOQUE8_9);
        // 3000-12-13 es sábado
        assertFalse(tutor.estaDisponible(LocalDate.of(3000, 12, 13), BloquesHorarios.BLOQUE8_9));
    }

    @Test
    void validarEstaDisponibleMismoDiaBloqueDistinto() throws Exception {
        gestorTutor.registrar("Juan Pedro Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        tutor.agregarDisponibilidad(Dias.VIERNES, BloquesHorarios.BLOQUE8_9);
        assertFalse(tutor.estaDisponible(LocalDate.of(3000, 12, 12), BloquesHorarios.BLOQUE9_10));
    }

    @Test
    void validarFinDeSemanaNoDisponible() throws Exception {
        gestorTutor.registrar("Juan Perez Lopez", "juan@gmail.com");
        Tutor tutor = Sistema.getInstancia().buscarTutorPorEmail("juan@gmail.com");
        // 3000-12-13 es sábado, 3000-12-14 es domingo
        assertFalse(tutor.estaDisponible(LocalDate.of(3000, 12, 13), BloquesHorarios.BLOQUE8_9));
        assertFalse(tutor.estaDisponible(LocalDate.of(3000, 12, 14), BloquesHorarios.BLOQUE8_9));
    }
}
