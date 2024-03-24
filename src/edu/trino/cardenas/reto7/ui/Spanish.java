package edu.trino.cardenas.reto7.ui;

/*Esta es una clase que hereda los atributos de la clase base Textos.*/
public class Spanish extends Textos{

    /*Aqui declaramos las variables de la clase base con los textos en español, las
    cuales se usaran predeterminadamente o si el usuario lo indica.*/
    public Spanish() {
        CALCULADORA = "------------------Calculadora------------------";
        ELECCION = "Elija la operacion que desea realizar:";
        SUMA = "a. Suma";
        RESTA = "b. Resta";
        MULTIPLICACION = "c. Multiplicacion";
        DIVISION = "d. Division";
        MODULO = "e. Modulo";
        POTENCIA = "f. Potencia";
        RAIZ = "g. Raiz";
        LOGARITMO = "h. Logaritmo";

        SUMANDO1 = "Ingrese el primer sumando";
        SUMANDO2 = "Ingrese el segundo sumando";

        MINUENDO = "Ingrese el minuendo";
        SUSTRAENDO = "Ingrese el sustraendo";

        MULTIPLICANDO = "Ingrese el multiplicando";
        MULTIPLICADOR = "Ingrese el multiplicador";

        DIVIDENDO = "Ingrese el dividendo";
        DIVISOR = "Ingrese el divisor";

        BASE = "Ingrese el valor de la base";
        EXPONENTE = "Ingrese el valor del exponente";

        RADICAL = "Ingrese el valor del radical";
        INDICE = "Ingrese el valor del indice";

        ARGUMENTO = "Ingrese el valor del argumento";

        DATO_NO_VALIDO = "\nDato no valido: ";
        REINICIE = "\nReinicie";

        RESULTADO = "El resultado de su ";
        ES = " es: ";

        ERROR_DIVIDIR_ENTRE_0 = "No es posible dividir entre 0";

        ERROR_LOGARITMO_NO_DEFINIDO = "El logaritmo no está definido para los valores proporcionados";
        APROXIMACION_LOGARITMO = "Este logaritmo es una aproximacion, donde se muestra " +
                "el valor entero que mas se aproxima a su logaritmo.";
        ARGUMENTO_EXACTO_LOGARITMO = "El argumento exacto que cumple este logaritmo es: ";

        ERROR_EXPONETE_NEGATIVO = "El exponente no puede ser negativo para calcular la potencia";

        ERROR_RADICAL_NEGATIVO = "No se puede calcular la raíz de un radical negativo";
        ERROR_INDICE_NEGATIVO = "No se puede calcular la raíz con un indice negativo";
        APROXIMACION_RAIZ = "Esta raiz es una aproximacion, donde se muestra el valor " +
                "entero que mas se aproxima a su raiz.";
        RADICAL_EXACTO_RAIZ = "El radical exacto que cumple esta raiz es: ";

        ERROR_INESPERADO = "Error inesperado ";
    }
}
