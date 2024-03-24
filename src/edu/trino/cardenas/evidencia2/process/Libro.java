package edu.trino.cardenas.evidencia2.process;

public class Libro extends Producto{

    public Libro(String nombre, String genero, boolean esEstreno) {
        super(nombre, "Libro", 5.0, genero, esEstreno);
    }

    @Override
    public double calcularCosto() {
        double costoTotal = costoBase;
        if (esEstreno) {
            costoTotal += 0.50;
        }
        switch (genero) {
            case "Novela":
                costoTotal += 2.0;
                break;
            case "Tecnologia":
                costoTotal += 3.0;
                break;
            default:
                costoTotal += 1.0;
        }
        return costoTotal;
    }
}
