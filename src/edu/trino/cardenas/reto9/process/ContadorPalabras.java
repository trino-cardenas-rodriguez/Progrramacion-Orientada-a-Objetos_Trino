package edu.trino.cardenas.reto9.process;

import java.io.InputStream;
import java.text.Normalizer;
import java.util.*;

import static edu.trino.cardenas.reto9.process.OrganizadorPalabras.organizarPalabras;

public class ContadorPalabras {
    public static List<Map.Entry<String, Integer>> contarPalabras(String nombreArchivo) {
        Map<String, Integer> conteoPalabras = new HashMap<>();

        try {
            InputStream inputStream = ContadorPalabras.class.getClassLoader().getResourceAsStream
                    ("resources/" + nombreArchivo);
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
                System.out.println("Archivo no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return organizarPalabras(conteoPalabras);
    }
}
