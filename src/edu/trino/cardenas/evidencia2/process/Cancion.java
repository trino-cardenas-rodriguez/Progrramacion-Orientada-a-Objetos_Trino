package edu.trino.cardenas.evidencia2.process;

/*Esta es una subclase de la clase base Producto*/
public class Cancion extends Producto{

    /*Aqui se define nuestro producto Cancion base.*/
    public Cancion(String nombre, String genero, boolean esEstreno) {
        super(nombre, "Cancion", 5.0, genero, esEstreno);
    }

    /*Aqui se sobreescribe el metodo de calcularCosto, para que se
    adapte a los requerimientos de este producto.*/
    @Override
    public double calcularCosto() {
        double costoTotal = costoBase;
        if (esEstreno) {
            costoTotal += 1.50;
        } else {
            costoTotal += 0.50;
        }
        return costoTotal;
    }
}
