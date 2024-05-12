package edu.trino.cardenas.evidencia3.process;

/**Aquí importamos la clase Idiomas, para poder realizar las */
import edu.trino.cardenas.evidencia3.ui.Idiomas;

/**Aquí importamos la función random, para poder utilizarla*/
import java.util.Random;

/**En esta clase definimos como se definen los turnos de la computadora.*/
public class JuegoComputadora {
    private char simbolo;

    public JuegoComputadora() {}

    public void setSimbolo(char simbolo){
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return this.simbolo;
    }

    /**Este método sirve para que la computadora genere una posición random en el tablero para colocar su símbolo.*/
    public void jugarTurno(char[][] tablero) {
        Random random = new Random();
        int fila, columna;
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (tablero[fila][columna] != '-');

        tablero[fila][columna] = simbolo;
        fila = fila + 1;
        columna = columna + 1;
        System.out.println(Idiomas.COMPUTADORA_HA_JUGADO + fila + "][" + columna + "]");
    }
}
