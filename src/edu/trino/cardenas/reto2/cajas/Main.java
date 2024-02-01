package edu.trino.cardenas.reto2.cajas;

import edu.trino.cardenas.reto2.cajas.ui.CLI;

public class Main {
    public static void main(String[] args) {
        try{
            CLI.LaunchApp();
        }catch (Exception e ){
            System.out.println("Error inesperado "+e);
        }
    }
}