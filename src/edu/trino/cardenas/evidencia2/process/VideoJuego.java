package edu.trino.cardenas.evidencia2.process;

public class VideoJuego extends Producto{

    public VideoJuego(String nombre, String genero, boolean esEstreno) {
        super(nombre, "Videojuego", 5.0, genero, esEstreno);
    }

    @Override
    public double calcularCosto() {
        if (esEstreno) {
            return costoBase + 10.0;
        } else {
            return costoBase;
        }
    }
}
