package edu.trino.cardenas.evidencia3.process;

import edu.trino.cardenas.evidencia3.data.Jugador;
import edu.trino.cardenas.evidencia3.data.SalonDeLaFama;
import edu.trino.cardenas.evidencia3.ui.Idiomas;

import java.util.HashSet;

import java.util.Set;


public class Tablero {
    public static char[][] tablero;
    public static Jugador jugador1;
    public static Jugador jugador2;
    public static boolean turnoJugador1;
    public static SalonDeLaFama salonDeLaFama;
    public static final HashSet<String> simbolosValidos = new HashSet<>(Set.of("@", "#", "$", "%", "&", "X", "0", "?", "+", "="));
    public static JuegoComputadora juegoComputadora; // Agrega una instancia de JuegoComputadora

    public Tablero(boolean unJugador) {
        salonDeLaFama = new SalonDeLaFama();
        turnoJugador1 = true;
        tablero = new char[3][3];
        juegoComputadora = new JuegoComputadora(); // Inicializa la instancia de JuegoComputadora
        // Inicializar el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public static boolean cadenaVacia(String cadena) {
        return cadena.trim().isEmpty();
    }



    public static boolean filaLlena(int fila) {
        for (int j = 0; j < 3; j++) {
            if (tablero[fila][j] == '-') {
                return false; // Si encuentra al menos una casilla vacía, la fila no está llena
            }
        }
        return true; // Si no hay casillas vacías, la fila está llena
    }

    public static boolean columnaLlena(int columna) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][columna] == '-') {
                return false; // Si encuentra al menos una casilla vacía, la columna no está llena
            }
        }
        return true; // Si no hay casillas vacías, la columna está llena
    }

    public static void turnoComputadora() {
        if (juegoComputadora != null) {
            juegoComputadora.setSimbolo(jugador2.getSimbolo().charAt(0)); // Establece el símbolo de la computadora
            juegoComputadora.jugarTurno(tablero); // Llama al método jugarTurno de JuegoComputadora
            imprimirTablero(); // Mostrar el tablero después de que la computadora juegue
        } else {
            System.out.println(Idiomas.ERROR_INICIALIZACION);
        }
    }

    public static boolean verificarVictoria() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != '-' && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
                return true; // Verificación horizontal
            }
            if (tablero[0][i] != '-' && tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]) {
                return true; // Verificación vertical
            }
        }
        if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            return true; // Verificación diagonal 1
        }
        if (tablero[0][2] != '-' && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            return true; // Verificación diagonal 2
        }
        return false;
    }

    public static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void reiniciarTablero() {
        // Reiniciar el tablero para una nueva partida
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public static void imprimirTablero() {
        System.out.println(Idiomas.TABLERO);
        System.out.println("   1   2   3"); // Modificado: Cambiar las coordenadas de 0 a 2 a 1 a 3
        System.out.println(" ╔═══╦═══╦═══╗");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "║"); // Modificado: Ajustar las filas para mostrar de 1 a 3 en lugar de 0 a 2
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tablero[i][j] + " ║");
            }
            System.out.println();
            if (i < 2) {
                System.out.println(" ╠═══╬═══╬═══╣");
            }
        }
        System.out.println(" ╚═══╩═══╩═══╝");
    }
}
