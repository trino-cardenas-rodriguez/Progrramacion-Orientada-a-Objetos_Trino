package edu.trino.cardenas.reto3.numeros.process;
public class Metodos {
    private static int [][] tabla;

    public static void tablaCompleta(int filas, int columnas){
        tabla = new int[filas][columnas];
        llenarTabla(filas, columnas);
        mostrarTabla(filas, columnas);
        contarParesImpares(filas, columnas);
        mostrarSumaTotal(filas, columnas);
    }


    private static void llenarTabla(int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tabla[i][j] = (int)(Math.random()*100);
            }
        }
    }

    private static void mostrarTabla(int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tabla[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void contarParesImpares(int filas, int columnas) {
        System.out.println("\n---------------------Filas----------------------");
        for (int i = 1; i < filas; i++) {
            int paresFila = 0, imparesFila = 0;
            for (int j = 0; j < columnas; j++) {
                if (tabla[i][j] % 2 == 0) {
                    paresFila++;
                } else {
                    imparesFila++;
                }
            }
            System.out.println("Cantidad de pares: " + paresFila + ", impares " +
                    imparesFila + " en la fila " + i);
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
                    imparesColumna + " en la columna " + j);
        }
    }

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
