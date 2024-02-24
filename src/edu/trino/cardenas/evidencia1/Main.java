package edu.trino.cardenas.evidencia1;

import edu.trino.cardenas.evidencia1.data.Medicamento;
import edu.trino.cardenas.evidencia1.ui.CLI;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
        try{
            CLI.LaunchApp(listaMedicamentos);
        }catch (Exception e ){
            System.out.println("Error inesperado "+e);
        }
    }
}