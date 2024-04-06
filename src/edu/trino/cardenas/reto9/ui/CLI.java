package edu.trino.cardenas.reto9.ui;

import edu.trino.cardenas.reto9.process.ContadorPalabras;

import java.util.List;
import java.util.Map;

/*Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.*/
import java.util.Scanner;

/*Esta clase sirve para mostar el menu al usuario y, en base en la opcion que elija,
mostrar el resultado de la operacion correspondiente a la opcion elegida.*/
public class CLI {
    private static final Scanner scanner = new Scanner(System.in);

    /*Este metodo sirve para mostar el menu de idioma al usuario y que pueda elegir el idioma que prefiera.
         Las opciones son las siguientes:
         1- Español
         2- English*/
    public static void showIdiomMenu() {
        System.out.println("------------------Idioma------------------");
        System.out.println("Escoja un idioma (Choose a language)");
        System.out.println("1- Español");
        System.out.println("2- English");
        System.out.println("------------------------------------------");
    }

    private static String obtenerIdiomaSeleccionado() {
        int idioma;
        try {
            idioma = Integer.parseInt(scanner.nextLine());
            switch (idioma) {
                case 1:
                    return "ES";
                case 2:
                    return "ENG";
                default:
                    throw new IllegalArgumentException("Idioma no válido / Invalid language");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Opción inválida / Invalid option");
        }
    }

    /*Este metodo sirve para mostar el menu al usuario y que pueda elegir el libro que decea leer.
     Las opciones son las siguientes:
     1. El hobbit
     2. El Principito
     3. El padrino
     4. 1984
     5. Rebelion en la granja*/
    public static void showBookMenu() {
        System.out.println("Seleccione un libro para analizar:");
        System.out.println("1. El hobbit");
        System.out.println("2. El Principito");
        System.out.println("3. El padrino");
        System.out.println("4. 1984");
        System.out.println("5. Rebelion en la granja");
    }

    private static String obtenerNombreArchivo() {
        int libro;
        try {
            libro = Integer.parseInt(scanner.nextLine());
            switch (libro) {
                case 1:
                    return "el_hobbit.txt";
                case 2:
                    return "el_principito.txt";
                case 3:
                    return "el_padrino.txt";
                case 4:
                    return "1984.txt";
                case 5:
                    return "rebelion_en_la_granja.txt";
                default:
                    throw new IllegalArgumentException("Opción no válida / Invalid option");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Opción inválida / Invalid option");
        }
    }

    public static void launchApp() {
        showIdiomMenu();
        String idioma = obtenerIdiomaSeleccionado();

        Idiomas idiomas = Idiomas.getInstance(idioma);
        System.out.println(idiomas.getMenu());

        showBookMenu();
        String nombreArchivo = obtenerNombreArchivo();
        List<Map.Entry<String, Integer>> listaPalabras = ContadorPalabras.contarPalabras(nombreArchivo);

        System.out.println("Las 10 palabras más repetidas en el libro son:");
        for (int i = 0; i < 10 && i < listaPalabras.size(); i++) {
            System.out.println((i + 1) + ". " + listaPalabras.get(i).getKey() + ": " + listaPalabras.get(i).getValue());
        }
    }
}
