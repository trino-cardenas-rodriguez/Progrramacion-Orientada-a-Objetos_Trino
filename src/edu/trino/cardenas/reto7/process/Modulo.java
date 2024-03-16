package edu.trino.cardenas.reto7.process;

public class Modulo extends Resta {
    @Override
    public int calcular(int valor1, int valor2) {
        if (valor2 == 0) throw new ArithmeticException("No es posible dividir entre 0");
        int divicion = 0;
        int residuo = Math.abs(valor1);
        while (residuo >= Math.abs(valor2)) {
            residuo = super.calcular(residuo, valor2);
            divicion++;
        }
        return residuo;
    }
}