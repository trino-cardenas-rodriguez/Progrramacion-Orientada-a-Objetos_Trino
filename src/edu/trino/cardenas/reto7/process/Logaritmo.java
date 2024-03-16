package edu.trino.cardenas.reto7.process;

public class Logaritmo extends Multiplicacion{
    @Override
    public int calcular(int valor1, int valor2) {
        if (valor1 <= 1 || valor2 <= 0) throw new ArithmeticException(
                "El logaritmo no está definido para los valores proporcionados");
        int logaritmo = 1;
        int multiplicacion;
        int potenciaBase = valor2;
        while (potenciaBase <= valor1){
            multiplicacion = super.calcular(potenciaBase,valor2);
            potenciaBase += multiplicacion;
            logaritmo++;
        }
        int potencia = 1;
        for (int i = 0; i < logaritmo; i++) {
            potencia = super.calcular(potencia, valor2);
        }
        if (potencia != valor1) {
            System.out.println("Este logaritmo es una aproximacion, donde se muestra el valor " +
                    "entero que mas se aproxima a su logaritmo.");
            System.out.println("El argumento exacto que cumple este logaritmo es: " + potencia);
        }
        return logaritmo;
    }
}