package edu.trino.cardenas.reto3.diccionario.process;

//Aqui se importa Arrays de java, para poder utilizar los comandos de los arreglos.
import java.util.Arrays;

/*Esta clase sirve para realizar los metodos que permiten mostrar
la lista de palbras y la lista de palabras con el conteo de sus caracteres;
ademas permite que se realice la busqueda de alguna palabra en el diccionario.*/
public class Diccionario {

    private final String[] palabras;

    private final String[] significados;

    /*Este  metodo sirve para llamar a los arreglos definidos en Main, para poder
    asignarlos a las variables privadas que estan dentro de esta clase.*/
    public Diccionario(String[] palabras, String[] significados){
        this.palabras = palabras;
        this.significados = significados;
    }

    /*Este metodo sirve para declarar un indice que perimte que se realice la busqueda
    de una palabra en el arreglo.*/
    private int getIndice(String palabra){
        int index = 0;
        while(index < palabras.length ){
            if(palabra.equalsIgnoreCase(palabras[index])) return index;
            index ++;
        }
        return -1;
    }

    /*Este metodo evalua el indice, para que si es igual a -1 mande un error,
    en cambio si el indice tiene un valor dentro del arreglo, permite que se
    imprima el significado correspondiente a ese valor.*/
    private String getDescription(int index){
        if (index == -1) return "La palabra no esta en el diccionario, por favor seleccione otra opcion.";
        return significados[index];
    }

    //Este metodo llama los dos metodos anteriores para poder llamar la operacion en el CLI
    public String buscarSignificados(String palabra){
        return getDescription(getIndice(palabra));
    }

    /*Este metodo permite que se impriman los datos dentro del
    arreglo de palabras, cada uno en un renglon.*/
    public void imprimirLista(){
        Arrays
                .stream(palabras)
                .forEach(System.out::println);
    }

    /*Este metodo permite que se imprima una lista de las palabras con el numero  de caracteres
    que tiene cada una, y el numero de caracteres que tiene su significado.*/
    public void mostrarDatosConCaracteres() {
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            String significado = significados[i];
            System.out.println(palabra + ", cantidad de caracteres: " + palabra.length()
                    + ", cantidad de caracteres de su significado: " + significado.length());
        }
    }
}
