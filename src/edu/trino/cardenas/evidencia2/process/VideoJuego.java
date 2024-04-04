package edu.trino.cardenas.evidencia2.process;

/*Esta es una subclase de la clase base Producto*/
public class VideoJuego extends Producto{

    /*Aqui se define nuestro producto Videojuego base.*/
    public VideoJuego(String nombre, String genero, boolean esEstreno) {
        super(nombre, "Videojuego", 5.0, genero, esEstreno);
    }

    /*Aqui se sobreescribe el metodo de calcularCosto, para que se
    adapte a los requerimientos de este producto.*/
    @Override
    public double calcularCosto() {
        if (esEstreno) {
            return costoBase + 10.0;
        } else {
            return costoBase;
        }
    }
}
