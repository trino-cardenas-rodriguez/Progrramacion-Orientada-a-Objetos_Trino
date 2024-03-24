package edu.trino.cardenas.evidencia2.process;

public class Cancion extends Producto{

    public Cancion(String nombre, String genero, boolean esEstreno) {
        super(nombre, "Cancion", 5.0, genero, esEstreno);
    }

    @Override
    public double calcularCosto() {
        double costoTotal = costoBase;
        if (esEstreno) {
            costoTotal += 1.50;
        } else {
            costoTotal += 0.50;
        }
        return costoTotal;
    }
}
