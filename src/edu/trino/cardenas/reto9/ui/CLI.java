package edu.trino.cardenas.reto9.ui;

/**Aquí importamos la clase ContadorPalabras, para usar el método que cuenta las palabras.*/
import edu.trino.cardenas.reto9.process.FiltradorPalabras;

/**Aquí importamos la librería until de java para poder usar las listas, los mapas y los scanner.*/
import java.util.*;

/**Aquí importamos los collectors de stream de la librería java.until, para poder usarlos.*/
import java.util.stream.Collectors;

/**Esta clase sirve para mostrar el menu al usuario y, en base en la opción que elija,
mostrar la lista de las 10 palabras más usadas en el libro que eligio.*/
public class CLI {
    private static final Scanner scanner = new Scanner(System.in);

    /**Este método sirve para mostrar el menu de idioma al usuario y que pueda elegir el idioma que prefiera.
         Las opciones son las siguientes:
         ESP- Español
         ENG- English*/
    public static void showIdiomMenu() {
        System.out.println("------------------Idioma------------------");
        System.out.println("Escoja un idioma (Choose a language)");
        System.out.println("ESP- Español");
        System.out.println("ENG- English");
        System.out.println("------------------------------------------");
    }

    /**Este ste método sirve para mostrar el menu de libros al usuario y que pueda elegir el libro que quiera filtrar.
     Las opciones son las siguientes:
     1- el_hobbit
     2- el_principito
     3- el_padrino
     4- 1984
     5- rebelión_en_la_granja*/
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

    /**Este método sirve para obtener el nombre del archivo correspondiente al libro elegido.*/
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

    /**Este método sirve para iniciar la aplicación, mostrando los menus y la lista de 10
    palabras más usadas según el libro que el usuario eligio.*/
    public static void launchApp() {
        /**Aquí le pedimos al usuario que seleccione idioma y asignamos la instancia de ese idioma,
        después imprimimos el menu de libros, y leemos el libro que el usuario seleccione.*/
        showIdiomMenu();
        String idiomaSeleccionado = scanner.nextLine();
        Idiomas.getInstance(idiomaSeleccionado);
        showBookMenu();

        String nombreArchivo = obtenerNombreArchivo();

        FiltradorPalabras contador = new FiltradorPalabras();

        /**Aquí se imprime la lista de 10 palabras más usadas del libro que selecciono el usuario.*/
        List<Map.Entry<String, Integer>> listaPalabras = contador.contarPalabras(nombreArchivo);
        System.out.println(Idiomas.PALABRAS_MAS_USADAS + nombreArchivo + Idiomas.SON);
        for (int i = 0; i < 10 && i < listaPalabras.size(); i++) {
            System.out.println((i + 1) + ". " + listaPalabras.get(i).getKey() + ": "
                    + listaPalabras.get(i).getValue());
        }

        /**Aquí se cuentan todas las vocales del libro, y se muestra este número.*/
        long totalVocales = contador.contarVocales(nombreArchivo);
        System.out.println(Idiomas.VOCALES_TOTALES + nombreArchivo + Idiomas.SON + totalVocales);

        /**Aquí se muestran todas las palabras que inicien con una vocal.*/
        System.out.println(Idiomas.PALABRAS_INICIAN_VOCAL + nombreArchivo + Idiomas.SON);
        contador.imprimirPalabrasQueEmpiezanConVocal(nombreArchivo);

        /**Aquí se muestran todas las palabras que tengan un número impar de letras.*/
        System.out.println(Idiomas.PALABRAS_NUMERO_IMPAR_LETRAS + nombreArchivo + Idiomas.SON);
        contador.imprimirPalabrasConNumeroImparDeLetras(nombreArchivo);

        /**Aquí se muestra la palabra más larga del libro*/
        String palabraMasLarga = contador.encontrarPalabraMasLarga(nombreArchivo);
        System.out.println(Idiomas.PALABRA_MAS_LARGA + nombreArchivo + Idiomas.ES + palabraMasLarga);

        /**Aquí busca y se muestra la palabra más corta del libro*/
        System.out.println(Idiomas.PALABRA_MAS_CORTA + nombreArchivo + Idiomas.ES);
        String palabraMasCorta = FiltradorPalabras.encontrarPalabraMasCorta(contador.contarPalabras(nombreArchivo)
                .stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        System.out.println(palabraMasCorta != null ? palabraMasCorta : "N/A");

        /**Aquí se buscan y se muestran todas las palabras que inicien y terminen con vocal;
         * además de que tengan menos de 5 letras.*/
        System.out.println(Idiomas.PALABRA_ESPECIAL + nombreArchivo + Idiomas.SON);
        List<String> palabras = contador.contarPalabras(nombreArchivo).stream().map(Map.Entry::getKey)
                .collect(Collectors.toList());
        List<String> palabrasConVocalAlInicioYFinal = FiltradorPalabras.filtroPalabraEspecial(palabras);
        if (!palabrasConVocalAlInicioYFinal.isEmpty()) {
            palabrasConVocalAlInicioYFinal.forEach(System.out::println);
        } else {
            System.out.println(Idiomas.NO_HAY_PALABRAS + nombreArchivo + Idiomas.CUMPLAN_CONDICION);
        }
    }
}
