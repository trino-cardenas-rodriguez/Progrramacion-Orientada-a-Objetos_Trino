package edu.trino.cardenas.reto9.ui;

/*Esta clase sirve para traducir los textos dependiendo del idioma que elija el usuario.*/
public class Idiomas {

    /*Aqui declaramos nuestras variables para definirlas con el idioma que seleccione el usuario.*/
    private String MENU;
    private String OPCION_NO_VALIDA;
    private String PALABRAS_MAS_USADAS;
    private String SON;
    private String ERROR_INESPERADO;
    private String ARCHIVO_NO_ENCONTRADO;

    /*Aqui definimos los getters de las variables para poder llamarlas.*/
    public String getMENU() {
        return MENU;
    }

    public String getOPCION_NO_VALIDA() {
        return OPCION_NO_VALIDA;
    }

    public String getPALABRAS_MAS_USADAS() {
        return PALABRAS_MAS_USADAS;
    }

    public String getSON() {
        return SON;
    }

    public String getERROR_INESPERADO() {
        return ERROR_INESPERADO;
    }

    public String getARCHIVO_NO_ENCONTRADO() {
        return ARCHIVO_NO_ENCONTRADO;
    }

    /*Aqui definimos nuestro constructor*/
    public Idiomas(String MENU, String OPCION_NO_VALIDA, String PALABRAS_MAS_USADAS,
                   String SON, String ERROR_INESPERADO, String ARCHIVO_NO_ENCONTRADO) {
        this.MENU = MENU;
        this.OPCION_NO_VALIDA = OPCION_NO_VALIDA;
        this.PALABRAS_MAS_USADAS = PALABRAS_MAS_USADAS;
        this.SON = SON;
        this.ERROR_INESPERADO = ERROR_INESPERADO;
        this.ARCHIVO_NO_ENCONTRADO = ARCHIVO_NO_ENCONTRADO;
    }

    /*Aqui se define la instancia, dependiendo el idioma que selecciono el usuario.*/
    public static Idiomas getInstance(String idioma){
        switch (Idioma.valueOf(idioma)){
            case ES:
                return new Idiomas("""
                        --------------Menu--------------
                        Libros disponibles:
                        1. El Hobbit.
                        2. El principito.
                        3. El Padrino.
                        4. 1984.
                        5. Rebelión en la granja.
                        --------------------------------""",
                        "Opcion no valida",
                        "Las 10 palabras más repetidas en el libro ",
                        "son: ",
                        "Error inesperado",
                        "Archivo no encontrado.");
            case ENG:
                return new Idiomas("""
                        --------------Menu--------------
                        Books available:
                        1. El Hobbit.
                        2. El principito.
                        3. El Padrino.
                        4. 1984.
                        5. Rebelión en la granja.
                        --------------------------------""",
                        "Invalid option",
                        "Top 10 most repeated words in the book ",
                        "are: ",
                        "Unexpected error",
                        "File not found.");

            default:
                throw new IllegalArgumentException("Idioma no disponible");
        }
    }

    /*Aqui definimos las posibles instancias de idioma.*/
    enum Idioma {
        ES, ENG
    }
}
