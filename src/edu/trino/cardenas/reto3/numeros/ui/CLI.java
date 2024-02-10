package edu.trino.cardenas.reto3.numeros.ui;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

/*Aqui se importa el apartado Metodos del paquete edu.trino.cardenas.reto3.numeros.process,
para poder llamar a los metodos declarados en este.*/
import static edu.trino.cardenas.reto3.numeros.process.Metodos.*;

/*Esta calse sirve para iniciar la aplicacion, pedirle datos al usuario,
y en base a esos datos poder imprimir una matriz con numeros aleatorios.*/
public class CLI {

    //Este metodo sirve para iniciar la aplicacion.
    public static void LaunchApp(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.println("                    Bienvenido                    ");
        System.out.println("--------------------------------------------------");

        int filas, columnas;

        /*Aqui se inicia un bucle do-while, que le pedira al usuario que ingrese la
        cantidad de filas y columnas que requiere; esto mientras el numero de filas
        y el numero de columnas que requiera sean diferentes; sino imprimira la matriz
        con las filas y columnas indicadas.*/
        do {
            //Aqui le pedimos al usuario que ingrese la cantidad de filas y columnas que requiere.
            System.out.println("Indique el numero de filas que requiere: ");
            filas = scanner.nextInt();
            System.out.println("Indique el numero de columnas que requiere: ");
            columnas = scanner.nextInt();

            //Este if valida si el numero de filas y el numero de columnas son diferentes.
            if (filas != columnas) {
                System.out.println("Por favor ingrese valores iguales para filas y columnas.\n");
            }
        } while (filas != columnas);

        /*Aqui se manda a llamr el metodo que imprime la matriz, los numeros pares e
        impares de cada fila y columna, y la suma de todos los numeros de la matriz.*/
        tablaCompleta(filas, columnas);
    }
}

