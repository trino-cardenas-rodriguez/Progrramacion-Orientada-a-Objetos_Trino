package edu.trino.cardenas.evidencia1.data;

/*Esta clase  nos permite inicalizar las variables de: nombre quimico, nombre generico,
nombre registrado, precio al publico, precio de venta y forma farmaceutica; para
poder utilizarlas dentro del contructor Medicamento. Ademas en esta clase agregamos
un toString, que nos permite imprimir de forma ordenada nuestro constructor Medicamento.*/
public class Medicamento {
    public String nombreQuimico;
    public String nombreGenerico;
    public String nombreRegistrado;
    public double precioPublico;
    public double precioVenta;
    public String formaFarmaceutica;

    /*Aqui declaramos nuestro contructor Medicamento, el cual contiene las variables de :
    nombre quimico, nombre generico, nombre registrado, precio al publico,
    precio de venta y forma farmaceutica*/
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

    /*Aqui utilizamos un metodo toString para poder imprimir de
    forma ordenada nuestro constructor Medicamento.*/
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
