package edu.trino.cardenas.reto7.process;

public class Multiplicacion extends Suma{
    @Override
    public int calcular(int valor1, int valor2) {
        int multiplicacion = 0;
        for (int i = 0; i < Math.abs(valor2); i++) {
            multiplicacion = super.calcular(multiplicacion, Math.abs(valor1));
        }
        if ((valor1 < 0 && valor2 > 0) || (valor1 > 0 && valor2 < 0)) {
            multiplicacion = -multiplicacion;
        }
        return multiplicacion;
    }
}
