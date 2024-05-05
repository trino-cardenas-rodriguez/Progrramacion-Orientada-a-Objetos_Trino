package edu.trino.cardenas.evidencia3.ui;

/**Aquí importamos la clase Tablero, para usar los métodos de esta clase.*/
import edu.trino.cardenas.evidencia3.process.Tablero;

/**Aquí se importa el scanner de java para poder reconocer los datos que ingrese el usuario.*/
import java.util.Scanner;

public class CLI {

    public static void launchGame(){
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        char jugadorActual = 'X';

        System.out.println("Bienvenido al juego Tic Tac Toe!");

        // Ciclo principal del juego
        while (true) {
            // Mostrar el tablero
            tablero.mostrarTablero();

            // Obtener la entrada del jugador
            System.out.println("Jugador " + jugadorActual + ", ingresa la columna y la fila (ejemplo: 1 2):");
            int fila = scanner.nextInt() - 1;
            int columna = scanner.nextInt() - 1;

            // Colocar la marca en el tablero si es una posición válida
            if (tablero.colocarMarca(fila, columna, jugadorActual)) {
                // Verificar si hay un ganador
                if (tablero.hayGanador()) {
                    tablero.mostrarTablero();
                    System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
                    break;
                }
                // Verificar empate
                if (tablero.tableroLleno()) {
                    tablero.mostrarTablero();
                    System.out.println("¡Empate!");
                    break;
                }
                // Cambiar al siguiente jugador
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Posición inválida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }
}
