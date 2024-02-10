package edu.trino.cardenas.reto3.diccionario;

/*Aqui se importa el Diccionario del package edu.trino.cardenas.reto3.diccionario.process,
para poder declarar las palabras y su significado dentro del diccionario.*/
import edu.trino.cardenas.reto3.diccionario.process.Diccionario;

/*Aqui se importa el CLI del package edu.trino.cardenas.reto3.diccionario.ui,
para poder iniciar la aplicacion.*/
import edu.trino.cardenas.reto3.diccionario.ui.CLI;

/*Esta clase sirve para declarar las palabras y sus significados en el diccionario,
tambien para llamar el metodo que incia el diccionario; ademas de que muestra un error
concreto al usuario en dado caso de que ingrese un valor inesperado.*/
public class Main {
    public static void main(String[] args) {

        /*Aqui se definen los arreglos de las palabras y sus significados para poder
        utilizarlos en el codigo.*/
        String[] palabras ={"Lampara","Lapiz","Pluma","Lentes","Espejo",
                "Cuchara","Martillo","Luna","Taza","Bicicleta"};
        String[] significados ={"Dispositivo para producir luz artificial.",
                "Instrumento de escritura con grafito",
                "Instrumento de escritura con tinta.",
                "Dispositivo óptico para corregir la visión.",
                "Superficie reflectante que muestra la imagen de los objetos.",
                "Utensilio para servir o consumir alimentos líquidos.",
                "Herramienta para golpear y clavar objetos.",
                "Satélite natural de la Tierra que refleja la luz solar.",
                "Recipiente con asa utilizado para beber líquidos.",
                "Vehículo de dos ruedas impulsado por pedales."};

        Diccionario diccionario = new Diccionario(palabras, significados);

        /*Este es el corta fuegos que reconoce cuando el usuario introduce
        un caracter inesperado y manda un error, sin mostrar el codigo.*/
        try{
            CLI.LaunchDiccionario(diccionario);
        }catch (Exception e ){
            System.out.println("Error inesperado "+e);
        }

    }
}
