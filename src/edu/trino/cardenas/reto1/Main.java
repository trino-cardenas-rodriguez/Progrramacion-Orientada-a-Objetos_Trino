package edu.trino.cardenas.reto1;

import edu.trino.cardenas.reto1.ui.CLI;
public class Main {
    public static void main(String[] args) {
        try{
            CLI.LaunchCalculator();
        }catch (Exception e ){
            System.out.println("error inesperado"+e);
        }
    }
}
