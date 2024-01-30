package edu.trino.cardenas.reto1;

/**
 * Aqui se importa el CLI del package edu.trino.cardenas.reto1.ui,
 * para poder iniciar la calculadora.
 */
import edu.trino.cardenas.reto1.ui.CLI;

/**
 * Esta clase sirve para llamar el metodo que incia la calculadora;
 * ademas de que muestra un error concreto al usuario en dado caso de que ingrese
 * un valor inesperado.
 */
public class Main {
    public static void main(String[] args) {
        try{
            CLI.LaunchCalculator();
        }catch (Exception e ){
            System.out.println("Error inesperado "+e);
        }
    }
}
