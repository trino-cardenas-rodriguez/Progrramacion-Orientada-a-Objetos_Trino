package edu.trino.cardenas.reto4.data;

//Esta clase permite imprimir el ticket.
public class Ticket {

    /*Este metodo permite imprimir el ticket que contiene el nombre del comprador,
    la cantidad de voletos comprados y el importe de la venta,
    esto llamando variables de la clase Boleto.*/
    public static void imprimirTicket(Boleto boleto) {
        System.out.println("------------Ticket de venta------------");
        System.out.println("Comprador: " + boleto.comprador);
        System.out.println("Cantidad de boletos: " + boleto.cantidadBoletos);
        System.out.println("Importe total: $" + boleto.calcularImporte());
        System.out.println("---------------------------------------");
        System.out.println();
    }
}
