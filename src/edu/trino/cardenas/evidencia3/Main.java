package edu.trino.cardenas.evidencia3;

/**Aquí se importa el CLI del package edu.trino.cardenas.evidencia3.ui
 para poder iniciar el juego.*/
import edu.trino.cardenas.evidencia3.ui.CLI;

/**Aquí importamos la clase Idiomas, para usar poder imprimir el error en el idioma que indique el usuario.*/
import edu.trino.cardenas.evidencia3.ui.Idiomas;

/**Esta clase sirve para llamar el método que inicia la aplicación;
 además de que muestra un error concreto al usuario en dado caso de
 que ingrese un valor inesperado.*/
public class Main {
    public static void main(String[] args) {
        try{
            CLI.launchGame();
        }catch (Exception e ){
            System.out.println(Idiomas.ERROR_INESPERADO +e);
        }
    }
}
