package Logica.Perfiles.GestorTutor;

public class OfertaMateria{
    private int tarifa;
    private int cuposMax;

    public OfertaMateria(int tarifa, int cuposMax) {
        this.tarifa = tarifa;
        this.cuposMax = cuposMax;
    }

    public int getTarifa() { return tarifa; }
    public void setTarifa(int tarifa) { this.tarifa = tarifa; }

    public int getCuposMax() { return cuposMax; }
    public void setCuposMax(int cuposMax) { this.cuposMax = cuposMax; }

}

