package edu.trino.cardenas.reto2.promedio.process;

//Aqui se importa Arrays de java, para poder utilizar los comandos de los arreglos.
import java.util.Arrays;

//Esta clase sirve para poder calcular el promedio.
public class CalculadoraPromedio {

    /**Este metodo sirve para realizar el calculo del promedio,
    con las calificaciones que ingrese el usuario.
     @param calificaciones que ingreso el usuario
     @return calculo de promedio*/
    public static double calcularPromedio(double[] calificaciones){

        /*Aqui se declara que se van a sumar todas las calificaciones dentro
        del arreglo "calificaciones", para despues dividir esa suma entre
        la longitud (cantidad de datos que tiene), del mismo arreglo.*/
        double sumaDeCalificaciones = Arrays.stream(calificaciones).sum();
        return sumaDeCalificaciones/calificaciones.length;
    }
}