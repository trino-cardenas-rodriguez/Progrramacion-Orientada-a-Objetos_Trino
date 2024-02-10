package edu.trino.cardenas.reto3.diccionario.ui;

import edu.trino.cardenas.reto3.diccionario.process.Diccionario;

import java.util.Scanner;

public class CLI {
    public static void showMenu() {
        System.out.println("------------------Diccionario------------------");
        System.out.println("Elija la opcion que desea ejecutar:");
        System.out.println("a. Mostrar lista de palabras del diccionario");
        System.out.println("b. Buscar significado de una palabra");
        System.out.println("c. Detalle del diccionario");
        System.out.println("d. Salir del diccionario");
        System.out.println("-----------------------------------------------");
    }

    public static void LaunchDiccionario(Diccionario diccionario) {
        Scanner scanner=new Scanner(System.in);

        while (true){
            showMenu();

            String opcion = scanner.nextLine();

            switch (opcion){
                case "a":
                    diccionario.imprimirLista();
                    break;
                case "b":
                    diccionario.imprimirLista();
                    System.out.println("Ingrese la palabra que quiere buscar:");
                    String palabra = scanner.nextLine();
                    String significado = diccionario.buscarSignificados(palabra);
                    System.out.println(palabra+": "+significado);
                    break;
                case "c":
                    diccionario.mostrarDatosConCaracteres();
                    break;
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
