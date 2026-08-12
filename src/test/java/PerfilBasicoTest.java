import Excepciones.EmailException;
import Excepciones.NameException;
import Excepciones.NoRepeatException;
import Logica.Gestores.GestorTutor;
import Logica.Gestores.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PerfilBasicoTest {
    GestorTutor gestor;
    //En el momento que gestorTutor no sobreescribe ningun metodo de Perfil básico
    //Ocuparlo a él no sería diferente a probar los metodos de perfil básico y su gestor
    //Ahora, lo harémos de esta manera debido a que las clases antes mencionadas no se pueden instanciar

    @BeforeEach
    void setUp(){
        Sistema.getInstancia().resetInstancia();
        gestor = Sistema.getInstancia().getGestorTutores();
    }
    @Test
    void validarNombreVacio(){
        assertThrows(NameException.class , () -> gestor.registrar("","hola@gmail.com"));
    }

    @Test
    void validarNombreUnaParte() {
        assertThrows(NameException.class,
                () -> gestor.registrar("Juan", "hola@gmail.com"));
    }
    @Test
    void validarNombreDosPartes() {
        assertThrows(NameException.class,
                () -> gestor.registrar("Juan Perez", "hola@gmail.com"));
    }
    @Test
    void validarNombreTresPartes() {
        assertDoesNotThrow(() ->
                gestor.registrar("Juan Pedro Lopez", "hola@gmail.com"));
    }
    @Test
    void validarNombreConLetraSuelta() {
        assertThrows(NameException.class,
                () -> gestor.registrar("Juan P Lopez", "hola@gmail.com"));
    }

    @Test //Debere buscar alguna manera de iterar todos los caracteres especiales
    void validarNombreConCaracterEspecial() {
        assertThrows(NameException.class,
                () -> gestor.registrar("Juan Pedro@ Lopez", "hola@gmail.com"));
    }


    @Test
    void ValidarCaracteresNombreCorrectos(){
        assertDoesNotThrow(() -> gestor.registrar(
                "qwertyuiopasdfghjklñzxcvbnm QWERTYUIOPASDFGHJKLÑZCVBNM ÁÉÍÓÚáéíóú","hola@gmail.com"));
    }
    @Test
    void verificarNombreYaRegistrado() throws Exception {
        gestor.registrar("Juan Pedro Lopez", "uno@gmail.com");
        assertThrows(NoRepeatException.class,
                () -> gestor.registrar("Juan Pedro Lopez", "dos@gmail.com"));
    }
    @Test
    void verificarNombreYaRegistradoLowerCase() throws Exception {
        gestor.registrar("Juan pedro Lopez", "uno@gmail.com");
        assertThrows(NoRepeatException.class,
                () -> gestor.registrar("juan pedro lopez", "dos@gmail.com"));
    }
    @Test
    void validarEmailVacio(){
        assertThrows(EmailException.class , () -> gestor.registrar("Juan Pedro Lopez",""));
    }

    @Test
    void validarEmailSinArroba() {
        assertThrows(EmailException.class,
                () -> gestor.registrar("Juan Pedro Lopez", "juangmail.com"));
    }
    @Test
    void validarEmailDiferenteAGmail() {
        assertThrows(EmailException.class,
                () -> gestor.registrar("Juan Pedro Lopez", "juan@hotmail.com"));
    }
    @Test
    void validarEmailDobleArroba() {
        assertThrows(EmailException.class,
                () -> gestor.registrar("Juan Perez Lopez", "juan@@gmail.com"));
    }
    @Test
    void validarEmailSinUsuario() {
        assertThrows(EmailException.class,
                () -> gestor.registrar("Juan Perez Lopez", "@gmail.com"));
    }

    @Test
    void validarEmailValido() {
        assertDoesNotThrow(() ->
                gestor.registrar("Juan Perez Lopez", "juan@gmail.com"));
    }
    @Test
    void validarEmailDuplicadoEntrePerfiles() throws Exception {
        gestor.registrar("Place Holder Uno", "hola1@gmail.com");
        assertThrows(NoRepeatException.class, () ->
                Sistema.getInstancia().getGestorEstudiantes()
                        .registrar("Place Holder Dos", "hola1@gmail.com"));
    }
    @Test
    void VerificarYaRegistradoPorEmail(){
        assertDoesNotThrow(() -> gestor.registrar("Place holder uno","hola@gmail.com"));
        assertThrows(NoRepeatException.class, () -> gestor.registrar("Place holder dos","hola@gmail.com"));
    }


}
