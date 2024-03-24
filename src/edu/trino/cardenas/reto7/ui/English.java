package edu.trino.cardenas.reto7.ui;

/*Esta es una clase que hereda los atributos de la clase base Textos.*/
public class English extends Textos{

    /*Aqui declaramos las variables de la clase base con los textos en ingles, las
    cuales cuando el usuario seleccione el idioma ingles.*/
    public English (){
        CALCULADORA = "------------------Calculator------------------";
        ELECCION = "Choose the operation you need to perform:";
        SUMA = "a. Sum";
        RESTA = "b. Subtract";
        MULTIPLICACION = "c. Multiplication";
        DIVISION = "d. Division";
        MODULO = "e. Module";
        POTENCIA = "f. Power";
        RAIZ = "g. Root";
        LOGARITMO = "h. Logarithm";

        SUMANDO1 = "Enter the first summand";
        SUMANDO2 = "Enter the second summand";

        MINUENDO = "Enter the minuend";
        SUSTRAENDO = "Enter the subtrahend";

        MULTIPLICANDO = "Enter the multiplicand";
        MULTIPLICADOR = "Enter the multiplier";

        DIVIDENDO = "Enter the dividend";
        DIVISOR = "Enter the divisor";

        BASE = "Enter the value of the base";
        EXPONENTE = "Enter the value of the exponent";

        RADICAL = "Enter the value of the radical";
        INDICE = "Enter the value of the index";

        ARGUMENTO = "Enter the value of the argument";

        DATO_NO_VALIDO = "Invalid data: ";
        REINICIE = "\nReinitialise";

        RESULTADO = "The result of your ";
        ES = " is: ";

        ERROR_DIVIDIR_ENTRE_0 = "It is not possible to divide by 0";

        ERROR_LOGARITMO_NO_DEFINIDO ="The logarithm is not defined for the values provided";
        APROXIMACION_LOGARITMO = "This logarithm is an approximation, where the integer value " +
                "that most closely approximates to your logarithm is shown";
        ARGUMENTO_EXACTO_LOGARITMO = "The exact argument that complies with this logarithm is: ";

        ERROR_EXPONETE_NEGATIVO = "The exponent cannot be negative to calculate the power";

        ERROR_RADICAL_NEGATIVO = "You cannot calculate the root of a negative radical";
        ERROR_INDICE_NEGATIVO = "You cannot calculate the root with a negative index";
        APROXIMACION_RAIZ = ("This root is an approximation, where the integer value " +
                "that most closely approximates to your root is displayed");
        RADICAL_EXACTO_RAIZ = "The exact radical that complies with this root is: ";
    }
}
