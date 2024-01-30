package edu.trino.cardenas.reto1.ui;

/**
 * Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
 */
import java.util.Scanner;

/**
 * Aqui se importa la Calculadora de Masa Corporal del package edu.trino.cardenas.reto1.process,
 * para realizar los calculos correspondientes a la opcion que elija el usuario;
 * esto con los datos que ingrese el ususario.
 */
import static edu.trino.cardenas.reto1.process.CalculadoraMasaCorporal.*;

/**
 * Esta clase sirve para mostar el menu al usuario y, en base en la opcion que elija en el menu,
 * mostrar el resultado del calculo correspondiente a la opcion elegida;
 * esto en base a los datos que proporcione el usuario.
 */
public class CLI {

    /**
     * Este metodo sirve para mostar el menu al usuario y que pueda elegir la opcion que
     * corresponda al calculo que decea hacer. (Teniendo una opcion de salir de la aplicacion).
     * Las opciones son las siguientes:
     * 1. Calculo de masa corporal
     * 2. Calculo de masa corporal magra
     * 3. Calculo de metabolismo basal
     * 4. Salir
     */
    public static void showMenu(){
        System.out.println("--------------------------------------");
        System.out.println("Elige una opcion de la calculadora");
        System.out.println("1. Calculo de masa corporal");
        System.out.println("2. Calculo de masa corporal magra");
        System.out.println("3. Calculo de metabolismo basal");
        System.out.println("4. Salir");
        System.out.println("--------------------------------------");
    }

    /**
     * Este metodo sirve para inicar la calculadora, mostrando el menu y
     * leyendo la opcion que seleccione el usuario; y, en base en esa seleccion,
     * poder pedirle los datos que sean necesarios para el calculo correspondiente
     * a la opcion que alla elegido; esto utilizando un "switch case".
     */
    public static void LaunchCalculator(){
        Scanner scanner = new Scanner(System.in);

            showMenu();
            int opcion = scanner.nextInt();
            double estatura, peso, edad, sexo;

        /**
         * Este switch lee la opcion que seleccione el usuario y lo redirecciona a la case correspondiente,
         * dependiendo del calculo que el usuario desea hacer.
         */
            switch(opcion){
                /**
                 * Este case se activa cuando el usuario elige la opcion 1 (Calculo de masa corporal),
                 * y le solicita al usuario que ingrese los datos necesarios para ese calculo.
                 */
                case 1:
                    System.out.println("Ingrese su estatura en cm: ");
                    estatura = scanner.nextDouble();
                    System.out.println("Ingrese su peso en kg: ");
                    peso = scanner.nextDouble();
                    double indiceMasaCorporal = calcularIndiceMasaCorporal(estatura, peso);
                    String estado = clasificarIndiceMasaCorporal(indiceMasaCorporal);
                    System.out.printf("Tu indice de masa corporal es %f " +
                            "por lo que se considera que estas en un estdo de %s",indiceMasaCorporal,estado);
                    break;
                /**
                 * Este case se activa cuando el usuario elige la opcion 2 (Calculo de masa corporal magra),
                 * y le solicita al usuario que ingrese los datos necesarios para ese calculo.
                 */
                case 2:
                    System.out.println("Ingrese su estatura en cm: ");
                    estatura = scanner.nextDouble();
                    System.out.println("Ingrese su peso en kg: ");
                    peso = scanner.nextDouble();
                    System.out.println("Ingrese su sexo: \n1. Hombre \n2. Mujer");
                    sexo = scanner.nextDouble();
                    double indiceMasaCorporalMagra = calcularIndiceMasaCorporalMagra(estatura, peso, sexo);
                    System.out.printf("Tu indice de masa corporal magra es: "+indiceMasaCorporalMagra);
                    break;
                /**
                 * Este case se activa cuando el usuario elige la opcion 3 (Calculo de metabolismo basal),
                 * y le solicita al usuario que ingrese los datos necesarios para ese calculo.
                 */
                case 3:
                    System.out.println("Ingrese su edad: ");
                    edad = scanner.nextDouble();
                    System.out.println("Ingrese su estatura en cm: ");
                    estatura = scanner.nextDouble();
                    System.out.println("Ingrese su peso en kg: ");
                    peso = scanner.nextDouble();
                    System.out.println("Ingrese su sexo: \n1. Hombre \n2. Mujer");
                    sexo = scanner.nextDouble();
                    double indiceMetabolismoBasal = calcularIndiceMetabolismoBasal(estatura, peso, sexo, edad);
                    System.out.printf("Tu indice de metabolismo basal es: "+indiceMetabolismoBasal);
                    break;
                /**
                 * Este case se activa cuando el usuario elige la opcion 4 (salir),
                 * y permite que el codigo termine, y que el usuario pueda salir de la aplicacion.
                 */
                case 4:
                    System.exit(0);
                    break;
                /**
                 * Este comando se activa cuando el usuario ingresa un dato no valido o
                 * una opcion que no se encuentra en el menu.
                 */
                default:
                    throw new IllegalStateException("\nDato no valido: "+opcion+"\nReinicie");
            }

        System.out.println("\nAplicación terminada");

    }
}
