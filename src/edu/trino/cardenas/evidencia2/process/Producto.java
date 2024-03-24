package edu.trino.cardenas.evidencia2.process;

public class Producto {

    protected String nombre;
    protected String tipo;
    protected double costoBase;
    protected String genero;
    protected boolean esEstreno;

    public Producto(String nombre, String tipo, double costoBase, String genero, boolean esEstreno) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.costoBase = costoBase;
        this.genero = genero;
        this.esEstreno = esEstreno;
    }

    // Método para calcular el costo del producto
    public double calcularCosto() {
        return costoBase;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ")";
    }
}
