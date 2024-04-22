package edu.trino.cardenas.reto9.ui;

/*Esta clase sirve para traducir los textos dependiendo del idioma que elija el usuario.*/
public class Idiomas {

    /*Aqui declaramos nuestras variables para definirlas con el idioma que seleccione el usuario.*/
    private String MENU;
    private String PALABRAS_MAS_USADAS;
    private String SON;


    /*Aqui definimos los getters de las variables para poder llamarlas.*/
    public String getMENU() {
        return MENU;
    }


    public String getPALABRAS_MAS_USADAS() {
        return PALABRAS_MAS_USADAS;
    }

    public String getSON() {
        return SON;
    }

    /*Aqui definimos nuestro constructor*/
    public Idiomas(String MENU, String PALABRAS_MAS_USADAS, String SON) {
        this.MENU = MENU;
        this.PALABRAS_MAS_USADAS = PALABRAS_MAS_USADAS;
        this.SON = SON;
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
                        "Las 10 palabras más repetidas en el libro ",
                        "son: ");
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
                        "Top 10 most repeated words in the book ",
                        "are: ");

            default:
                throw new IllegalArgumentException("Idioma no disponible");
        }
    }

    /*Aqui definimos las posibles instancias de idioma.*/
    enum Idioma {
        ES, ENG
    }
}
