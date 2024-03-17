package edu.trino.cardenas.reto7.process;

/*Esta calse es una extencion de la clase Multiplicacion,
y permite hacer la operacion de raiz*/
public class Raiz extends Multiplicacion{

    /*Aqui se sobre escribe el metdo calcular definido en la clase base OperacionAritmetica*/
    @Override
    public int calcular(int valor1, int valor2) {
        if (valor1 < 0) throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
        int raiz = 0;
        int incremento = 1;
        int validacion = valor1;


        while (valor1 > 0) {
            valor1 -= incremento;
            incremento += 2;
            if (valor1 >= 0) raiz++;
        }

        /*Aqui definimos que si la potencia de nuestra raiz es diferente al valor1, se imprima lo siguiente:*/
        int potencia = 1;
        for (int i = 0; i < 2; i++) {
            potencia = super.calcular(potencia, raiz);
        }
        if (potencia != validacion) {
            System.out.println("Esta raiz es una aproximacion, donde se muestra el valor " +
                    "entero que mas se aproxima a su raiz.");
            System.out.println("El argumento exacto que cumple esta raiz es: " + potencia);
        }

        /*Aqui pedimos que nos imprima el resultado del logaritmo*/
        return raiz;
    }
}
