package edu.trino.cardenas.reto7.process;

public class Potencia extends Multiplicacion{
    @Override
    public int calcular(int valor1, int valor2) {
        if (valor2 < 0) throw new ArithmeticException("El exponente " +
                "no puede ser negativo para calcular la potencia");
        int potencia = 1;
        for (int i = 0; i < Math.abs(valor2); i++) {
            potencia = super.calcular(potencia, Math.abs(valor1));
        }
        int residuo = Math.abs(valor2);
        while (residuo >= 2) {
            residuo -= 2;
        }
        if (valor1 < 0 && residuo != 0) {
            potencia = -potencia;
        }
        return potencia;
    }
}