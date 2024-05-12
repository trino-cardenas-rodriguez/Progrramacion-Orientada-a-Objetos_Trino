package edu.trino.cardenas.evidencia3.data;

/**Esta es una clase de data donde guardaremos el nombre y el símbolo que seleccione el jugador.*/
public class Jugador {

    /**Definimos los atributos del jugador.*/
    private String nombre;
    private String simbolo;

    /**Creamos el constructor del jugador.*/
    public Jugador(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    /**Creamos los getter de los atributos del jugador.*/
    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
