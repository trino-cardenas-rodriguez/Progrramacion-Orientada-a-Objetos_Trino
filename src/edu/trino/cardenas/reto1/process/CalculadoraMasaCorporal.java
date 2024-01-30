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
     * con base en el peso y estatura que ingrese.
     * @param estatura estatura del usuario en centimetros
     * @param peso del usuario en kilogramos
     * @return calculo de masa corporal
     */
    public static double calcularIndiceMasaCorporal(double estatura, double peso){
        return peso/((estatura/100)*(estatura/100));
    }

    /**
     * Este metodo sirve para realizar la clasificaion del estado del usuario;
     * dependiendo del resultado de su masa corporal,
     * calculada con el peso y estatura que previamente ingreso.
     * @param indiceMasaCorporal del usuario (previamente calculado)
     * @return calculo de masa corporal
     */
    public static String clasificarIndiceMasaCorporal(Double indiceMasaCorporal) {
        String value = "";
        if (indiceMasaCorporal<18.9){
            value = "peso bajo";
        }else if(indiceMasaCorporal<=24.99) {
            value = "peso normal";
        }else if(indiceMasaCorporal<=29.99) {
            value = "sobrepeso";
        }else if(indiceMasaCorporal<=34.99) {
            value = "obesidad leve";
        }else if(indiceMasaCorporal<=39.99) {
            value = "obesidad media";
        }else if(indiceMasaCorporal>=40.0) {
            value = "obesidad mórbida";
        }
        return value;
    }

    /**
     * Este metodo sirve para realizar el calculo de masa corporal magra del usuario
     * con base en el peso, estatura y sexo que ingrese.
     * @param estatura estatura del usuario en centimetros
     * @param peso del usuario en kilogramos
     * @param sexo del usuario (hombre o mujer)
     * @return calculo de masa corporal magra
     */
    public static double calcularIndiceMasaCorporalMagra(double estatura, double peso, double sexo){
        double value = 0;
        if (sexo == 1) {
            value = (1.10*peso)-128*((peso*peso)/(estatura*estatura));
        }else if (sexo == 2) {
            value = (1.07*peso)-148*((peso*peso)/(estatura*estatura));
        }else {
            System.out.println("Dato no valido, reinicie");
        }
        return value;

    }

    /**
     * Este metodo sirve para realizar el calculo del metabolismo basal del usuario
     * con base en el peso, estatura, sexo y edad que ingrese.
     * @param estatura estatura del usuario en centimetros
     * @param peso del usuario en kilogramos
     * @param sexo del usuario (hombre o mujer)
     * @param edad del usuaro en años
     * @return calculo de metabolismo basal
     */
    public static double calcularIndiceMetabolismoBasal(double estatura, double peso, double sexo, double edad){
        double value = 0;
        if (sexo == 1) {
            value = 66.5+(13.75 * peso)+ (5.003 * estatura)- (6.775 * edad);
        }else if (sexo == 2) {
            value = 655.1+(9.563 * peso)+ (1.85 * estatura)- (4.676 * edad);
        }else {
            System.out.println("Dato no valido, reinicie");
        }
        return value;

    }
}

