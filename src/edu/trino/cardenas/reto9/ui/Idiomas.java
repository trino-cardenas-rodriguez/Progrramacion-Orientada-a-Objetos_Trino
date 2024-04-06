package edu.trino.cardenas.reto9.ui;

public class Idiomas {

    private String MENU;

    public Idiomas(String MENU) {
        this.MENU = MENU;
    }

    public static Idiomas getInstance(String idioma){
        switch (Idioma.valueOf(idioma)){
            case ES:
                return new Idiomas("espanol");
            case ENG:
                return new Idiomas("ingles");

            default:
                throw new IllegalArgumentException("Idioma no disponible");
        }
    }

    public String getMenu() {
        return MENU;
    }

    enum Idioma {
        ES, ENG
    }
}
