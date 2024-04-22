package edu.trino.cardenas.reto9.ui;

/*Aqui importamos la clase ContadorPalabras, para usar el metodo que cuenta las palabras.*/
import  edu.trino.cardenas.reto9.process.ContadorPalabras;

/*Aqui importamos la libreria until de java para poder usar las listas, los mapas y los scanner.*/
import java.util.*;

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
        System.out.println("ESP- Español");
        System.out.println("ENG- English");
        System.out.println("------------------------------------------");
    }

    private static void showBookMenu() {
        System.out.println(Idiomas.MENU);
        System.out.println(Idiomas.LIBROS_DISPONIBLES);
        System.out.println(Idiomas.El_Hobbit);
        System.out.println(Idiomas.El_principito);
        System.out.println(Idiomas.El_Padrino);
        System.out.println(Idiomas.Libro_1984);
        System.out.println(Idiomas.Rebelion_en_la_granja);
        System.out.println("--------------------------------");
    }

    /*Este metodo sirve para obtener el nombre del archivo correspondiente al libro elegido.*/
    private static String obtenerNombreArchivo() {
        int libro;
        try {
            libro = Integer.parseInt(scanner.nextLine());
            return switch (libro) {
                case 1 -> "el_hobbit.txt";
                case 2 -> "el_principito.txt";
                case 3 -> "el_padrino.txt";
                case 4 -> "1984.txt";
                case 5 -> "rebelion_en_la_granja.txt";
                default -> throw new IllegalArgumentException(Idiomas.OPCION_INVALIDA);
            };
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Idiomas.OPCION_INVALIDA);
        }
    }

    /*Este metodo sirve para iniciar la aplicacion, mostrando los menus y la lista de 10
    palabras mas usadas segun el libro que el usuario eligio.*/
    public static void launchApp() {
        /*Aqui le pedimos al usuario que seleccione idioma y asignamos la instancia de ese idioma,
        despues imprimimos el menu de libros, y leemos el libro que el usuario seleccione.*/
        showIdiomMenu();
        String idiomaSeleccionado = scanner.nextLine();
        Idiomas.getInstance(idiomaSeleccionado);
        showBookMenu();

        String nombreArchivo = obtenerNombreArchivo();
        List<Map.Entry<String, Integer>> listaPalabras = ContadorPalabras.contarPalabras(nombreArchivo);

        /*Aqui se imprime la lista de 10 palabras mas usadas del libro que selecciono el usuario.*/
        System.out.println(Idiomas.PALABRAS_MAS_USADAS + nombreArchivo + Idiomas.SON);
        for (int i = 0; i < 10 && i < listaPalabras.size(); i++) {
            System.out.println((i + 1) + ". " + listaPalabras.get(i).getKey() + ": "
                    + listaPalabras.get(i).getValue());
        }
    }
}
