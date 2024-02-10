package edu.trino.cardenas.reto3.numeros;

/*Aqui se importa el CLI del package edu.trino.cardenas.reto3.numeros.ui
para poder iniciar la aplicacion*/
import edu.trino.cardenas.reto3.numeros.ui.CLI;
public class Main {
    public static void main(String[] args) {
        try{
            CLI.LaunchApp();
        }catch (Exception e ){
            System.out.println("Error inesperado "+e);
        }
    }
}
