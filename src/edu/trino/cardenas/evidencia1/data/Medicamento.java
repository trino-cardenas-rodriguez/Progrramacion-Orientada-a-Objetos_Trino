package edu.trino.cardenas.evidencia1.data;

public class Medicamento {
    public String nombreQuimico;
    public String nombreGenerico;
    public String nombreRegistrado;
    public double precioPublico;
    public double precioVenta;
    public String formaFarmaceutica;

    public Medicamento(String nombreQuimico, String nombreGenerico,
                       String nombreRegistrado, double precioPublico,
                       double precioVenta, String formaFarmaceutica) {
        this.nombreQuimico = nombreQuimico;
        this.nombreGenerico = nombreGenerico;
        this.nombreRegistrado = nombreRegistrado;
        this.precioPublico = precioPublico;
        this.precioVenta = precioVenta;
        this.formaFarmaceutica = formaFarmaceutica;
    }
    @Override
    public String toString() {
        return ("Nombre quimico: " + nombreQuimico +
                "\nNombre generico: " + nombreGenerico +
                "\nNombre registrado: " + nombreRegistrado +
                "\nPrecio al publico " + precioPublico +
                "\nPrecio de venta: " + precioVenta +
                "\nForma farmaceutica: " + formaFarmaceutica);
    }
}
