package Logica.Filtros;


import Logica.Enumeraciones.Materias;
import Logica.GestorReserva.Reserva;

import java.time.LocalDate;

public class FiltroFecha implements FiltroInterface<Reserva>{
    private final LocalDate fechaAFiltrar;

    public FiltroFecha(LocalDate fecha) {
        this.fechaAFiltrar = fecha;
    }

    @Override
    public boolean pasaElFiltro(Reserva reserva) {
        return (reserva.getHorario().getFecha().equals(fechaAFiltrar));
    }

}
