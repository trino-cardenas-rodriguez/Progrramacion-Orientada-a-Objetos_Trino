package edu.trino.cardenas.reto5.reto5_5.data;

public class Articulo {

    public String nombre;
    public double precio;
    public double iva;
    public double importeNeto;

    public int cantidad;

    public Articulo(String nombre, double precio, double iva, double importeNeto, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
        this.importeNeto = importeNeto;
        this.cantidad = cantidad;
    }
}
