package edu.trino.cardenas.evidencia1;

/*Aqui se importa la clase Medicamento de la carpeta data del package
edu.trino.cardenas.evidencia1.data para poder declarar el ArrayList que guardara los medicamentos.*/
import edu.trino.cardenas.evidencia1.data.Medicamento;

/*Aqui se importa el CLI del package edu.trino.cardenas.evidencia1.ui
para poder iniciar la aplicacion*/
import edu.trino.cardenas.evidencia1.ui.CLI;

//Aqui se importa ArrayList de java para poder utilizarlo.
import java.util.ArrayList;

/*Esta clase sirve para llamar el metodo que incia la aplicacion;
ademas de que muestra un error concreto al usuario en dado caso de
que ingrese un valor inesperado; y dentro de este metodo se
declara el ArrayList que guardara los medicamentos.*/
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