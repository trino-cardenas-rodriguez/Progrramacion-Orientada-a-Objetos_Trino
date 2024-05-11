package edu.trino.cardenas.evidencia3.ui;

import edu.trino.cardenas.evidencia3.data.Jugador;
import edu.trino.cardenas.evidencia3.process.Tablero;

import java.util.Random;
import java.util.Scanner;

import static edu.trino.cardenas.evidencia3.process.Tablero.*;

public class CLI {

    private static boolean contraComputadora;
    static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuIdiomas() {
        System.out.println("""
                --------------------------------------------------------------------------
                Seleccione su idioma / Select your language / あなたが使う言語を選んでください:
                ESP: Español / Spanish / スペイン語
                ENG: Inglés / English / 英語
                JAP: Japonés / Japanese / 日本語""");
    }

    public static boolean seleccionarModoJuego(){
        System.out.println(Idiomas.BIENVENIDA);
        System.out.println(Idiomas.SELECCIONE_OPCION);
        System.out.println(Idiomas.PVP);
        System.out.println(Idiomas.PVC);

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        if (opcion == 1){
            return false;
        } else if (opcion == 2) {
            return true;
        } else {
            System.out.println(Idiomas.OPCION_INVALIDA);
            return seleccionarModoJuego();
        }
    }

    public static void iniciarJuego() {

        do {
            if (!contraComputadora) {
                // Juego contra otra persona
                jugarContraJugador();
            } else {
                // Juego contra la computadora
                jugarContraComputadora();
            }

            System.out.println(Idiomas.JUGAR_NUEVAMENTE);
            scanner.nextLine();
            String respuesta = scanner.nextLine().toLowerCase();

            while (!respuesta.equals("si") && !respuesta.equals("no")) {
                System.out.println(Idiomas.RESPUESTA_INVALIDA);
                respuesta = scanner.nextLine().toLowerCase();
            }

            if (respuesta.equals("no")) {
                System.out.println(Idiomas.GRACIAS_POR_JUGAR);
                break;
            }

            // Reiniciar el tablero para una nueva partida
            Tablero.reiniciarTablero();

        } while (true);
    }

    private static void jugarContraJugador() {
        // Elegir aleatoriamente quién empieza
        turnoJugador1 = new Random().nextBoolean();
        System.out.println(Idiomas.NUEVA_PARTIDA);

        System.out.print(Idiomas.NOMBRE_JUGADOR_1);
        String nombreJugador1 = scanner.nextLine();
        while (cadenaVacia(nombreJugador1)) {
            System.out.println(Idiomas.NOMBRE_VACIO);
            System.out.print(Idiomas.NOMBRE_JUGADOR_1);
            nombreJugador1 = scanner.nextLine();
        }
        System.out.print(Idiomas.SIMBOLO_JUGADOR_1);
        String simboloJugador1 = scanner.nextLine().toUpperCase();

        while (cadenaVacia(simboloJugador1) || simboloJugador1.length() != 1 || !simbolosValidos.contains(simboloJugador1)) {
            System.out.println(Idiomas.SIMBOLO_NO_VALIDO);
            System.out.print(Idiomas.INGRESE_SIMBOLO);
            simboloJugador1 = scanner.nextLine().toUpperCase();
        }

        jugador1 = new Jugador(nombreJugador1, simboloJugador1);


        // Validar el nombre del jugador 2
        String nombreJugador2;
        do {
            System.out.print(Idiomas.NOMBRE_JUGADOR_2);
            nombreJugador2 = scanner.nextLine();
            if (nombreJugador2.equalsIgnoreCase(nombreJugador1)) {
                System.out.println(Idiomas.NOMBRE_JUGADOR_2_DIFERENTE);
            }
        } while (nombreJugador2.equalsIgnoreCase(nombreJugador1));

        String simboloJugador2;
        System.out.print(Idiomas.SIMBOLO_JUGADOR_2 + simboloJugador1 + "): ");
        simboloJugador2 = scanner.nextLine().toUpperCase();

        while (simboloJugador2.equals(simboloJugador1) || cadenaVacia(simboloJugador2) || simboloJugador2.length() != 1 || !simbolosValidos.contains(simboloJugador2)) {
            System.out.println(Idiomas.SIMBOLO_NO_VALIDO_DIFERENTE + simboloJugador1);
            System.out.print(Idiomas.SIMBOLO_JUGADOR_2 + simboloJugador1 + "): ");
            simboloJugador2 = scanner.nextLine().toUpperCase();
        }
        jugador2 = new Jugador(nombreJugador2, simboloJugador2);

        while (true) {
            if (turnoJugador1) {
                turnoJugador(jugador1);
            } else {
                turnoJugador(jugador2);
            }

            if (verificarVictoria()) {
                System.out.println("¡" + (turnoJugador1 ? jugador1.getNombre() : jugador2.getNombre()) +
                        Idiomas.HA_GANADO);
                break;
            }
            if (tableroLleno()) {
                System.out.println(Idiomas.EMPATE);
                break;
            }

            turnoJugador1 = !turnoJugador1;
        }

        // Actualizar el salón de la fama
        if (verificarVictoria()) {
            salonDeLaFama.actualizar(turnoJugador1 ? jugador1.getNombre() : jugador2.getNombre());
        }

        // Mostrar el salón de la fama al final de la partida
        salonDeLaFama.mostrar();
    }

    public static void jugarContraComputadora(){
        System.out.println(Idiomas.NUEVA_PARTIDA);
        System.out.print(Idiomas.NOMBRE);
        String nombreJugador1 = scanner.nextLine();
        while (cadenaVacia(nombreJugador1)) {
            System.out.println(Idiomas.NOMBRE_VACIO);
            System.out.print(Idiomas.NOMBRE);
            nombreJugador1 = scanner.nextLine();
        }
        System.out.print(Idiomas.INGRESE_SIMBOLO);
        String simboloJugador1 = scanner.nextLine().toUpperCase();

        while (cadenaVacia(simboloJugador1) || simboloJugador1.length() != 1 || !simbolosValidos.contains(simboloJugador1)) {
            System.out.println(Idiomas.SIMBOLO_NO_VALIDO);
            System.out.print(Idiomas.INGRESE_SIMBOLO);
            simboloJugador1 = scanner.nextLine().toUpperCase();
        }
        jugador1 = new Jugador(nombreJugador1, simboloJugador1);
        jugador2 = new Jugador("Computadora", simboloJugador1.equals("X") ? "O" : "X");

        while (true) {
            if (turnoJugador1) {
                turnoJugador(jugador1);
            } else {
                turnoComputadora();
            }

            if (verificarVictoria()) {
                System.out.println("¡" + (turnoJugador1 ? jugador1.getNombre() : jugador2.getNombre()) +
                        Idiomas.HA_GANADO);
                break;
            }
            if (tableroLleno()) {
                System.out.println(Idiomas.EMPATE);
                break;
            }

            turnoJugador1 = !turnoJugador1;
        }

        // Actualizar el salón de la fama
        if (verificarVictoria()) {
            salonDeLaFama.actualizar(jugador1.getNombre());
        }
    }

    private static void turnoJugador(Jugador jugador) {
        imprimirTablero(); // Mostrar el tablero antes de solicitar la jugada
        System.out.println(Idiomas.TURNO + jugador.getNombre() + " (" + jugador.getSimbolo() + ")");

        // Solicitar la fila
        int fila;
        do {
            System.out.print(Idiomas.FILA); // Cambio aquí
            fila = scanner.nextInt() - 1; // Cambio aquí
            if (fila < 0 || fila > 2) {
                System.out.println(Idiomas.FILA_INVALIDA); // Cambio aquí
            } else if (filaLlena(fila)) {
                System.out.println(Idiomas.FILA_LLENA);
            }
        } while (fila < 0 || fila > 2 || filaLlena(fila));

        // Solicitar la columna
        int columna;
        do {
            System.out.print(Idiomas.COLUMNA); // Cambio aquí
            columna = scanner.nextInt() - 1; // Cambio aquí
            if (columna < 0 || columna > 2) {
                System.out.println(Idiomas.COLUMNA_INVALIDA); // Cambio aquí
            } else if (columnaLlena(columna)) {
                System.out.println(Idiomas.COLUMNA_LLENA);
            }
        } while (columna < 0 || columna > 2 || columnaLlena(columna));

        // Verificar si la casilla está ocupada
        if (tablero[fila][columna] != '-') {
            System.out.println(Idiomas.CASILLA_INVALIDA);
            turnoJugador(jugador); // Solicitar una nueva jugada
        } else {
            // Colocar el símbolo en el tablero
            tablero[fila][columna] = jugador.getSimbolo().charAt(0);
            imprimirTablero();
        }
    }

    public static void launchGame() {
        mostrarMenuIdiomas();
        String idiomaSeleccionado = scanner.nextLine().toUpperCase();
        Idiomas.getInstance(idiomaSeleccionado);

        contraComputadora = seleccionarModoJuego(); // Obtener el valor del modo de juego
        Tablero juego = new Tablero(contraComputadora); // Crear una instancia de Juego con el modo de juego seleccionado

        iniciarJuego();
    }
}

