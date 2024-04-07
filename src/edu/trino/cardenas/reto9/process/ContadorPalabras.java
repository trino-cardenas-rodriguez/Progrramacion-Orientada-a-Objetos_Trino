package edu.trino.cardenas.reto9.process;

/*Aqui importamos la funcion InputStream*/
import java.io.InputStream;

/*Aqui importamos la funcion Normalizer*/
import java.text.Normalizer;

/*Aqui importamos la libreria until de java para poder usarla.*/
import java.util.*;

/*Aqui importamos la clase OrganizadorPalabras, para usar el metodo que organiza las palabras.*/
import static edu.trino.cardenas.reto9.process.OrganizadorPalabras.organizarPalabras;

/*Esta clase sirve para contar las palabras del libro seleccionado.*/
public class ContadorPalabras {

    /*Este metodo sirve para contar las palabras dentro de un HashMap,
    viendo asi cuales se repiten por su direccion.*/
    public static List<Map.Entry<String, Integer>> contarPalabras(String nombreArchivo) {
        Map<String, Integer> conteoPalabras = new HashMap<>();

        try {
            InputStream inputStream = ContadorPalabras.class.getClassLoader().getResourceAsStream
                    ( "edu/trino/cardenas/reto9/resources/"+ nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                while (fileScanner.hasNext()) {
                    String palabra = fileScanner.next().toLowerCase();
                    palabra = Normalizer.normalize(palabra, Normalizer.Form.NFD).replaceAll
                            ("[^\\p{ASCII}]", ""); // Remover acentos
                    palabra = palabra.replaceAll("[^a-zA-Z]", ""); // Remover caracteres no alfabéticos
                    if (!palabra.isEmpty()) {
                        conteoPalabras.put(palabra, conteoPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
                fileScanner.close();
            } else {
                throw new IllegalArgumentException("Archivo no encontrado / File not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return organizarPalabras(conteoPalabras);
    }
}
