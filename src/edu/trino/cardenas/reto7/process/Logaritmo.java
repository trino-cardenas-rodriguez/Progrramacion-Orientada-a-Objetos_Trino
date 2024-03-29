package edu.trino.cardenas.reto7.process;

/*Aqui se importa la variable textos, para poder implimir el error de definicion del logatitmo,
y la aproximacion del logaritmo, en el idioma que elija el usuario.*/
import static edu.trino.cardenas.reto7.ui.CLI.textos;

/*Esta calse es una extencion de la clase Multiplicacion,
y permite hacer la operacion de logaritmo*/
public class Logaritmo extends Multiplicacion{

    /*Aqui se sobre escribe el metdo calcular definido en la clase base OperacionAritmetica*/
    @Override
    public int calcular(int valor1, int valor2) {

        /*Aqui declaramos que si nuestra base es negativa o nuestro argumento es
        menor o igual a dos,no se pude realizar la operacion*/
        if (valor1 <= 1 || valor2 <= 0) throw new ArithmeticException(textos.ERROR_LOGARITMO_NO_DEFINIDO);

        /*Aqui declaramos que miestras nuestra potenciabase sea menor o igual anuestro valor1,
        se multiplicara el valor2 por la potenciabase y el resultado se guardara en la potenciabase;
        agregando un valor a nuestro logaritmo*/
        int logaritmo = 1;
        int multiplicacion;
        int potenciaBase = valor2;
        while (potenciaBase <= valor1){
            multiplicacion = super.calcular(potenciaBase,valor2);
            potenciaBase += multiplicacion;
            logaritmo++;
        }

        /*Aqui definimos que si la potencia de nuestro logaritmo es diferente al valor1, se imprima lo siguiente:*/
        int potencia = 1;
        for (int i = 0; i < logaritmo; i++) {
            potencia = super.calcular(potencia, valor2);
        }
        if (potencia != valor1) {
            System.out.println(textos.APROXIMACION_LOGARITMO);
            System.out.println(textos.ARGUMENTO_EXACTO_LOGARITMO + potencia);
        }

        /*Aqui pedimos que nos imprima el resultado del logaritmo*/
        return logaritmo;
    }
}