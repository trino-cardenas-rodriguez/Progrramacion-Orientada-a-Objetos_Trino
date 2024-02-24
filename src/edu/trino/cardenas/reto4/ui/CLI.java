package edu.trino.cardenas.reto4.ui;

/*Aqui se importa la clase Boleto del paquete edu.trino.cardenas.reto4.data,
y la clase Manager del paquete edu.trino.cardenas.reto4.process
para poder llamar a los metodos declarados en estas clases.*/
import edu.trino.cardenas.reto4.data.Boleto;
import edu.trino.cardenas.reto4.process.Manager;

//Aqui se importa ArrayList de java para poder utilizarlo.
import java.util.ArrayList;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

/*Esta clase sirve para mostar el menu al usuario y, en base en la opcion que elija en el menu,
mostrar el resultado de la accion correspondiente a la opcion elegida;*/
public class CLI {

    /*Este metodo sirve para mostar el menu al usuario y que pueda elegir la opcion que
     corresponda a la accion que decea hacer. (Teniendo una opcion de salir de la aplicacion).
     Las opciones son las siguientes:
     A. Realizar venta de boleto
     B. Mostrar lista de datos de ventas
     C. Finalizar programa*/
    public static void showMenu() {
        System.out.println("---------Sistema de registro de ventas---------");
        System.out.println("Elija la opcion que desea ejecutar:");
        System.out.println("A. Realizar venta de boleto");
        System.out.println("B. Mostrar lista de datos de ventas");
        System.out.println("C. Finalizar programa");
        System.out.println("-----------------------------------------------");
    }

    /*Este metodo sirve para inicar la aplicacion, mostrando el menu;
    leyendo la opcion que seleccione el usuario; y en base en la opcion que elija,
    poder pedirle los datos que sean necesarios para la accion correspondiente;
    y despues vover a mostrar el menu para que el usuario elija otra opcion;
    hasta que el usuario indique que quiere terminar la aplicacion.
    Esto utilizando un switch-case.*/
    public static void LaunchApp() {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Boleto> listaVentas = new ArrayList<>();

        /*Aqui se inicia un bucle while, que muestra el menu y realiza la accion que el usuario
        indique; esto mientras el valor sea verdadero.*/
        while (true){
            showMenu();
            //Aqui se lee la opcion que el usuario elija del menu.
            String opcion = scanner.nextLine().toUpperCase();

            /*Este switch lee la opcion que seleccione el usuario y lo redirecciona a la case
            correspondiente, dependiendo de la accion que el usuario desea hacer.*/
            switch (opcion){
                /*Este case se activa cuando el usuario elige la opcion A (Realizar venta de boleto),
                y le solicita al usuario sus datos para la venta de boletos y despues se le muestra
                un ticket de su compra.*/
                case "A":
                    Manager.realizarVenta(scanner, listaVentas);
                    break;
                /*Este case se activa cuando el usuario elige la opcion B (Mostrar lista de datos de ventas),
                y le mostrara al usuario la lista de pasajeros registrados, el importe total de la lista de boletos
                y la cantidad total de pasajeros registrados..*/
                case "B":
                    Manager.mostrarDatos(listaVentas);
                    break;
                /*Este case se activa cuando el usuario elige la opcion C (Finalizar programa),
                y permite que el codigo termine, y que el usuario pueda salir de la aplicacion.*/
                case "C":
                    System.out.println("Programa finalizado, vuelva pronto.");
                    System.exit(0);
                    break;
                /*Este comando se activa cuando el usuario ingresa un dato no valido o
                una opcion que no se encuentra en el menu.*/
                default:
                    throw new IllegalStateException("\nDato no valido: "+opcion+"\nReinicie");
            }
        }
    }
}
