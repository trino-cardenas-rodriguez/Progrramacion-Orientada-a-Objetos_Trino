package edu.trino.cardenas.reto3.diccionario.process;

import java.util.Arrays;

public class Diccionario {

    private final String[] palabras;

    private final String[] significados;

    public Diccionario(String[] palabras, String[] significados){
        this.palabras = palabras;
        this.significados = significados;
    }

    public String buscarSignificados(String palabra){
        return getDescription(getIndice(palabra));
    }

    private int getIndice(String palabra){
        int index = 0;
        while(index < palabras.length ){
            if(palabra.equalsIgnoreCase(palabras[index])) return index;
            index ++;
        }
        return -1;
    }

    private String getDescription(int index){
        if (index == -1) return "La palabra no esta en el diccionario";
        return significados[index];
    }

    public void printList(){
        Arrays
                .stream(palabras)
                .forEach(System.out::println);
    }
}
