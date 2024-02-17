package edu.trino.cardenas.reto4.data;

import java.util.ArrayList;

public class Boleto {
    public String comprador;
    public int cantidadBoletos;
    public ArrayList<Pasajero> pasajerosAdicionales;

    public Boleto(String comprador, int cantidadBoletos) {
        this.comprador = comprador;
        this.cantidadBoletos = cantidadBoletos;
        this.pasajerosAdicionales = new ArrayList<>();
    }

    public void agregarPasajero(String nombrePasajero) {
        pasajerosAdicionales.add(new Pasajero(nombrePasajero));
    }

    public double calcularImporte() {
        return cantidadBoletos * 1250.50;
    }
}
