package edu.trino.cardenas.reto1.ui;

import edu.trino.cardenas.reto1.process.CalculadoraMasaCorporal;

import java.util.Scanner;

import static edu.trino.cardenas.reto1.process.CalculadoraMasaCorporal.calcularIndiceMasaCorporal;
import static edu.trino.cardenas.reto1.process.CalculadoraMasaCorporal.clasificarIndiceMasaCorporal;

public class CLI {
    public static void showMenu(){
        System.out.println("--------------");
        System.out.println("Elige una opcion de la calculadora");
        System.out.println("1. Calculo de masa corporal");
        System.out.println("2. Calculo de masa corporal magra");
        System.out.println("3. Calculo de metabolismo basal");
        System.out.println("4. salir");
        System.out.println("--------------");
    }

    public static void LaunchCalculator(){
        Scanner scanner = new Scanner(System.in);

            showMenu();
            int opcion = scanner.nextInt();
            double estatura, peso;
            String sexo;

            switch(opcion){
                case 1:
                    System.out.println("Ingrese su estatura en cm: ");
                    estatura = scanner.nextDouble();
                    System.out.println("Ingrese su peso en kg: ");
                    peso = scanner.nextDouble();
                    double imc = calcularIndiceMasaCorporal(estatura, peso);
                    String estado = clasificarIndiceMasaCorporal(imc);
                    System.out.printf("Tu indice de masa corporal es %f " +
                            "por lo que se considera que estas en un estdo de %s",imc,estado);

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }

        System.out.println("\nAplicación terminada");

    }
}
