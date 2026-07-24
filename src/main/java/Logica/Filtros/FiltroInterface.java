package Logica.Filtros;
import Logica.Perfiles.PerfilBasico;

import javax.swing.*;

public interface FiltroInterface<T> {
    boolean esFiltrado(T objeto);
}
