package Logica.Enumeraciones;
/**
 * Representa los materias que el sistema reconoce como validas
 */
public enum Materias {
    MATEMATICAS,
    LENGUAJE,
    HISTORIA,
    QUIMICA,
    INGLES,
    FISICA;

    @Override
    public String toString() {
        String texto = name().replace("_", " ").toLowerCase();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
