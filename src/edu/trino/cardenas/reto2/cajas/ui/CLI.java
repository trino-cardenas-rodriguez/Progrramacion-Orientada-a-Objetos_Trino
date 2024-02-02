package edu.trino.cardenas.reto2.cajas.ui;

import java.util.Scanner;

import static edu.trino.cardenas.reto2.cajas.process.CalculadoraCajas.*;

public class CLI {

    private static String usuario;

    private static void showInterfaz() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Bienvenido a esta aplicacion de compra y venta de cajas!!");
        System.out.println("Por favor, indique que opcion que desea ejecutar");
        System.out.println("1. Iniciar secion");
        System.out.println("2. Salir de la aplicacion");
        System.out.println("--------------------------------------------------------------");
    }

    private static void showMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Elija la opcion que desea ejecutar:");
        System.out.println("1. Comprar cajas de papel ");
        System.out.println("2. Vender cajas de papel");
        System.out.println("3. Mostrar reporte");
        System.out.println("4. Salir de la aplicacion");
        System.out.println("--------------------------------------");
    }

    public static void LaunchApp() {
        Scanner scanner = new Scanner(System.in);

        int opcionInterfaz;

        showInterfaz();
        opcionInterfaz = scanner.nextInt();

        switch (opcionInterfaz){
            case 1:
                System.out.println("Ingrese su nombre de usuario");
                usuario = scanner.next();
                System.out.println("Ingrese su contraseña");
                scanner.next();
                System.out.println("Bienvenido "+usuario);
                break;
            case 2:
                System.out.println("Aplicacion terminada, vuelva pronto");
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("\nDato no valido: "+opcionInterfaz+"\nReinicie");
        }

        int opcionMenu, operacionesRealizadas = -1;
        double cantidadCajasCompradasContenedor = 0, cantidadCajasVendidasContenedor = 0,
                precioCajasCompradas, precioCajasVendidas;
        do {
            showMenu();
            opcionMenu = scanner.nextInt();
            operacionesRealizadas++;

            if (opcionMenu == 1) {
                System.out.println("Ingrese la cantidad de cajas de papel que desea comprar: ");
                double cantidadCajasCompradas = scanner.nextDouble();
                cantidadCajasCompradasContenedor += cantidadCajasCompradas;
                System.out.println("Ingrese el costo de las cajas por unidad: ");
                precioCajasCompradas = scanner.nextDouble();
                double montoCompra = calcularMontoCompra(cantidadCajasCompradas,
                        precioCajasCompradas, cantidadCajasCompradasContenedor);
                System.out.printf("La compra realizada por %.2f cajas, al precio de $%.2f; es igual a $%.2f\n",
                        cantidadCajasCompradas, precioCajasCompradas, montoCompra);
            } else if (opcionMenu == 2) {
                System.out.println("Ingrese la cantidad de cajas de papel que desea vender: ");
                double cantidadCajasVendidas = scanner.nextDouble();
                cantidadCajasVendidasContenedor += cantidadCajasVendidas;
                System.out.println("Ingrese el costo de las cajas por unidad: ");
                precioCajasVendidas = scanner.nextDouble();
                double montoVenta = calcularMontoVenta(cantidadCajasVendidas,
                        precioCajasVendidas,cantidadCajasVendidasContenedor);
                System.out.printf("La venta realizada por %.2f cajas, al precio de $%.2f; es igual a $%.2f pesos\n",
                        cantidadCajasVendidas, precioCajasVendidas, montoVenta);
            } else if (opcionMenu == 3) {
                double totalCajasCompradas = calcularTotalCajasCompradas();
                System.out.println("Cantidad total de cajas compradas: " + totalCajasCompradas);
                double totalCajasVendidas = calcularTotalCajasVendidas();
                System.out.println("Cantidad total de cajas vendidas: " + totalCajasVendidas);
                double montoVenta = calcularTotalIngresos();
                System.out.println("Ingresos generados por ventas: $" + montoVenta);
                double montoCompra = calcularTotalEgresos();
                System.out.println("Egresos generados por compras: $" + montoCompra);
                double montoEnCaja = calcularMontoCaja();
                System.out.println("Monto en la caja: $" + montoEnCaja);
            } else if (opcionMenu == 4) {
                System.out.println("Cantidad total de operaciones realizadas: " + operacionesRealizadas);
                double totalCajasCompradas = calcularTotalCajasCompradas();
                System.out.println("Cantidad total de cajas compradas: " + totalCajasCompradas);
                double totalCajasVendidas = calcularTotalCajasVendidas();
                System.out.println("Cantidad total de cajas vendidas: " + totalCajasVendidas);
                double montoVenta = calcularTotalIngresos();
                System.out.println("Ingresos generados por ventas: $" + montoVenta);
                double montoCompra = calcularTotalEgresos();
                System.out.println("Egresos generados por compras: $" + montoCompra);
                double montoEnCaja = calcularMontoCaja();
                System.out.println("Monto en la caja: $" + montoEnCaja);
            } else {
                throw new IllegalStateException("\nDato no válido: " + opcionMenu + "\nReinicie");
            }

        } while (opcionMenu != 4);

        System.out.println("Muchas gracias "+usuario+" por utilizar esta app" +
                "\nSuerte en su compra y venta de cajas!\nVuelva pronto :)");
    }
}
