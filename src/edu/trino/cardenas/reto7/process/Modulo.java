package edu.trino.cardenas.reto7.process;

/*Aqui se importa la variable textos, para poder implimir el
error de dividir entre 0, en el idioma que elija el usuario.*/
import static edu.trino.cardenas.reto7.ui.CLI.textos;

/*Esta calse es una extencion de la clase Resta,
y permite optener el modulo o residuo.*/
public class Modulo extends Resta {

    /*Aqui se sobre escribe el metdo calcular definido en la clase base OperacionAritmetica*/
    @Override
    public int calcular(int valor1, int valor2) {

        /*Aqui declaramos que si nuestro divisor es 0, no se pude realizar la operacion*/
        if (valor2 == 0) throw new ArithmeticException(textos.ERROR_DIVIDIR_ENTRE_0);

        /*Aqui declaramos nuestra variable*/
        int residuo = Math.abs(valor1);

        /*Este es un bucle en donde, mientras el residuo sea mayor o igual a
        nuestro divisor se restara el divisor al dividendo*/
        while (residuo >= Math.abs(valor2)) {
            residuo = super.calcular(residuo, valor2);
        }

        /*Aqui pedimos que nos imprima el residuo*/
        return residuo;
    }
}