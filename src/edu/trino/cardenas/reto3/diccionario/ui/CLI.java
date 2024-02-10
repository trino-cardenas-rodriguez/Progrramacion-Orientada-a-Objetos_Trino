package edu.trino.cardenas.reto3.diccionario.ui;

/*Aqui se importa el Diccionario del paquete edu.trino.cardenas.reto3.diccionario.process,
* para poder llamar a los metodos declarados en este.*/
import edu.trino.cardenas.reto3.diccionario.process.Diccionario;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

/*Esta clase sirve para mostar el menu al usuario y, en base en la opcion que elija en el menu,
mostrar el resultado de la accion correspondiente a la opcion elegida;*/
public class CLI {

    /*Este metodo sirve para mostar el menu al usuario y que pueda elegir la opcion que
     corresponda a la accion que decea hacer. (Teniendo una opcion de salir de la aplicacion).
     Las opciones son las siguientes:
     a. Mostrar lista de palabras del diccionario
     b. Buscar significado de una palabra
     c. Detalle del diccionario
     d. Salir del diccionario*/
    public static void showMenu() {
        System.out.println("------------------Diccionario------------------");
        System.out.println("Elija la opcion que desea ejecutar:");
        System.out.println("a. Mostrar lista de palabras del diccionario");
        System.out.println("b. Buscar significado de una palabra");
        System.out.println("c. Detalle del diccionario");
        System.out.println("d. Salir del diccionario");
        System.out.println("-----------------------------------------------");
    }

    /*Este metodo sirve para inicar el diccioanrio, mostrando el menu y
    leyendo la opcion que seleccione el usuario; y, en base en esa seleccion,
    poder realizar la accion correspondiente a la opcion que alla elegido;
    esto utilizando un "switch case".*/
    public static void LaunchDiccionario(Diccionario diccionario) {
        Scanner scanner=new Scanner(System.in);

        /*Aqui se inicia un bucle while, que muestra el menu y realiza la accion que el usuario
        indique; esto mientras el valor sea verdadero.*/
        while (true){
            showMenu();
            //Aqui se lee la opcion que el usuario elija del menu.
            String opcion = scanner.nextLine();

            /*Este switch lee la opcion que seleccione el usuario y lo redirecciona a la case
            correspondiente, dependiendo de la accion que el usuario desea hacer.*/
            switch (opcion){
                /*Este case se activa cuando el usuario elige la opcion a (Mostrar lista de palabras
                del diccionario), y le muestra al usuario la lista de palabras del diccionario.*/
                case "a":
                    diccionario.imprimirLista();
                    break;
                /*Este case se activa cuando el usuario elige la opcion b (Buscar significado de una
                palabra), y le solicita al usuario que ingrese la palabra que quiere buscar; para
                despues mostrarle la palabra con su significado.*/
                case "b":
                    diccionario.imprimirLista();
                    System.out.println("Ingrese la palabra que quiere buscar:");
                    String palabra = scanner.nextLine();
                    String significado = diccionario.buscarSignificados(palabra);
                    System.out.println(palabra+": "+significado);
                    break;
                /*Este case se activa cuando el usuario elige la opcion c (Detalle del diccionario),
                y le muestra al usuario la lista de palabras del diccionario con el numero de caracterees
                que tiene cada una y el numero de caracteres que tiene su significado.*/
                case "c":
                    diccionario.mostrarDatosConCaracteres();
                    break;
                /*Este case se activa cuando el usuario elige la opcion d (Salir del diccionario),
                y permite que el codigo termine, y que el usuario pueda salir de la aplicacion.*/
                case "d":
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
