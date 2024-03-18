package edu.trino.cardenas.reto7.process;

/*Esta calse es una extencion de la clase Multiplicacion,
y permite hacer la operacion de potencia*/
public class Potencia extends Multiplicacion{

    /*Aqui se sobre escribe el metdo calcular definido en la clase base OperacionAritmetica*/
    @Override
    public int calcular(int valor1, int valor2) {


        /*Aqui declaramos que si nuestro exponente es negativo, no se pude realizar la operacion*/
        if (valor2 < 0) throw new ArithmeticException("El exponente " +
                "no puede ser negativo para calcular la potencia");


        /*Aqui indicamos que por cada valor en valor2, se multiplique el valor1 por
        nuestra potencia y se guarde en la potencia*/
        int potencia = 1;
        for (int i = 0; i < Math.abs(valor2); i++) {
            potencia = super.calcular(potencia, Math.abs(valor1));
        }

        /*Aqui dividimos nuestro valor2, para saber si es par o impar*/
        int residuo = Math.abs(valor2);
        while (residuo >= 2) {
            residuo -= 2;
        }

        /*Aqui declaramos que si el valor1 es negativo y el valor2 es impar, nuestro resultado sera negativo*/
        if (valor1 < 0 && residuo != 0) {
            potencia = -potencia;
        }

        /*Aqui pedimos que nos imprima el resultado de la potencia*/
        return potencia;
    }
}