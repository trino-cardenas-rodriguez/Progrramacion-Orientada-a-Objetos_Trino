package edu.trino.cardenas.reto9.ui;

/*Aqui importamos la clase ContadorPalabras, para usar el metodo que cuenta las palabras.*/
import edu.trino.cardenas.reto9.process.ContadorPalabras;

/*Aqui importamos la libreria until de java para poder usar las listas, y los mapas.*/
import java.util.*;

/*Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.*/
import java.util.Scanner;

/*Esta clase sirve para mostar el menu al usuario y, en base en la opcion que elija,
mostrar la lista de las 10 palabras mas usadas en el libro que eligio.*/
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

    /*Este metodo se encarga de obtener la instancia del idioma elegido.*/
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
                    throw new IllegalArgumentException("Idioma no disponible / Language not available");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Opción inválida / Invalid option");
        }
    }

    /*Este metodo sirve para obtener el nombre del archivo correspondiente al libro elegido.*/
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
                    throw new IllegalArgumentException("Opción inválida / Invalid option");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Opción inválida / Invalid option");
        }
    }

    /*Este metodo sirve para iniciar la aplicacion, mostrando los menus y la lista de 10
    palabras mas usadas segun el libro que el usuario eligio.*/
    public static void launchApp() {
        /*Aqui le pedimos al usuario que seleccione idioma y asignamos la instancia de ese idioma.*/
        showIdiomMenu();
        String idioma = obtenerIdiomaSeleccionado();
        Idiomas idiomas = Idiomas.getInstance(idioma);

        System.out.println();

        /*Aqui imprimimos el menu de libros, y leemos el libro que el usuario seleccione.*/
        System.out.println(idiomas.getMENU());
        String nombreArchivo = obtenerNombreArchivo();
        List<Map.Entry<String, Integer>> listaPalabras = ContadorPalabras.contarPalabras(nombreArchivo);

        System.out.println();

        /*Aqui se imprime la lista de 10 palabras mas usadas del libro que selecciono el usuario.*/
        System.out.println(idiomas.getPALABRAS_MAS_USADAS() + nombreArchivo + idiomas.getSON());
        for (int i = 0; i < 10 && i < listaPalabras.size(); i++) {
            System.out.println((i + 1) + ". " + listaPalabras.get(i).getKey() + ": "
                    + listaPalabras.get(i).getValue());
        }
    }
}
