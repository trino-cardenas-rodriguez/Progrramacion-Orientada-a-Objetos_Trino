package edu.trino.cardenas.reto6.data;

//Esta clase sirve para declarar los atributos de la categoria, generar su constructor y sus getters.
public class Categoria {

    //Aqui se declaran los atributos.
    private String nombreCategoria;
    private String claveCategoria;
    private double sueldoBase;
    private double pagoHoraExtra;

    //Aqui se crea el constructor.
    public Categoria(String nombreCategoria, String claveCategoria, double sueldoBase, double pagoHoraExtra) {
        this.nombreCategoria = nombreCategoria;
        this.claveCategoria = claveCategoria;
        this.sueldoBase = sueldoBase;
        this.pagoHoraExtra = pagoHoraExtra;
    }

    //Aqui se crean los getters, aunque algunos no se utilizan.
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getClaveCategoria() {
        return claveCategoria;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public double getPagoHoraExtra() {
        return pagoHoraExtra;
    }
}

