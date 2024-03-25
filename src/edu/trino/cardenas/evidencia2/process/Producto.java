package edu.trino.cardenas.evidencia2.process;

/*Esta es nuestra clase base en la que definimos los atributos de nuestros productos,
ademas de los metodos para calcular el costo y visualizar del producto.*/
public class Producto {

    /*Aqui definimos los atributos de los productos.*/
    protected String nombre;
    protected String tipo;
    protected double costoBase;
    protected String genero;
    protected boolean esEstreno;

    /*Aqui se genera el constructor.*/
    public Producto(String nombre, String tipo, double costoBase, String genero, boolean esEstreno) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.costoBase = costoBase;
        this.genero = genero;
        this.esEstreno = esEstreno;
    }

    /*Este metodo permite calcular el precio del producto.*/
    public double calcularCosto() {
        return costoBase;
    }

    /*Aqui definimos como es que se visualizara ul producto.*/
    @Override
    public String toString() {
        return nombre + " (" + tipo + ")";
    }
}
