package edu.trino.cardenas.reto7.process;

/*Esta calse es una extencion de la clase Suma,
y permite hacer la operacion de Multiplicacion*/
public class Multiplicacion extends Suma{

    /*Aqui se sobre escribe el metdo calcular definido en la clase base OperacionAritmetica*/
    @Override
    public int calcular(int valor1, int valor2) {

        /*Aqui declaramos nuestra variable que guardara el valor de la multiplicacion.*/
        int multiplicacion = 0;

        /*Aqui decimos que por cada valor que tenag nuestro valor2, se
        sumara a nuestra variable multiplicacion nuestro valor1*/
        for (int i = 0; i < Math.abs(valor2); i++) {
            multiplicacion = super.calcular(multiplicacion, Math.abs(valor1));
        }

        /*Aqui evaluamos si alguno de los valores es negativo (menor que 0), y el otro no;
         nuestro resultado sea negativo*/
        if ((valor1 < 0 && valor2 > 0) || (valor1 > 0 && valor2 < 0)) {
            multiplicacion = -multiplicacion;
        }

        /*Aqui pedimos que nos imprima el resultado de la division*/
        return multiplicacion;
    }
}
