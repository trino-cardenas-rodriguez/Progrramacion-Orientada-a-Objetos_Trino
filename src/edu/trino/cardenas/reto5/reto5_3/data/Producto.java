package edu.trino.cardenas.reto5.reto5_3.data;

public class Producto {

    public String nombre;
    public double precio;
    public int cantidad;
    public double importeTotal;

    public Producto(String nombre, double precio, int cantidad, double importeTotal) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
    }
}
