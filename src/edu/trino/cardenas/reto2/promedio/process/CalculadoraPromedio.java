package edu.trino.cardenas.reto2.promedio.process;

import java.util.Arrays;

public class CalculadoraPromedio {
    public static double calcularPromedio(double[] calificaciones){
        double sumaDeCalificaciones = Arrays.stream(calificaciones).sum();
        return sumaDeCalificaciones/calificaciones.length;
    }
}

/*
 double sumaDeCalificaciones = 0;
 for (double calificacion : calificaciones){
 sumaDeCalificaciones +=calificacion;
 }
 */