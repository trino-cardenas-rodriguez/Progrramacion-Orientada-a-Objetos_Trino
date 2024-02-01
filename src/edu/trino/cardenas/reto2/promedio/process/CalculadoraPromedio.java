package edu.trino.cardenas.reto2.promedio.process;

import java.util.Arrays;

public class CalculadoraPromedio {
    public static double calcularPromedio(double[] calificaciones){
        double suma_de_calificaciones = Arrays.stream(calificaciones).sum();
        return suma_de_calificaciones/calificaciones.length;
    }
}

/*
 double suma_de_calificaciones = 0;
 for (double calificacion : calificaciones){
 suma_de_calificaciones +=calificacion;
 }
 */