package edu.trino.cardenas.evidencia2.process;

public class Pelicula extends Producto {

    public Pelicula(String nombre, String genero, boolean esEstreno) {
        super(nombre, "Pelicula", 5.0, genero, esEstreno);
    }

    @Override
    public double calcularCosto() {
        if (esEstreno) {
            return 15.0;
        } else {
            return 7.0;
        }
    }
}
