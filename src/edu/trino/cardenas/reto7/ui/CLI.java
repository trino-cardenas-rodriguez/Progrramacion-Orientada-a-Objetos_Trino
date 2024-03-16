package edu.trino.cardenas.reto7.ui;

/*Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.*/
import edu.trino.cardenas.reto7.process.*;

import java.util.Scanner;

/*Esta clase sirve para mostar el menu al usuario y, en base en la opcion que elija,
mostrar el resultado de la operacion correspondiente a la opcion elegida;*/
public class CLI {

    /*Este metodo sirve para mostar el menu al usuario y que pueda elegir la opcion que
     corresponda a la operacion que decea hacer.
     Las opciones son las siguientes:
     a. Suma
     b. Resta
     c. Multiplicacion
     d. Division
     e. Modulo
     f. Potencia
     g. Raiz
     h. Logaritmo*/
    public static void showMenu() {
        System.out.println("------------------Calculadora------------------");
        System.out.println("Elija la operacion que desea realizar:");
        System.out.println("a. Suma");
        System.out.println("b. Resta");
        System.out.println("c. Multiplicacion");
        System.out.println("d. Division");
        System.out.println("e. Modulo");
        System.out.println("f. Potencia");
        System.out.println("g. Raiz");
        System.out.println("h. Logaritmo");
        System.out.println("-----------------------------------------------");
    }

    /*Aqui se definen las variables de los valores con los cuales se
    realizara la operacion que indique el usuario*/
    public static int valor1 = 0;
    public static int valor2 = 0;

    /*Este metodo sirve para inicar la calculadora, mostrando el menu y
    leyendo la opcion que seleccione el usuario; y, en base en esa seleccion,
    poder realizar la operacion correspondiente a la opcion que alla elegido;
    esto utilizando un "switch case".*/
    public static void launchCalculadora() {
        Scanner scanner = new Scanner(System.in);

        showMenu();
        String operacion= scanner.nextLine().toLowerCase();

        OperacionAritmetica operacionAritmetica;
        /*Este switch lee la opcion que seleccione el usuario y lo redirecciona a la case
        correspondiente, dependiendo de la operacion que desea hacer.*/
        switch (operacion){
            /*Este case se activa cuando el usuario elige la opcion "a" (Suma).*/
            case "a":
                System.out.println("Ingrese el primer valor de la suma");
                valor1 = scanner.nextInt();
                System.out.println("Ingrese el segundo valor de la suma");
                valor2 = scanner.nextInt();
                operacionAritmetica = new Suma();
                int resultadoSuma = operacionAritmetica.calcular(valor1, valor2);
                System.out.println("El valor de su suma es: " + resultadoSuma);
                break;
            /*Este case se activa cuando el usuario elige la opcion "b" (Resta).*/
            case "b":
                System.out.println("Ingrese el primer valor de la resta");
                valor1 = scanner.nextInt();
                System.out.println("Ingrese el segundo valor de la resta");
                valor2 = scanner.nextInt();
                operacionAritmetica = new Resta();
                int resultadoResta = operacionAritmetica.calcular(valor1, valor2);
                System.out.println("El valor de su resta es: " + resultadoResta);
                break;
            /*Este case se activa cuando el usuario elige la opcion "c" (Multiplicacion).*/
            case "c":
                System.out.println("Ingrese el primer valor de la multipicacion");
                valor1 = scanner.nextInt();
                System.out.println("Ingrese el segundo valor de la multipicacion");
                valor2 = scanner.nextInt();
                operacionAritmetica = new Multiplicacion();
                int resultadoMultiplicacion = operacionAritmetica.calcular(valor1, valor2);
                System.out.println("El valor de su multiplicacion es: " + resultadoMultiplicacion);
                break;
            /*Este case se activa cuando el usuario elige la opcion "d" (Division).*/
            case "d":
                System.out.println("Ingrese el dividendo");
                valor1 = scanner.nextInt();
                System.out.println("Ingrese el divisor");
                valor2 = scanner.nextInt();
                operacionAritmetica = new Division();
                int resultadoDivision = operacionAritmetica.calcular(valor1, valor2);
                System.out.println("El valor de su division es: " + resultadoDivision);
                break;
            /*Este case se activa cuando el usuario elige la opcion "e" (Modulo).*/
            case "e":
                System.out.println("Ingrese el dividendo");
                valor1 = scanner.nextInt();
                System.out.println("Ingrese el divisor");
                valor2 = scanner.nextInt();
                operacionAritmetica = new Modulo();
                int resultadoModulo = operacionAritmetica.calcular(valor1, valor2);
                System.out.println("El valor de su modulo (residuo) es: " + resultadoModulo);
                break;
            /*Este case se activa cuando el usuario elige la opcion "f" (Potencia).*/
            case "f":
                System.out.println("Ingrese el valor de la base");
                valor1 = scanner.nextInt();
                System.out.println("Ingrese el valor del exponente");
                valor2 = scanner.nextInt();
                operacionAritmetica = new Potencia();
                int resultadoPotencia = operacionAritmetica.calcular(valor1, valor2);
                System.out.println("El valor de su potencia es: " + resultadoPotencia);
                break;
            /*Este case se activa cuando el usuario elige la opcion "g" (Raiz).*/
            case "g":
                System.out.println("Ingrese el valor del radical");
                valor1 = scanner.nextInt();
                operacionAritmetica = new Raiz();
                int resultadoRaiz = operacionAritmetica.calcular(valor1, valor2);
                System.out.println("El valor de su raiz es: " + resultadoRaiz);
                break;
            /*Este case se activa cuando el usuario elige la opcion "h" (Logaritmo).*/
            case "h":
                System.out.println("Ingrese el valor del argumento");
                valor1 = scanner.nextInt();
                System.out.println("Ingrese el valor de la base");
                valor2 = scanner.nextInt();
                operacionAritmetica = new Logaritmo();
                int resultadoLogaritmo = operacionAritmetica.calcular(valor1, valor2);
                System.out.println("El valor de su logaritmo es: " + resultadoLogaritmo);
                break;
            /*Este comando se activa cuando el usuario ingresa un dato no valido o
            una opcion que no se encuentra en el menu.*/
            default:
                throw new IllegalStateException("\nDato no valido: "+operacion+"\nReinicie");
        }


    }
}