package edu.trino.cardenas.evidencia2.process;

/*Esta es una subclase de la clase base Producto*/
public class Pelicula extends Producto {

    /*Aqui se define nuestro producto Pelicula base.*/
    public Pelicula(String nombre, String genero, boolean esEstreno) {
        super(nombre, "Pelicula", 5.0, genero, esEstreno);
    }

    /*Aqui se sobreescribe el metodo de calcularCosto, para que se
    adapte a los requerimientos de este producto.*/
    @Override
    public double calcularCosto() {
        if (esEstreno) {
            return 15.0;
        } else {
            return 7.0;
        }
    }
}
