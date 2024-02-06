package edu.trino.cardenas.reto2.cajas;

/*Aqui se importa el CLI del package edu.trino.cardenas.reto2.cajas.ui
para poder iniciar la aplicacion*/
import edu.trino.cardenas.reto2.cajas.ui.CLI;

/*Esta clase sirve para llamar el metodo que incia la aplicacion;
ademas de que muestra un error concreto al usuario en dado caso de
que ingrese un valor inesperado.*/
public class Main {
    public static void main(String[] args) {
        try{
            CLI.LaunchApp();
        }catch (Exception e ){
            System.out.println("Error inesperado "+e);
        }
    }
}