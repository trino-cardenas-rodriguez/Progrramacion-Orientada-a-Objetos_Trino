package edu.trino.cardenas.reto2.promedio.ui;

import edu.trino.cardenas.reto2.promedio.process.CalculadoraPromedio;

import java.util.Scanner;

public class CLI {
    public static void LaunchApp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de calificaciones que desea capturar:");
        int numeroDeCalificaciones = scanner.nextInt();

        double[] calificaciones;
        calificaciones = new double[numeroDeCalificaciones];
        for (int i = 0; i < numeroDeCalificaciones; i++) {
            System.out.println("Ingrese la calificacion " + (i+1));
            calificaciones[i] = scanner.nextDouble();
        }

        double promedio = CalculadoraPromedio.calcularPromedio(calificaciones);
        System.out.println("Su promedio final es: "+promedio);
    }
}