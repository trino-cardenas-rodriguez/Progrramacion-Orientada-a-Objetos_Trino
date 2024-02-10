package edu.trino.cardenas.reto3.diccionario;

import edu.trino.cardenas.reto3.diccionario.process.Diccionario;
import edu.trino.cardenas.reto3.diccionario.ui.CLI;

public class Main {
    public static void main(String[] args) {

        String[] palabras ={"Lampara","Lapiz","Pluma","Lentes","Espejo","Cuchara","Martillo","Luna","Taza","Bicicleta"};
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

        CLI.LaunchApp(diccionario);
    }
}
