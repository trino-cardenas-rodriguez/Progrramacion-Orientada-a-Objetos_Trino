package edu.trino.cardenas.reto4.data;

public class Ticket {

    public static void imprimirTicket(Boleto boleto) {
        System.out.println("------------Ticket de venta------------");
        System.out.println("Comprador: " + boleto.comprador);
        System.out.println("Cantidad de boletos: " + boleto.cantidadBoletos);
        System.out.println("Importe total: $" + boleto.calcularImporte());
        System.out.println("---------------------------------------");
        System.out.println();
    }
}
