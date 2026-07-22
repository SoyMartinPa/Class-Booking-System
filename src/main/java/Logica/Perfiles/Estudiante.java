package Logica.Perfiles;

import Logica.Gestores.Reservas.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends PerfilBasico{

    private List<Reserva> inscritas = new ArrayList<>();

    Estudiante(String nombre, String email){
        super(nombre,email);
    }
  //Solicitar reserva?
}
