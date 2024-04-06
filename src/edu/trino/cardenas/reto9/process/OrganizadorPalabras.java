package edu.trino.cardenas.reto9.process;

import java.util.*;

public class OrganizadorPalabras {
    public static List<Map.Entry<String, Integer>> organizarPalabras(Map<String, Integer> conteoPalabras) {
        List<Map.Entry<String, Integer>> listaPalabras = new ArrayList<>(conteoPalabras.entrySet());
        listaPalabras.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return listaPalabras;
    }
}
