package edu.trino.cardenas.evidencia3.process;

import edu.trino.cardenas.evidencia3.ui.Idiomas;

import java.util.Random;

public class JuegoComputadora {
    private char simbolo;

    public JuegoComputadora() {}

    public void setSimbolo(char simbolo){
        this.simbolo = simbolo;
    }

    public void jugarTurno(char[][] tablero) {
        Random random = new Random();
        int fila, columna;
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (tablero[fila][columna] != '-');

        tablero[fila][columna] = simbolo;
        System.out.println(Idiomas.COMPUTADORA_HA_JUGADO + fila + "][" + columna + "]");
    }
}
