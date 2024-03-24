package edu.trino.cardenas.reto7;

/*Aqui se importa la variable textos, para que cuando se detecte un error,
 se pueda imprimir el mensaje en el idioma que elija el usuario.*/
import static edu.trino.cardenas.reto7.ui.CLI.textos;

/*Aqui se importa el CLI del package edu.trino.cardenas.reto7.ui
para poder iniciar la calculadora.*/
import edu.trino.cardenas.reto7.ui.CLI;

/*Esta clase sirve para llamar el metodo que incia la aplicacion;
ademas de que muestra un error concreto al usuario en dado caso de
que ingrese un valor inesperado.*/
public class Main {
    public static void main(String[] args) {
        try{
            CLI.launchCalculadora();
        }catch (Exception e ){
            System.out.println(textos.ERROR_INESPERADO +e);
        }
    }
}
