package edu.trino.cardenas.evidencia1.ui;

import edu.trino.cardenas.evidencia1.data.Medicamento;
import edu.trino.cardenas.evidencia1.process.GestorMedicamentos;

import java.util.ArrayList;
import java.util.Scanner;

public class CLI {

    public static void LaunchApp(ArrayList<Medicamento> listaMedicamentos){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Hola, por favor inicie sesion.");

        String usuarioCorrecto = "Usuario";
        String contrasenaCorrecta = "Contrasena";

        boolean credencialesCorrectas = false;

        while (!credencialesCorrectas) {
            System.out.println("Ingrese su usuario: ");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            if(usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecta)){
                credencialesCorrectas = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
            }
        }

        System.out.println("Inicio de sesión exitoso, acceso permitido.");
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Bienvenido " + nombre);
        System.out.println("\n------------------------Registro------------------------");

        while (true){
            System.out.println("Ingrese los datos del medicamento que desea registrar." +
                    "\n(Escriba 'salir' para salir del programa).");
            System.out.println("Nombre quimico: ");
            String nombreQuimico = scanner.nextLine().toLowerCase();
            if (nombreQuimico.equalsIgnoreCase("salir")){
                break;
            }

            System.out.println("Nombre generico: ");
            String nombreGenerico = scanner.nextLine();
            System.out.println("Nombre registrado: ");
            String nombreRegistrado = scanner.nextLine();
            System.out.println("Precio al publico: ");
            double precioPublico = Double.parseDouble(scanner.nextLine());

            System.out.println("""
                    Tipos de forma farmaceutica:
                    - Solida: polvos, granulados, cápsulas, comprimidos, sellos,\s
                              tabletas, supositorios, óvulos o implantes.
                    - Semisolida: pomadas, pastas, cremas o geles.
                    - Liquida: soluciones, suspensiones, emulsiones, jarabes,\s
                               elixires, lociones, linimentos o inyectables.""");
            System.out.println("Forma farmaceutica: ");
            String formaFarmaceutica = scanner.nextLine().toLowerCase();

            GestorMedicamentos.agregarMedicamemnto(listaMedicamentos, nombreQuimico, nombreGenerico,
                    nombreRegistrado, precioPublico, formaFarmaceutica);
        }

        GestorMedicamentos.generarReporte(nombre, listaMedicamentos);

    }
}
