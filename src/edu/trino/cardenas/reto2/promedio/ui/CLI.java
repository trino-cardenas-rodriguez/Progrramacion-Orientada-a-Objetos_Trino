package edu.trino.cardenas.reto2.promedio.ui;

/*Aqui se importa la calculadora de promedio, del package edu.trino.cardenas.reto2.promedio.process,
para poder realizar el calculo del promedio con las calificaciones que el usuario ingrese.*/
import edu.trino.cardenas.reto2.promedio.process.CalculadoraPromedio;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

/*Esta clase sirve para pedirle al usuario cuantas calificaciones quiere ingresar,
cuales son esas calificaiones; y, en base en eso, poder regresarle su promedio.*/
public class CLI {

    /*Este metodo sirve para iniciar la aplicacion pidiendole cuantas calificaciones quiere ingresar,
    y cuales son esas calificaciones, guardandolas en un arreglo; para despues calcular el
    promedio de estas.*/
    public static void LaunchApp() {
        Scanner scanner = new Scanner(System.in);
        //Aqui se lee cuentas calificaciones quiere ingresar el usuario
        System.out.println("Ingrese el numero de calificaciones que desea capturar:");
        int numeroDeCalificaciones = scanner.nextInt();

        /*Aqui se define un arreglo, cuya longitud sera el numero de calificaciones que
        el usuario quiere ingresar.*/
        double[] calificaciones;
        calificaciones = new double[numeroDeCalificaciones];

        /*Aqui se usa un for para que por cada lugar dentro del arreglo "calificaciones",
        se pida una calificacion al usuario, guardandolas dentro del arreglo hasta que este se llene.*/
        for (int i = 0; i < numeroDeCalificaciones; i++) {
            System.out.println("Ingrese la calificacion " + (i+1));
            calificaciones[i] = scanner.nextDouble();
        }

        /*Aqui se manda a llamr el metodo CalculadoraPromedio.calcularPromedio(calificaciones),
        para poder calcular e imprimir el promedio del usuario; en base a los datos que haya ingresado.*/
        double promedio = CalculadoraPromedio.calcularPromedio(calificaciones);
        System.out.println("Su promedio final es: "+promedio);
    }
}