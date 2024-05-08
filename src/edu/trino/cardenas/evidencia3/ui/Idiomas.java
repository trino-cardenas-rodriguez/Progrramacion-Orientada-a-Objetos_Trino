package edu.trino.cardenas.evidencia3.ui;

public class Idiomas {
    public static String BIENVENIDA;
    public static String NOMBRES;
    public static String SIMBOLOS;
    public static String INICIO_JUEGO;
    public static String JUGAR_DE_NUEVO;
    public static String GANADOR;
    public static String POSICION_INVALIDA;
    public static String EMPATE;
    public static String JUGAR;

    public static void getInstance(String idioma) {
        Textos opcion = Textos.valueOf(idioma);
        switch (opcion) {
            case ESP:
                BIENVENIDA = "¡Bienvenido al juego del gato!";
                NOMBRES = "Elige tu nombre: ";
                SIMBOLOS = "Elige tu propio símbolo, hay 10 disponibles: \n" +
                        "@ # $ % & X 0 ? + =";
                INICIO_JUEGO = "Perfecto, ingresa la fila y la columna (ejemplo: 1 2):";
                JUGAR_DE_NUEVO = "¿Desea jugar de nuevo?";
                GANADOR = " ";
                POSICION_INVALIDA = "Posición inválida. Inténtalo de nuevo.";
                EMPATE = "¡Empate!";
                JUGAR = "¿Qué modo deseas jugar? 1: IA / 2: 1v1"; // Se juega con la computadora por defecto
                break;

            case ENG:
                NOMBRES = "Choose your nickname: \n";
                INICIO_JUEGO = " ";
                SIMBOLOS = " ";
                JUGAR_DE_NUEVO = " ";
                GANADOR = " ";
                JUGAR = "";
                break;

            case JAP:
                NOMBRES = " ";
                INICIO_JUEGO = " ";
                SIMBOLOS = " ";
                JUGAR_DE_NUEVO = " ";
                GANADOR = " ";
                JUGAR = ""; // Se juega con la computadora por defecto
                break;
            default:
                throw new IllegalArgumentException("Invalid language selection");
        }
    }

    private enum Textos {
        ESP, ENG, JAP
    }
}
