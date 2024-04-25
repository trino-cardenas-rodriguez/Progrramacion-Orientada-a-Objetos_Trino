package edu.trino.cardenas.reto9.ui;

/**Esta clase sirve para traducir los textos dependiendo del idioma que elija el usuario.*/
public class Idiomas {

    /**Aquí declaramos nuestras variables para definirlas con el idioma que seleccione el usuario.*/
    public static String MENU;
    public static String LIBROS_DISPONIBLES;
    public static String El_Hobbit;
    public static String El_principito;
    public static String El_Padrino;
    public static String Libro_1984;
    public static String Rebelion_en_la_granja;
    public static String OPCION_INVALIDA;
    public static String ARCHIVO_NO_ENCONTRADO;
    public static String ERROR_INESPERADO;
    public static String PALABRAS_MAS_USADAS;
    public static String VOCALES_TOTALES;
    public static String PALABRAS_INICIAN_VOCAL;
    public static String PALABRAS_NUMERO_IMPAR_LETRAS;
    public static String PALABRA_MAS_LARGA;
    public static String PALABRA_MAS_CORTA;
    public static String PALABRA_ESPECIAL;
    public static String NO_HAY_PALABRAS;
    public static String CUMPLAN_CONDICION;
    public static String SON;
    public static String ES;

    /**Aquí se define las variables, dependiendo el idioma que selecciono el usuario.*/
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
                ARCHIVO_NO_ENCONTRADO = "Archivo no encontrado.";
                ERROR_INESPERADO = "Error inesperado ";
                PALABRAS_MAS_USADAS = "Las 10 palabras más repetidas en el libro: ";
                VOCALES_TOTALES = "\nEl numero total de vocales en el libro: ";
                PALABRAS_INICIAN_VOCAL = "\nLas palabras que inician con vocal en el libro: ";
                PALABRAS_NUMERO_IMPAR_LETRAS = "\nLas palabras con un numero impar de letras en el libro: ";
                PALABRA_MAS_LARGA = "\nLa palabra mas larga del libro: ";
                PALABRA_MAS_CORTA = "\nLa palabra mas corta del libro: ";
                PALABRA_ESPECIAL = "\nLas palabras que empiecen y terminen con vocal; " +
                        "y ademas tengan al menos 5 letras, en el libro: ";
                NO_HAY_PALABRAS = "\nNo se han encontrado palabras dentro del libro: ";
                CUMPLAN_CONDICION = "que cumplan con esta condicion";
                SON = " son: ";
                ES = " es: ";
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
                ARCHIVO_NO_ENCONTRADO = "File not found.";
                ERROR_INESPERADO = "Unexpected error ";
                PALABRAS_MAS_USADAS = "Top 10 most repeated words in the book: ";
                VOCALES_TOTALES = "\nThe total number of vowels in the book: ";
                PALABRAS_INICIAN_VOCAL = "\nThe words that start with a vowel in the book: ";
                PALABRAS_NUMERO_IMPAR_LETRAS = "\nThe words with an odd number of letters in the book: ";
                PALABRA_MAS_LARGA = "\nThe longest word in the book: ";
                PALABRA_MAS_CORTA = "\nThe shortest word in the book: ";
                PALABRA_ESPECIAL = "\nThe words that begin and end with a vowel; " +
                        "and also have at least 5 letters in the book: ";
                NO_HAY_PALABRAS = "\nNo words found within the book: ";
                CUMPLAN_CONDICION = "that meet this condition";
                SON = " are: ";
                ES = " is: ";
                break;
            default:
                throw new IllegalArgumentException("Idioma no disponible");
        }
    }
}
    /**Aqui definimos las posibles instancias de idioma.*/
enum Textos {
    ESP, ENG
}

