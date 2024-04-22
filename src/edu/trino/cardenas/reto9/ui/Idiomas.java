package edu.trino.cardenas.reto9.ui;

/*Esta clase sirve para traducir los textos dependiendo del idioma que elija el usuario.*/
public class Idiomas {

    /*Aqui declaramos nuestras variables para definirlas con el idioma que seleccione el usuario.*/
    public static String MENU;
    public static String LIBROS_DISPONIBLES;
    public static String El_Hobbit;
    public static String El_principito;
    public static String El_Padrino;
    public static String Libro_1984;
    public static String Rebelion_en_la_granja;
    public static String OPCION_INVALIDA;
    public static String ERROR_INESPERADO;
    public static String PALABRAS_MAS_USADAS;
    public static String SON;


    /*Aqui se define la instancia, dependiendo el idioma que selecciono el usuario.*/
    public static void getInstance(String idioma) {
        Textos opcion = Textos.valueOf(idioma);
        switch (opcion) {
            case Textos.ESP:
                MENU = "--------------Menu--------------";
                LIBROS_DISPONIBLES = "Libros disponibles:";
                El_Hobbit = "1. El Hobbit.";
                El_principito = "2. El principito.";
                El_Padrino = "3. El Padrino.";
                Libro_1984 = "4. 1984.";
                Rebelion_en_la_granja = "5. Rebelión en la granja.";
                OPCION_INVALIDA = "Opción inválida";
                ERROR_INESPERADO = "Error inesperado ";
                PALABRAS_MAS_USADAS = "Las 10 palabras más repetidas en el libro ";
                SON = " son: ";
                break;
            case Textos.ENG:
                MENU = "--------------Menu--------------";
                LIBROS_DISPONIBLES = "Books available:";
                El_Hobbit = "1. El Hobbit.";
                El_principito = "2. El principito.";
                El_Padrino = "3. El Padrino.";
                Libro_1984 = "4. 1984.";
                Rebelion_en_la_granja = "5. Rebelión en la granja.";
                OPCION_INVALIDA = "Invalid option";
                ERROR_INESPERADO = "Unexpected error ";
                PALABRAS_MAS_USADAS = "Top 10 most repeated words in the book ";
                SON = " are: ";
                break;
            default:
                throw new IllegalArgumentException("Idioma no disponible");
        }
    }
}
    /*Aqui definimos las posibles instancias de idioma.*/
enum Textos {
    ESP, ENG
}

