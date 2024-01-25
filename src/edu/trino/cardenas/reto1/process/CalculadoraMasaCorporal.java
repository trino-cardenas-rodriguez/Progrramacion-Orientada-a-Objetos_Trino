package edu.trino.cardenas.reto1.process;
/**
 * Esta clase sirve para realizar calculos de masa corporal incluye los metodos:
 * Calculo de masa corporal
 * Calculo de masa corporal magra
 * Calculo de metabolismo basal
 */
public class CalculadoraMasaCorporal {
    /**
     * Este metodo sirve para realizar el calculo de masa corporal del usuario
     * con base en el peso y estatura que ingrese
     * @param estatura estatura del usuario en centimetros
     * @param peso del usuario en kilogramos
     * @return calculo de masa corporal
     */
    public static double calcularIndiceMasaCorporal(double estatura, double peso){
        return peso/((estatura/100)*(estatura/100));
    }

    public static String clasificarIndiceMasaCorporal(Double imc) {
        String value = "";
        if (imc<18.9){
            value = "peso bajo";
        }else if(imc<=24.99) {
            value = "peso normal";
        }else if(imc<=29.99) {
            value = "sobrepeso";
        }else if(imc<=34.99) {
            value = "obesidad leve";
        }else if(imc<=39.99) {
            value = "obesidad media";
        }else if(imc>=40.0) {
            value = "obesidad mórbida";
        }
        return value;
    }

    public static double calcularIndiceMasaCorporalMagra(double estatura, double peso){
        return peso/((estatura/100)*(estatura/100));
    }
}

