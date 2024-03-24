package edu.trino.cardenas.reto7.process;

/*Aqui se importa la variable textos, para poder implimir los errores de definicion de la raiz,
y la aproximacion de la raiz, en el idioma que elija el usuario.*/
import static edu.trino.cardenas.reto7.ui.CLI.textos;

/*Esta calse es una extencion de la clase Multiplicacion,
y permite hacer la operacion de raiz*/
public class Raiz extends Multiplicacion{

    /*Aqui se sobre escribe el metdo calcular definido en la clase base OperacionAritmetica*/
    @Override
    public int calcular(int valor1, int valor2) {

        /*Aqui declaramos que si nuestro radical es negativo, no se pueda
        realizar la operacion y se muestre un error especifico.*/
        if (valor1 < 0) throw new ArithmeticException(textos.ERROR_RADICAL_NEGATIVO);

        /*Aqui declaramos que si nuestro indice es negativo, no se pueda
        realizar la operacion y se muestre un error especifico.*/
        if (valor2 < 0) throw new ArithmeticException(textos.ERROR_INDICE_NEGATIVO);

        /*Aqui declaramos las variables necesarias para realizar la operacion de raiz.*/
        int raiz;
        int pruebaPotecncias = 0;
        int validacion = 0;
        int aproximacion = 1;

        /*Aqui declaramos que vamos a tomar un valor inicializado en 1 y le vamos a ir sacando la
        potencia del mismo nivel que el indice del la raiz, despues de sacarle raiz vamos a agregarle
        1 al valor para volver a sacarle potencia. Vamos a hacer esto mientras el resultado de esta
        potencia sea menor al valor del radical.*/
        while (pruebaPotecncias < valor1) {
            validacion = aproximacion;
            pruebaPotecncias = 1;
            for (int i = 0; i < valor2; i++) {
                pruebaPotecncias = super.calcular(pruebaPotecncias, aproximacion);
            }
            aproximacion++;
        }
        raiz = validacion;

        /*Aqui definimos que si la potencia de nuestra raiz es diferente al valor1, se indique
        que esta raiz es un aproximado, y se de el valor con el que la raiz seria exacta.*/
        int potencia = 1;
        for (int i = 0; i < valor2; i++) {
            potencia = super.calcular(potencia, raiz);
        }

        if (potencia != valor1) {
            System.out.println(textos.APROXIMACION_RAIZ);
            System.out.println(textos.RADICAL_EXACTO_RAIZ + potencia);
        }

        /*Aqui pedimos que nos imprima el resultado del logaritmo*/
        return raiz;
    }
}
