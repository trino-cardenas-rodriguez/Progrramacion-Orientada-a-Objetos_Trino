package edu.trino.cardenas.reto2.cajas.ui;

import java.util.Scanner;

import static edu.trino.cardenas.reto2.cajas.process.CalculadoraCajas.*;

public class CLI {

    public static void showMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Elija la opcion que desea ejecutar:");
        System.out.println("1. Comprar cajas de papel ");
        System.out.println("2. Vender cajas de papel");
        System.out.println("3. Mostrar reporte");
        System.out.println("4. Salir del programa");
        System.out.println("--------------------------------------");
    }

    public static void LaunchApp() {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {

            showMenu();
            opcion = scanner.nextInt();
            int cantidadCajasCompradas = 0, cantidadCajasVendidas = 0;
            double precioCajasCompradas = 0, precioCajasVendidas = 0;

            if (opcion==1) {
                System.out.println("Ingrese la cantidad de cajas de papel que desea comprar: ");
                cantidadCajasCompradas = scanner.nextInt();
                System.out.println("Ingrese el costo de las cajas por unidad: ");
                precioCajasCompradas = scanner.nextDouble();
                double montoCompra = calcularMontoCompra(cantidadCajasCompradas, precioCajasCompradas);
                System.out.printf("La compra realizada por %s cajas, al precio de $%f; es igual a $%f"
                        , cantidadCajasCompradas, precioCajasCompradas, montoCompra);
            } else if (opcion==2) {
                System.out.println("Ingrese la cantidad de cajas de papel que desea vender: ");
                cantidadCajasVendidas = scanner.nextInt();
                System.out.println("Ingrese el costo de las cajas por unidad: ");
                precioCajasVendidas = scanner.nextDouble();
                double montoVenta = calcularMontoVenta(cantidadCajasVendidas, precioCajasVendidas);
                System.out.printf("La venta realizada por %s cajas, al precio de $%f; es igual a $%f pesos"
                        , cantidadCajasVendidas, precioCajasVendidas, montoVenta);
            } else if (opcion==3) {
                System.out.println("Cantidad total de ventas: " +
                        calcularTotalCajasVendidas(cantidadCajasVendidas));
                System.out.println("Cantidad total de compras: " +
                        calcularTotalCajasCompradas(cantidadCajasCompradas));
                System.out.println("Ingresos generados por ventas: " +
                        calcularTotalIngresos(cantidadCajasVendidas,precioCajasVendidas));
                System.out.println("Egresos generados por compras: " +
                        calcularTotalEgresos(cantidadCajasCompradas,precioCajasCompradas));
                System.out.println("Monto en la caja: $" + calcularMontoCaja(cantidadCajasVendidas,
                        precioCajasVendidas, cantidadCajasCompradas, precioCajasCompradas));
            } else if (opcion==4) {
                System.out.println("total");
            }else throw new IllegalStateException("\nDato no valido: " + opcion + "\nReinicie");

        } while (opcion < 4);
    }
}
