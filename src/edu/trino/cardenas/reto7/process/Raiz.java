package edu.trino.cardenas.reto7.process;

public class Raiz extends Multiplicacion{
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
        int potencia = 1;
        for (int i = 0; i < 2; i++) {
            potencia = super.calcular(potencia, raiz);
        }
        if (potencia != validacion) {
            System.out.println("Esta raiz es una aproximacion, donde se muestra el valor " +
                    "entero que mas se aproxima a su raiz.");
            System.out.println("El argumento exacto que cumple esta raiz es: " + potencia);
        }
        return raiz;
    }
}
