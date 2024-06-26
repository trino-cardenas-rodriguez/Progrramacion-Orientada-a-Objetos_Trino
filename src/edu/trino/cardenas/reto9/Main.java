package edu.trino.cardenas.reto9;

/**Aquí se importa el CLI del package edu.trino.cardenas.reto9.ui
para poder iniciar la calculadora.*/
import edu.trino.cardenas.reto9.ui.CLI;

/**Aquí importamos la clase Idiomas, para usar poder imprimir el error en el idioma que indique el usuario.*/
import edu.trino.cardenas.reto9.ui.Idiomas;

/**Esta clase sirve para llamar el método que inicia la aplicación;
además de que muestra un error concreto al usuario en dado caso de
que ingrese un valor inesperado.*/
public class Main {
    public static void main(String[] args) {
        try{
            CLI.launchApp();
        }catch (Exception e ){
            System.out.println(Idiomas.ERROR_INESPERADO +e);
        }
    }
}
