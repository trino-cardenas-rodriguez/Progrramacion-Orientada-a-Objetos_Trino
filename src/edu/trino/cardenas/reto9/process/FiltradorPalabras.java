package edu.trino.cardenas.reto9.process;

/**Aquí importamos la clase Idiomas, para usar poder imprimir excepciones en el idioma que indique el usuario.*/
import edu.trino.cardenas.reto9.ui.Idiomas;

/**Aquí importamos la función InputStream*/
import java.io.InputStream;

/**Aquí importamos la función Normalizer*/
import java.text.Normalizer;

/**Aquí importamos la librería until de java para poder usarla.*/
import java.util.*;

/**Aquí importamos los collectors de stream de la librería java.until, para poder usarlos.*/
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

/**Esta clase sirve para filtrar las palabras del libro seleccionado, pasando por los distintos filtros definidos.*/
public class FiltradorPalabras {

    /**Este método sirve para contar las palabras dentro de un HashMap,
    viendo asi cuáles se repiten por su dirección.*/
    public List<Map.Entry<String, Integer>> contarPalabras(String nombreArchivo) {
        Map<String, Integer> conteoPalabras = new HashMap<>();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream
                    ("edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                fileScanner.useDelimiter("[^a-zA-Z]+"); // Delimitador para separar palabras
                while (fileScanner.hasNext()) {
                    String palabra = fileScanner.next().toLowerCase();
                    palabra = Normalizer.normalize(palabra, Normalizer.Form.NFD).replaceAll
                            ("[^\\p{ASCII}]", ""); // Remover acentos
                    if (!palabra.isEmpty()) {
                        conteoPalabras.put(palabra, conteoPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
                fileScanner.close();
            } else {
                System.out.println(Idiomas.ARCHIVO_NO_ENCONTRADO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conteoPalabras.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
    }

    /**Este método cuenta todas las vocales del libro seleccionado.*/
    public long contarVocales(String nombreArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                    "edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                return fileScanner.findAll("[aeiou]").count();
            } else {
                System.out.println(Idiomas.ARCHIVO_NO_ENCONTRADO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**Este método filtra e imprime todas las palabras que empiezan con vocal.*/
    public void imprimirPalabrasQueEmpiezanConVocal(String nombreArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                    "edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                fileScanner.findAll("\\b[aeiouAEIOU]\\w*")
                        .map(MatchResult::group)
                        .map(String::toLowerCase)
                        .distinct()
                        .sorted()
                        .forEach(System.out::println);
            } else {
                System.out.println(Idiomas.ARCHIVO_NO_ENCONTRADO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Este método filtra e imprime todas las palabras que tienen un número impar de letras.*/
    public void imprimirPalabrasConNumeroImparDeLetras(String nombreArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                    "edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                fileScanner.findAll("\\b[a-zA-Z]{1,}[aeiouAEIOU]\\b")
                        .map(MatchResult::group)
                        .map(String::toLowerCase)
                        .filter(s -> s.length() % 2 != 0)
                        .distinct()
                        .forEach(System.out::println);
            } else {
                System.out.println(Idiomas.ARCHIVO_NO_ENCONTRADO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Este método busca e imprime la palabra más larga del libro seleccionado.*/
    public String encontrarPalabraMasLarga(String nombreArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                return fileScanner.findAll("\\b[a-zA-Z]+\\b")
                        .map(MatchResult::group)
                        .map(String::toLowerCase)
                        .max(Comparator.comparingInt(String::length))
                        .orElse(null);
            } else {
                System.out.println(Idiomas.ARCHIVO_NO_ENCONTRADO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**Este método busca e imprime la palabra más larga del libro seleccionado.*/
    public static String encontrarPalabraMasCorta(List<String> palabras) {
        return palabras.stream()
                .min(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    /**Este método filtra todas las palabras que inicien y terminen con vocal;
     * además de que tengan menos de 5 letras.*/
    public static List<String> filtroPalabraEspecial(List<String> palabras) {
        return palabras.stream()
                .filter(p -> p.matches("^[aeiouAEIOU].*[aeiouAEIOU]$") && p.length() >= 5)
                .collect(Collectors.toList());
    }

}
