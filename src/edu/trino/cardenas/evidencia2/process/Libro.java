package edu.trino.cardenas.evidencia2.process;

/*Esta es una subclase de la clase base Producto*/
public class Libro extends Producto{

    /*Aqui se define nuestro producto Libro base.*/
    public Libro(String nombre, String genero, boolean esEstreno) {
        super(nombre, "Libro", 5.0, genero, esEstreno);
    }

    /*Aqui se sobreescribe el metodo de calcularCosto, para que se
    adapte a los requerimientos de este producto.*/
    @Override
    public double calcularCosto() {
        double costoTotal = costoBase;
        if (esEstreno) {
            costoTotal += 0.50;
        }
        switch (genero) {
            case "Novela":
                costoTotal += 2.0;
                break;
            case "Tecnologia":
                costoTotal += 3.0;
                break;
            default:
                costoTotal += 1.0;
        }
        return costoTotal;
    }
}
