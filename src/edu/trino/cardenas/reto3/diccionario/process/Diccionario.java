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
        if (index == -1) return "La palabra no esta en el diccionario, por favor seleccione otra opcion";
        return significados[index];
    }

    public void imprimirLista(){
        Arrays
                .stream(palabras)
                .forEach(System.out::println);
    }

    public void mostrarDatosConCaracteres() {
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            String significado = significados[i];
            System.out.println(palabra + ", cantidad de caracteres: " + palabra.length()
                    + ", cantidad de caracteres de su significado: " + significado.length());
        }
    }
}
