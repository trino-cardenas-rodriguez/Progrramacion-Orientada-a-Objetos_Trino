package edu.trino.cardenas.evidencia1.ui;

/*Aqui se importa la clase Medicamento de la carpeta data del package
edu.trino.cardenas.evidencia1.data para poder utilizar el constructor Medicamento.*/
import edu.trino.cardenas.evidencia1.data.Medicamento;

/*Aqui se importa la clase GestorMedicamentos de la carpeta process del package
edu.trino.cardenas.evidencia1.process para poder utilizar los metodos que
estan dentro de esta clase.*/
import edu.trino.cardenas.evidencia1.process.GestorMedicamentos;

//Aqui se importa ArrayList de java para poder utilizarlo.
import java.util.ArrayList;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

/*Esta clase nos permite solicitarle al usuario el usuario y contraseña correctos para
poder darle acceso a la aplicacion; ademas permite que el usuario registre medicamentos
y, cuando el usuario quiera salir, se le muestre un reporte de los medicamentos regsitrados.*/
public class CLI {

    /*Este metodo sirve para iniciar la aplicacion, pidiendo al usuario que ingrese el usuario
    y contraseña correctos para poder ingresar y comenzar a registrar medicamentos hasta que
    indique salir para terminar la aplicacion y mostrar un reporte de los medicamentos regsitrados.*/
    public static void LaunchApp(ArrayList<Medicamento> listaMedicamentos){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Hola, por favor inicie sesion.");

        //Aqui definimos el usuario y contraseña correctos.
        String usuarioCorrecto = "Usuario";
        String contrasenaCorrecta = "Contrasena";

        boolean credencialesCorrectas = false;

        /*Este es un ciclo que  le pregunta al usuario el usuario y contraseña, y este
        ciclo se repite hasta que el usuario ingrese el usuario y contraseña correctos.*/
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

        /*Este ciclo permite que el usuario registre un medicamento y que este se guarde
        en el ArrayList, repitiendo este procedimiento hasta que el usuario indique salir.*/
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

            //Aqui se agrega el medicamento registrado al ArrayList.
            GestorMedicamentos.agregarMedicamemnto(listaMedicamentos, nombreQuimico, nombreGenerico,
                    nombreRegistrado, precioPublico, formaFarmaceutica);
        }

        //Aqui se imprime el reporte generado con los medicamentos registrados.
        GestorMedicamentos.generarReporte(nombre, listaMedicamentos);

    }
}
