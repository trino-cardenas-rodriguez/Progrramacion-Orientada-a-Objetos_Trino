package edu.trino.cardenas.reto7.ui;

/*Aqui se importa las clases que se encuentran dentro de la capeta process.*/
import edu.trino.cardenas.reto7.process.*;

/*Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.*/
import java.util.Scanner;

/*Esta clase sirve para mostar el menu al usuario y, en base en la opcion que elija,
mostrar el resultado de la operacion correspondiente a la opcion elegida;*/
public class CLI {

    /*Aqui declaramos una variable para llamar a las variables de la clase Textos,
    ademas asignadmos el idima español como predeterminado*/
    private static Textos textos = new Spanish();

    /*Este metodo sirve para mostar el menu de idioma al usuario y que pueda elegir el idioma que prefiera.
     Las opciones son las siguientes:
     1- Español
     2- English*/
    public static void showIdiomMenu() {
        System.out.println("------------------Idioma------------------");
        System.out.println("Escoja un idioma (Choose a language)");
        System.out.println("1- Español");
        System.out.println("2- English");
        System.out.println("------------------------------------------");
    }

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
        System.out.println(textos.CALCULADORA);
        System.out.println(textos.ELECCION);
        System.out.println(textos.SUMA);
        System.out.println(textos.RESTA);
        System.out.println(textos.MULTIPLICACION);
        System.out.println(textos.DIVISION);
        System.out.println(textos.MODULO);
        System.out.println(textos.POTENCIA);
        System.out.println(textos.RAIZ);
        System.out.println(textos.LOGARITMO);
        System.out.println("-----------------------------------------------");
    }

    /*Este metodo nos permite imprimir el resultado de cada operacion.*/
    public static void printResult(OperacionAritmetica operacionAritmetica, int valor1, int valor2){
        System.out.println(textos.RESULTADO+ operacionAritmetica.getClass().getSimpleName()
                + textos.ES + operacionAritmetica.calcular(valor1,valor2));
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

        showIdiomMenu();
        int idioma = scanner.nextInt();

        /*Este switch lee la opcion que seleccione el usuario y permite que todos
        los textos que se muestren esten en el idioma seleccionado por el usuario.*/
        switch (idioma){
            /*Este case se activa cuando el usuario elige la opcion "1" (Español).*/
            case 1:
                textos = new Spanish();
                break;
            /*Este case se activa cuando el usuario elige la opcion "a" (English).*/
            case 2:
                textos = new English();
                break;
        }
        System.out.println();

        showMenu();
        scanner.nextLine();
        String operacion= scanner.nextLine().toLowerCase();

        OperacionAritmetica operacionAritmetica;

        /*Este switch lee la opcion que seleccione el usuario y lo redirecciona a la case
        correspondiente, dependiendo de la operacion que desea hacer.*/
        switch (operacion){
            /*Este case se activa cuando el usuario elige la opcion "a" (Suma).*/
            case "a":
                System.out.println(textos.SUMANDO1);
                valor1 = scanner.nextInt();
                System.out.println(textos.SUMANDO2);
                valor2 = scanner.nextInt();
                operacionAritmetica = new Suma();
                printResult(operacionAritmetica, valor1, valor2);
                break;
            /*Este case se activa cuando el usuario elige la opcion "b" (Resta).*/
            case "b":
                System.out.println(textos.MINUENDO);
                valor1 = scanner.nextInt();
                System.out.println(textos.SUSTRAENDO);
                valor2 = scanner.nextInt();
                operacionAritmetica = new Resta();
                printResult(operacionAritmetica, valor1, valor2);
                break;
            /*Este case se activa cuando el usuario elige la opcion "c" (Multiplicacion).*/
            case "c":
                System.out.println(textos.MULTIPLICANDO);
                valor1 = scanner.nextInt();
                System.out.println(textos.MULTIPLICADOR);
                valor2 = scanner.nextInt();
                operacionAritmetica = new Multiplicacion();
                printResult(operacionAritmetica, valor1, valor2);
                break;
            /*Este case se activa cuando el usuario elige la opcion "d" (Division).*/
            case "d":
                System.out.println(textos.DIVIDENDO);
                valor1 = scanner.nextInt();
                System.out.println(textos.DIVISOR);
                valor2 = scanner.nextInt();
                operacionAritmetica = new Division();
                printResult(operacionAritmetica, valor1, valor2);
                break;
            /*Este case se activa cuando el usuario elige la opcion "e" (Modulo).*/
            case "e":
                System.out.println(textos.DIVIDENDO);
                valor1 = scanner.nextInt();
                System.out.println(textos.DIVISOR);
                valor2 = scanner.nextInt();
                operacionAritmetica = new Modulo();
                printResult(operacionAritmetica, valor1, valor2);
                break;
            /*Este case se activa cuando el usuario elige la opcion "f" (Potencia).*/
            case "f":
                System.out.println(textos.BASE);
                valor1 = scanner.nextInt();
                System.out.println(textos.EXPONENTE);
                valor2 = scanner.nextInt();
                operacionAritmetica = new Potencia();
                printResult(operacionAritmetica, valor1, valor2);
                break;
            /*Este case se activa cuando el usuario elige la opcion "g" (Raiz).*/
            case "g":
                System.out.println(textos.RADICAL);
                valor1 = scanner.nextInt();
                System.out.println(textos.INDICE);
                valor2 = scanner.nextInt();
                operacionAritmetica = new Raiz();
                printResult(operacionAritmetica, valor1, valor2);
                break;
            /*Este case se activa cuando el usuario elige la opcion "h" (Logaritmo).*/
            case "h":
                System.out.println(textos.ARGUMENTO);
                valor1 = scanner.nextInt();
                System.out.println(textos.BASE);
                valor2 = scanner.nextInt();
                operacionAritmetica = new LogaritmoDivision();
                printResult(operacionAritmetica, valor1, valor2);
                break;
            /*Este comando se activa cuando el usuario ingresa un dato no valido o
            una opcion que no se encuentra en el menu.*/
            default:
                throw new IllegalStateException(textos.DATO_NO_VALIDO+operacion+textos.REINICIE);
        }


    }
}