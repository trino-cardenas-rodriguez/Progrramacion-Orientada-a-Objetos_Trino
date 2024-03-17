package edu.trino.cardenas.reto7.process;

/*Esta es nuestra calse base y es una clase abstracta en la que se
define un metodo que nos indica que haran las etenciones de esta clase.*/
public abstract class OperacionAritmetica {

    /*Aqui definimos el metodo abstracto de calcular, que se
    sobreescribira en las extenciones de esta clase.*/
    public abstract int calcular(int valor1, int valor2);
}
