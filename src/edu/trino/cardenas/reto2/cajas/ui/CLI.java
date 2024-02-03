package edu.trino.cardenas.reto2.cajas.ui;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

/*Aqui se importa la calculadora de cajas del package edu.trino.cardenas.reto2.cajas.process,
para realizar los calculos correspondientes a la opcion que elija el usuario;
esto con los datos que ingrese el ususario.*/
import static edu.trino.cardenas.reto2.cajas.process.CalculadoraCajas.*;

/*Esta clase sirve para mostar la interfaz y el menu al usuario, y en base en la opcion que elija en el menu,
ejecutar dicha opcion, y depues vover a mostrar el menu para que el usuario elija otra opcion;
hasta que el usuario indique que quiere terminal la aplicacion.*/
public class CLI {

    /*Aqui defino metodo parar poder guardar el nombre del usuario
    en un switch-case, y poder utilizarlo en un if-else.*/
    public static String usuario;

    /*Este metodo sirve para mostar la interfaz al usuario y que pueda elegir entre
    iniciar secio o salir de la aplicacion.*/
    public static void showInterfaz() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Bienvenido a esta aplicacion de compra y venta de cajas!!");
        System.out.println("Por favor, indique que opcion que desea ejecutar");
        System.out.println("1. Iniciar secion");
        System.out.println("2. Salir de la aplicacion");
        System.out.println("--------------------------------------------------------------");
    }

    /*Este metodo sirve para mostar el menu al usuario y que pueda elegir la opcion que
    corresponda a la accion que decea hacer. (Teniendo una opcion de salir de la aplicacion).
    Las opciones son las siguientes:
    1. Comparar cajas de papel
    2. Vender cajas de papel
    3. Mostar reporte
    4. Salir de la aplicacion*/
    public static void showMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Elija la opcion que desea ejecutar:");
        System.out.println("1. Comprar cajas de papel");
        System.out.println("2. Vender cajas de papel");
        System.out.println("3. Mostrar reporte");
        System.out.println("4. Salir de la aplicacion");
        System.out.println("--------------------------------------");
    }

    /*Este metodo sirve para inicar la aplicacion, mostrando la interfaz y el menu;
    leyendo la opcion que seleccione el usuario; y en base en la opcion que elija en el menu,
    poder pedirle los datos que sean necesarios para la accion correspondiente
    a la opcion que alla elegido; y depues vover a mostrar el menu para que el usuario elija otra opcion;
    hasta que el usuario indique que quiere terminal la aplicacion.
    Esto utilizando un switch-case para la interfaz y un if-else para el menu.*/
    public static void LaunchApp() {
        Scanner scanner = new Scanner(System.in);

        showInterfaz();
        int opcionInterfaz = scanner.nextInt();

        //Este switch lee la opcion que seleccione el usuario y lo redirecciona a la accion que desea hacer.
        switch (opcionInterfaz){
            /*Este case se activa cuando el usuario elige la opcion 1 (Iniciar secion),
            y le solicita al usuario que ingrese su nombre y contraseña.*/
            case 1:
                System.out.println("Ingrese su nombre de usuario");
                usuario = scanner.next();
                System.out.println("Ingrese su contraseña");
                scanner.next();
                System.out.println("Bienvenido "+usuario);
                break;
            /*Este case se activa cuando el usuario elige la opcion 2 (Salir de la aplicacion),
            y permite que el codigo termine, y que el usuario pueda salir de la aplicacion.*/
            case 2:
                System.out.println("Aplicacion terminada, vuelva pronto");
                System.exit(0);
                break;
            /*Este comando se activa cuando el usuario ingresa un dato no valido o
            una opcion que no se encuentra en el menu.*/
            default:
                throw new IllegalStateException("\nDato no valido: "+opcionInterfaz+"\nReinicie");
        }

        int opcionMenu, operacionesRealizadas = 0;
        double precioCajasCompradas, precioCajasVendidas;

        /*Aqui se inicia un bucle do-while, que muestra el menu y hace la operacion que el usuario
        indique; esto mientras la opcion elegida en el menu sea diferente de 4*/
        do {
            showMenu();
            //Aqui se lee la opcion que el usuario elija del menu.
            opcionMenu = scanner.nextInt();

            //Aqui le sumo 1 a las operaciones realizadas, cada vez que se repita el bucle.
            operacionesRealizadas++;

            /*Si la opcion del menu elejida es igual a 1 (Comprar cajas de papel), se pedira al usuario
            que ingrese cuantas cajas quiere comprar y a que precio; para depues imprimir
            las cajas que ha comprado, a que precio y cual fue el monto de esa compra.*/
            if (opcionMenu == 1) {
                System.out.println("Ingrese la cantidad de cajas de papel que desea comprar: ");
                double cantidadCajasCompradas = scanner.nextDouble();
                System.out.println("Ingrese el costo de las cajas por unidad: ");
                precioCajasCompradas = scanner.nextDouble();
                double montoCompra = calcularMontoCompra(cantidadCajasCompradas, precioCajasCompradas);
                System.out.printf("La compra realizada por %.2f cajas, al precio de $%.2f; es igual a $%.2f\n",
                        cantidadCajasCompradas, precioCajasCompradas, montoCompra);
            }
            /*Si la opcion del menu elejida es igual a 2 (Vender cajas de papel), se pedira al usuario
            que ingrese cuantas cajas quiere vender y a que precio; para depues imprimir
            las cajas que ha vendido, a que precio y cual fue el monto de esa venta.*/
            else if (opcionMenu == 2) {
                System.out.println("Ingrese la cantidad de cajas de papel que desea vender: ");
                double cantidadCajasVendidas = scanner.nextDouble();
                System.out.println("Ingrese el costo de las cajas por unidad: ");
                precioCajasVendidas = scanner.nextDouble();
                double montoVenta = calcularMontoVenta(cantidadCajasVendidas, precioCajasVendidas);
                System.out.printf("La venta realizada por %.2f cajas, al precio de $%.2f; es igual a $%.2f pesos\n",
                        cantidadCajasVendidas, precioCajasVendidas, montoVenta);
            }
            /*Si la opcion del menu es igual a 3 (Mostrar reporte), se mostrara un reporte de
            cuantas cajas ha comprado, cuantas cajas ha vendido, cuantos han sido sus ingresos
            generados por ventas, cuantos han sido sus egresos generados por compras y
            cual es el monto en la caja.*/
            else if (opcionMenu == 3) {
                System.out.println("Cantidad total de cajas compradas: " + totalCajasCompradas);
                System.out.println("Cantidad total de cajas vendidas: " + totalCajasVendidas);
                System.out.println("Ingresos generados por ventas: $" + totalIngresos);
                System.out.println("Egresos generados por compras: $" + totalEgresos);
                double montoEnCaja = calcularMontoEnCaja();
                System.out.println("Monto en la caja: $" + montoEnCaja);
            }
            /*Si la opcion del menu es igual a 4 (Salir de la aplicacion), se mostrara un reporte de
            cuantas operaciones se han realizad, cuantas cajas ha comprado, cuantas cajas ha vendido,
            cuantos han sido sus ingresos generados por ventas, cuantos han sido sus egresos generados
            por compras y cual es el monto en la caja.
            Ademas se mostrara un mensaje de despedida y se finalizara la aplicacion.*/
            else if (opcionMenu == 4) {
                System.out.println("Cantidad total de operaciones realizadas: " + operacionesRealizadas);
                System.out.println("Cantidad total de cajas compradas: " + totalCajasCompradas);
                System.out.println("Cantidad total de cajas vendidas: " + totalCajasVendidas);
                System.out.println("Ingresos generados por ventas: $" + totalIngresos);
                System.out.println("Egresos generados por compras: $" + totalEgresos);
                double montoEnCaja = calcularMontoEnCaja();
                System.out.println("Monto en la caja: $" + montoEnCaja);
                System.out.println("Muchas gracias "+usuario+" por utilizar esta app" +
                        "\nSuerte en su compra y venta de cajas!\nVuelva pronto :)");
            }
            //Si la opccion es cualquier otro numero, se dara un error y se le indicara al usuario que reinicie.
            else {
                throw new IllegalStateException("\nDato no válido: " + opcionMenu + "\nReinicie");
            }
        /*En este while se indica la funcion que se debe cumplir para seguir repitiendo el bucle,
        la cual es que si la opcion del menu elejida es diferente de 4, el ciclo se repetira:
        pero si la opcion del menu elejida es igual a 4, el ciclo se interrumpe.*/
        } while (opcionMenu != 4);
    }
}
