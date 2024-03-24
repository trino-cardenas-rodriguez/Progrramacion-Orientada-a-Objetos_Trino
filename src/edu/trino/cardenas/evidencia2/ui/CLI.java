package edu.trino.cardenas.evidencia2.ui;

import edu.trino.cardenas.evidencia2.process.Producto;

import java.util.List;
import java.util.Scanner;

import static edu.trino.cardenas.evidencia2.process.ManejadorProductos.*;

public class CLI {

    /*Aqui declaramos una variable para llamar a las variables de la clase Textos,
    ademas asignadmos el idima español como predeterminado*/
    public static Textos textos = new Spanish();

    /*Este metodo sirve para mostar el menu de idioma al usuario y que pueda elegir el idioma que prefiera.
     Las opciones son las siguientes:
     1- Español
     2- English*/
    public static void showIdiomMenu() {
        System.out.println("------------------Idioma------------------");
        System.out.println("Escoja un idioma (Choose a language)");
        System.out.println("1- Español");
        System.out.println("2- English");
        System.out.println("------------------------------------------");
    }

    /*Este metodo sirve para inicar la aplicacion, mostrando el menu y
    leyendo el idioma que seleccione el usuario; y, en base en esa seleccion,
    poder imprimir los textos en ese idioma; esto utilizando un "switch case".
    Ademas, se pide al usuario que ingrese el usuario y contraseña correctos
    para poder ingresar y, poder mostrarle su saldo a pagar.*/
    public static void launchApp() {
        Scanner scanner = new Scanner(System.in);

        showIdiomMenu();
        int idioma = scanner.nextInt();

    /*Este switch lee la opcion que seleccione el usuario y permite que todos
    los textos que se muestren esten en el idioma seleccionado por el usuario.*/
        switch (idioma) {
            /*Este case se activa cuando el usuario elige la opcion "1" (Español).*/
            case 1:
                textos = new Spanish();
                break;
            /*Este case se activa cuando el usuario elige la opcion "a" (English).*/
            case 2:
                textos = new English();
                break;
        }
        System.out.println();

        System.out.println(textos.INICIO_SECION);

        /*Aqui definimos el usuario y contraseña correctos.*/
        String usuarioCorrecto = "Profe";
        String contrasenaCorrecta = "1234";

        boolean credencialesCorrectas = false;

        /*Este es un ciclo que  le pregunta al usuario el usuario y contraseña, y este
        ciclo se repite hasta que el usuario ingrese el usuario y contraseña correctos.*/
        while (!credencialesCorrectas) {
            System.out.println(textos.USUARIO);
            scanner.nextLine();
            String usuario = scanner.nextLine();
            System.out.println(textos.CONTRASENA);
            String contrasena = scanner.nextLine();

            if(usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecta)){
                credencialesCorrectas = true;
            } else {
                System.out.println(textos.DATOS_INCORRECTOS);
            }
        }

        System.out.println();
        System.out.println(textos.INICIO_EXITOSO);

        // Se genera de manera aleatoria el consumo del usuario (20 productos)
        List<Producto> productosConsumidos = generarProductosAleatorios();

        // Calcular el costo total
        double costoTotal = calcularCostoTotal(productosConsumidos);

        // Mostrar el costo total al usuario
        System.out.println();
        System.out.println(textos.SALDO_PAGAR + costoTotal);
    }
}
