package edu.trino.cardenas.reto6.data;

public class Categoria {

    private String nombreCategoria;
    private String claveCategoria;
    private double sueldoBaseCategoria;
    private double pagoHoraExtra;

    public Categoria(String nombreCategoria, String claveCategoria, double sueldoBaseCategoria, double pagoHoraExtra) {
        this.nombreCategoria = nombreCategoria;
        this.claveCategoria = claveCategoria;
        this.sueldoBaseCategoria = sueldoBaseCategoria;
        this.pagoHoraExtra = pagoHoraExtra;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getClaveCategoria() {
        return claveCategoria;
    }

    public double getSueldoBaseCategoria() {
        return sueldoBaseCategoria;
    }

    public double getPagoHoraExtra() {
        return pagoHoraExtra;
    }
}
