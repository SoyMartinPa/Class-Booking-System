package Logica;

import Logica.GestorReserva.GestorReserva;
import Logica.Perfiles.GestorEstudiante.GestorEstudiante;
import Logica.Perfiles.GestorTutor.GestorTutor;

public class Sistema {

    private static Sistema instancia;

    private final GestorTutor gestorTutores;
    private final GestorEstudiante gestorEstudiantes;
    private final GestorReserva gestorReservas;

    private Sistema() {
        gestorTutores = new GestorTutor();
        gestorEstudiantes = new GestorEstudiante();
        gestorReservas = new GestorReserva();
    }

    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

}
