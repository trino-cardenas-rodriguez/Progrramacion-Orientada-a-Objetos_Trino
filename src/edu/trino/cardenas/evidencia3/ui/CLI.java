package edu.trino.cardenas.evidencia3.ui;

/**Aquí importamos la clase Tablero, para usar los métodos de esta clase.*/
import edu.trino.cardenas.evidencia3.process.Tablero;

/**Aquí se importa el scanner de java para poder reconocer los datos que ingrese el usuario.*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final HashSet<Character> simbolosValidos = new HashSet<>(Set.of('@', '#', '$', '%', '&', 'X', '0', '?', '+', '='));


    public static void mostrarMenuIdiomas() {
        System.out.println("""
                --------------------------------------------------------------------------
                Seleccione su idioma / Select your language / あなたが使う言語を選んでください:
                ESP: Español / Spanish / スペイン語
                ENG: Inglés / English / 英語
                JAP: Japonés / Japanese / 日本語""");
    }

    public static void mostrarMenuJuego() {
        System.out.println(Idiomas.NOMBRES);
        String nombreJugador1 = scanner.nextLine();
        char simboloJugador1;
        do {
            System.out.println(nombreJugador1 + " " + Idiomas.SIMBOLOS);
            simboloJugador1 = scanner.next().charAt(0);
            if (!simbolosValidos.contains(simboloJugador1)) {
                System.out.println("El símbolo seleccionado no es válido. Por favor, elija uno de la lista.");
            }
        } while (!simbolosValidos.contains(simboloJugador1));

        char simboloJugador2;
        String nombreJugador2;
        do {
            scanner.nextLine(); // Limpiar el buffer
            System.out.println(Idiomas.NOMBRES);
            nombreJugador2 = scanner.nextLine();
            do {
                System.out.println(nombreJugador2 + " " + Idiomas.SIMBOLOS);
                simboloJugador2 = scanner.next().charAt(0);
                if (!simbolosValidos.contains(simboloJugador2)) {
                    System.out.println("El símbolo seleccionado no es válido. Por favor, elija uno de la lista.");
                } else if (simboloJugador2 == simboloJugador1) {
                    System.out.println("El segundo jugador no puede elegir el mismo símbolo que el primer jugador. Por favor, elija otro.");
                }
            } while (!simbolosValidos.contains(simboloJugador2) || simboloJugador2 == simboloJugador1);
        } while (!simbolosValidos.contains(simboloJugador2));

        System.out.println("¡Hola " + nombreJugador1 + " y " + nombreJugador2 + "!");
        iniciarJuego(nombreJugador1, nombreJugador2, simboloJugador1, simboloJugador2);
    }

    public static void iniciarJuego(String nombreJugador1, String nombreJugador2, char simboloJugador1, char simboloJugador2) {
        do {
            Tablero tablero = new Tablero();
            char jugadorActual = simboloJugador1;

            System.out.println(Idiomas.BIENVENIDA);

            // Ciclo principal del juego
            while (true) {
                // Mostrar el tablero
                tablero.mostrarTablero();

                // Obtener la entrada del jugador
                System.out.println("Jugador " + nombreJugadorActual(jugadorActual, simboloJugador1, nombreJugador1, nombreJugador2) + " (" + jugadorActual + "), ingresa la fila y la columna (ejemplo: 1 2):");
                int fila = scanner.nextInt() - 1;
                int columna = scanner.nextInt() - 1;

                // Colocar la marca en el tablero si es una posición válida
                if (tablero.colocarMarca(fila, columna, jugadorActual)) {
                    // Verificar si hay un ganador
                    if (tablero.hayGanador()) {
                        tablero.mostrarTablero();
                        System.out.println("¡" + nombreJugadorActual(jugadorActual, simboloJugador1, nombreJugador1, nombreJugador2) + " ha ganado!");
                        break;
                    }
                    // Verificar empate
                    if (tablero.tableroLleno()) {
                        tablero.mostrarTablero();
                        System.out.println(Idiomas.EMPATE);
                        break;
                    }
                    // Cambiar al siguiente jugador
                    jugadorActual = (jugadorActual == simboloJugador1) ? simboloJugador2 : simboloJugador1;
                } else {
                    System.out.println(Idiomas.POSICION_INVALIDA);
                }
            }

            System.out.println("¿Quieren jugar de nuevo? (si/no)");
        } while (scanner.next().equalsIgnoreCase("si"));
    }


    public static String nombreJugadorActual(char jugadorActual, char simboloJugador1, String nombreJugador1, String nombreJugador2) {
        return (jugadorActual == simboloJugador1) ? nombreJugador1 : nombreJugador2;
    }


    public static void launchGame() {
        mostrarMenuIdiomas();
        String idiomaSeleccionado = scanner.nextLine().toUpperCase();
        Idiomas.getInstance(idiomaSeleccionado);

        mostrarMenuJuego();
    }
}
