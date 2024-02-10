package edu.trino.cardenas.reto3.numeros.ui;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

import static edu.trino.cardenas.reto3.numeros.process.Metodos.*;

public class CLI {

    public static void LaunchApp(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.println("                    Bienvenido                    ");
        System.out.println("--------------------------------------------------");

        int filas, columnas;
        do {
            System.out.println("Indique el numero de filas que requiere: ");
            filas = scanner.nextInt();
            System.out.println("Indique el numero de columnas que requiere: ");
            columnas = scanner.nextInt();

            if (filas != columnas) {
                System.out.println("Por favor ingrese valores iguales para filas y columnas.");
            }
        } while (filas != columnas);

        tablaCompleta(filas, columnas);
    }
}

