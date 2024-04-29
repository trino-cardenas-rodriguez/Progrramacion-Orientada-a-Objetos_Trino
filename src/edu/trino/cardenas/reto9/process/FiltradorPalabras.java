package edu.trino.cardenas.reto9.process;

/**Aquí importamos la clase Idiomas, para usar poder imprimir excepciones en el idioma que indique el usuario.*/
import edu.trino.cardenas.reto9.ui.Idiomas;

/**Aquí importamos la java.until.io, para poder usar la función InputStream y la excepción FileNotFoundException*/
import java.io.*;

/**Aquí importamos la librería until de java para poder usarla.*/
import java.util.*;

/**Aquí importamos el Consumer de la librería java.until.function, para poder usarlo.*/
import java.util.function.Consumer;

/**Aquí importamos la librería java.until.regrex, para poder usar el Pattern y el MarchResult.*/
import java.util.regex.*;

/**Aquí importamos los collectors de stream de la librería java.until.stream, para poder usarlos.*/
import java.util.stream.Collectors;

/**Esta clase sirve para filtrar las palabras del libro seleccionado, pasando por los distintos filtros definidos.*/
public class FiltradorPalabras {

    /**Este método sirve para contar las palabras dentro de un HashMap,
    viendo asi cuáles se repiten por su dirección.*/
    public Consumer<String> mostrarTop10Palabras = (nombreArchivo) -> {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream
                    ("edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                Map<String, Integer> frecuenciaPalabras = new HashMap<>();

                while (fileScanner.hasNext()) {
                    String palabra = fileScanner.next()
                            .replaceAll("[^a-zA-Z]", "")
                            .toLowerCase();
                    frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                }

                frecuenciaPalabras.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(10)
                        .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

            } else {
                throw new FileNotFoundException(Idiomas.ARCHIVO_NO_ENCONTRADO);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();

        }
    };

    /**Este método cuenta todas las vocales del libro seleccionado.*/
    public long contarVocales(String nombreArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                    "edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                return fileScanner.findAll("[aeiouAEIOUáéíóúÁÉÍÓÚ]").count();
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
            throw new IllegalArgumentException(Idiomas.ERROR_INESPERADO, e);
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
                        .sorted()
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

    /**Este método busca e imprime la palabra más corta del libro seleccionado.*/
    public String encontrarPalabraMasCorta(String nombreArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                return fileScanner.findAll("\\b[a-zA-Z]\\b")
                        .map(MatchResult::group)
                        .map(String::toLowerCase)
                        .min(Comparator.comparingInt(String::length))
                        .orElse(null);
            } else {
                System.out.println(Idiomas.ARCHIVO_NO_ENCONTRADO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**Este método filtra todas las palabras que inicien y terminen con vocal;
     * además de que tengan menos de 5 letras.*/
    public String filtroPalabraEspecial(String nombreArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("edu/trino/cardenas/reto9/resources/" + nombreArchivo);
            if (inputStream != null) {
                Scanner fileScanner = new Scanner(inputStream);
                String contenido = fileScanner.useDelimiter("\\A").next();
                String contenidoFiltrado = contenido.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
                Set<String> palabrasUnicas = new HashSet<>();
                        Pattern.compile("\\b[aieou][a-zA-Z]{3,10}[aieou]\\b")
                        .matcher(contenidoFiltrado)
                        .results()
                        .map(MatchResult::group)
                        .forEach(palabrasUnicas::add);
                if (palabrasUnicas.isEmpty()) {
                    throw new Exception(Idiomas.NO_HAY_PALABRAS + nombreArchivo + Idiomas.CUMPLAN_CONDICION);
                }
                return palabrasUnicas.stream()
                        .sorted()
                        .collect(Collectors.joining("\n"));
            } else {
                throw new Exception(Idiomas.ARCHIVO_NO_ENCONTRADO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
