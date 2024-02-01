package edu.trino.cardenas.reto2.cajas.ui;

import java.util.Scanner;

import static edu.trino.cardenas.reto2.cajas.process.CalculadoraCajas.*;

public class CLI {

        public static void showMenu () {
        System.out.println("--------------------------------------");
        System.out.println("Elija la opcion que desea ejecutar:");
        System.out.println("1. Comprar cajas de papel ");
        System.out.println("2. Vender cajas de papel");
        System.out.println("3. Mostrar reporte");
        System.out.println("4. Salir del programa");
        System.out.println("--------------------------------------");
        }

        public static void LaunchApp () {
        Scanner scanner = new Scanner(System.in);

        showMenu();
        int opcion = scanner.nextInt();
        int cantidadCajasCompradas = 0, cantidadCajasVendidas = 0;
        double precioCajasCompradas = 0, precioCajasVendidas = 0;

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la cantidad de cajas de papel que desea comprar: ");
                cantidadCajasCompradas = scanner.nextInt();
                System.out.println("Ingrese el costo de las cajas por unidad: ");
                precioCajasCompradas = scanner.nextDouble();
                double montoCompra = calcularMontoCompra(cantidadCajasCompradas, precioCajasCompradas);
                System.out.printf("La compra realizada por %s cajas, al precio de $%f; es igual a $%f"
                        , cantidadCajasCompradas, precioCajasCompradas, montoCompra);
                break;
            case 2:
                System.out.println("Ingrese la cantidad de cajas de papel que desea vender: ");
                cantidadCajasVendidas = scanner.nextInt();
                System.out.println("Ingrese el costo de las cajas por unidad: ");
                precioCajasVendidas = scanner.nextDouble();
                double montoVenta = calcularMontoVenta(cantidadCajasVendidas, precioCajasVendidas);
                System.out.printf("La compra realizada por %s cajas, al precio de $%f; es igual a $%f pesos"
                        , cantidadCajasVendidas, precioCajasVendidas, montoVenta);
                break;
            case 3:
                int totalVentas = calcularTotalCajasVendidas(cantidadCajasVendidas);
                System.out.println("Cantidad total de ventas: " + totalVentas);
                int totalCompras = calcularTotalCajasCompradas(cantidadCajasCompradas);
                System.out.println("Cantidad total de compras: " + totalCompras);
                double totalIngresos = calcularTotalIngresos(precioCajasVendidas);
                System.out.println("Ingresos generados por ventas: " + totalIngresos);
                double totalEgresos = calcularTotalEgresos(precioCajasCompradas);
                System.out.println("Egresos generados por compras: " + totalEgresos);
                double montoEnCaja = calcularMontoCaja(precioCajasCompradas, precioCajasVendidas);
                System.out.println("Monto en la caja: $" + montoEnCaja);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("\nDato no valido: " + opcion + "\nReinicie");
        }

        System.out.println("\nAplicación terminada");

    }
}