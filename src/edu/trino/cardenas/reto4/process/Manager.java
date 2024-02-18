package edu.trino.cardenas.reto4.process;

/*Aqui se importa la clase Boleto del paquete edu.trino.cardenas.reto4.data,
la clase Pasajero del paquete edu.trino.cardenas.reto4.data
y la clase Ticket del paquete edu.trino.cardenas.reto4.data
para poder llamar a las variables declaradas en estas clases.*/
import edu.trino.cardenas.reto4.data.Boleto;
import edu.trino.cardenas.reto4.data.Pasajero;
import edu.trino.cardenas.reto4.data.Ticket;

//Aqui se importa ArrayList de java para poder utilizarlo.
import java.util.ArrayList;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

/*Esta clse sirve para realizar los metodos que permiten realizar la venta de boletos
y mostar los datos de la lista de ventas.*/
public class Manager {

    /*Este metodo sirve para poder realizar la venta de boletos, pidiendole al usuario
    el nombre del comprador, la cantidad de boletos, y dependiendo de la cantidad de boletos
    le pide que ingrese el nombre de cada uno de los pasajeros extras; utilizando un ArrayList
    para guardar los pasajeros*/
    public static void realizarVenta(Scanner scanner, ArrayList<Boleto> listaVentas) {
        System.out.println();
        System.out.print("Nombre completo del comprador: ");
        String nombreComprador = scanner.nextLine();
        System.out.print("Cantidad de boletos: ");
        int cantidadBoletos = scanner.nextInt();

        Boleto boleto = new Boleto(nombreComprador, cantidadBoletos);

        scanner.nextLine();

        for (int i = 1; i < cantidadBoletos; i++) {
            System.out.print("Nombre completo del pasajero adicional " + i + ": ");
            String nombrePasajero = scanner.nextLine();
            boleto.agregarPasajero(nombrePasajero);
        }
        System.out.println();

        listaVentas.add(boleto);
        Ticket.imprimirTicket(boleto);
    }

    /*Este metodo sirve para poder mostar los datos de la lista de ventas, mostrando los pasajeros
    enumerados, destacando al comprador de los boletos; ademas tambien muestra la cantidad total
    de pasajeros registrados y el importe total de los boletos vendidos.*/
    public static void mostrarDatos(ArrayList<Boleto> listaVentas) {
        System.out.println("---------------Datos de la lista de ventas---------------");
        int totalPasajeros = 0;
        double totalImporte = 0;
        int i = 1;

        for (Boleto boleto : listaVentas) {
            totalPasajeros += boleto.cantidadBoletos;
            totalImporte += boleto.calcularImporte();

            System.out.println("Pasajero "+ (i++) +" (Comprador): " + boleto.comprador);
            for (Pasajero pasajero : boleto.pasajerosAdicionales) {
                System.out.println("Pasajero "+ (i++) + ": " + pasajero.nombre);
            }
        }

        System.out.println("Cantidad total de pasajeros registrados: " + totalPasajeros);
        System.out.println("Importe total de la lista de boletos: $" + totalImporte);
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }
}
