package edu.trino.cardenas.reto3.numeros.process;

//Esta clase sirve para realizar todos lo metodos necesarios para poder realizar la impresion requerida.
public class Metodos {

    //Aqui declaro mi matriz.
    private static int [][] tabla;


    /*En este metodo declaro arreglos de la matriz y tabien declaro los metodos que se necitan imprimir,
    para solo tener que llamar este metodo principal en CLI.*/
    public static void tablaCompleta(int filas, int columnas){
        tabla = new int[filas][columnas];
        llenarTabla(filas, columnas);
        mostrarTabla(filas, columnas);
        contarParesImpares(filas, columnas);
        mostrarSumaTotal(filas, columnas);
    }

    //En este metodo llena los arreglos de la matriz con numeros aleatorios.
    private static void llenarTabla(int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tabla[i][j] = (int)(Math.random()*100);
            }
        }
    }

    //Este metodo sirve para imprimir la matriz por filas y columnas.
    private static void mostrarTabla(int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tabla[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Este metodo sirve para contar y mostrar los numeros pares e impares en cada fila y columna de la matriz.
    private static void contarParesImpares(int filas, int columnas) {
        System.out.println("\n---------------------Filas----------------------");
        for (int i = 0; i < filas; i++) {
            int paresFila = 0, imparesFila = 0;
            for (int j = 0; j < columnas; j++) {
                if (tabla[i][j] % 2 == 0) {
                    paresFila++;
                } else {
                    imparesFila++;
                }
            }
            System.out.println("Cantidad de pares: " + paresFila + ", impares " +
                    imparesFila + " en la fila " + (i+1));
        }

        System.out.println("\n--------------------Columnas--------------------");
        for (int j = 0; j < columnas; j++) {
            int paresColumna = 0, imparesColumna = 0;
            for (int i = 0; i < filas; i++) {
                if (tabla[i][j] % 2 == 0) {
                    paresColumna++;
                } else {
                    imparesColumna++;
                }
            }
            System.out.println("Cantidad de pares: " + paresColumna + ", impares " +
                    imparesColumna + " en la columna " + (j+1));
        }
    }

    //Este metodo realiza e imprime una suma de todos los numeros contenidos en la matriz.
    private static void mostrarSumaTotal(int filas, int columnas) {
        int sumaTotal = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sumaTotal += tabla[i][j];
            }
        }
        System.out.println("\n-------------------Suma Total-------------------");
        System.out.println("Suma total de los valores del vector es: " + sumaTotal);
    }
}
