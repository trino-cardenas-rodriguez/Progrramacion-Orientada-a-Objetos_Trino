package edu.trino.cardenas.evidencia3.process;

// Clase para representar el tablero del juego
public class Tablero {
    private char[][] tablero;

    // Constructor para inicializar el tablero
    public Tablero() {
        tablero = new char[3][3];
        reiniciarTablero();
    }

    // Método para reiniciar el tablero
    public void reiniciarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Método para mostrar el tablero
    public void mostrarTablero() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Método para colocar una marca en el tablero
    public boolean colocarMarca(int fila, int columna, char marca) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = marca;
            return true;
        } else {
            return false;
        }
    }

    // Método para verificar si hay un ganador
    public boolean hayGanador() {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
                return true;
            }
            if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]) {
                return true;
            }
        }
        // Verificar diagonales
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            return true;
        }
        if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            return true;
        }
        return false;
    }

    // Método para verificar si el tablero está lleno (empate)
    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

