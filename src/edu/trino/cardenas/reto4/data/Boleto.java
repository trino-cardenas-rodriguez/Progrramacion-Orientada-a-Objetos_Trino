package edu.trino.cardenas.reto4.data;

//Aqui se importa ArrayList de java para poder utilizarlo.
import java.util.ArrayList;

/*Esta clase sirve para declarar el costo por boleto, el comprador, la cantidad de boletos,
y el ArrayList que guarda los pasajeros adicionales; ademas de realizar los metodos que
permiten agregar pasejeros y calcular el importe de venta.*/
public class Boleto {

    //Aqui se declaran las variables.
    public double costoBoleto = 1250.50;
    public String comprador;
    public int cantidadBoletos;
    public ArrayList<Pasajero> pasajerosAdicionales;

    //Este es un constructor que crea el objeto Boleto, donde se redeclaran sus variables.
    public Boleto(String comprador, int cantidadBoletos) {
        this.comprador = comprador;
        this.cantidadBoletos = cantidadBoletos;
        this.pasajerosAdicionales = new ArrayList<>();
    }

    //Este metodo permite agregar pasajeros al ArrayList.
    public void agregarPasajero(String nombrePasajero) {
        pasajerosAdicionales.add(new Pasajero(nombrePasajero));
    }

    //Este metodo permite calcular el importe de venta.
    public double calcularImporte() {
        return cantidadBoletos * costoBoleto;
    }
}
