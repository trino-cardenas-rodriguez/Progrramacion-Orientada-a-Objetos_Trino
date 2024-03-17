package edu.trino.cardenas.reto7.process;

/*Esta calse es una extencion de la clase base OperacionAritmetica,
y permite hacer la operacion de sumar*/
public class Suma extends OperacionAritmetica{

    /*Aqui se sobreescribe el metodo calcular definido en la clase base OperacionAritmetica;
    haciedno que este sume los valores que ingrese el usuario.*/
    @Override
    public int calcular(int valor1, int valor2) {

        /*Aqui definimos el procedimiento de la operacion suma*/
        return valor1 + valor2;
    }
}
