package edu.trino.cardenas.reto6.ui;

/*Aqui se importan los datos de las clases contenidas en la carpeta data y
los procesos de la clase ManejadorSueldos, contenida en la carpeta process.*/
import edu.trino.cardenas.reto6.data.Categoria;
import edu.trino.cardenas.reto6.data.DiferenciarCategorias;
import edu.trino.cardenas.reto6.data.Empleado;
import edu.trino.cardenas.reto6.process.GenerardorReporte;

//Aqui se importa ArrayList de java para poder utilizarlo.
import java.util.ArrayList;

//Aqui se importa el scanner de java para poder reconocer los datos que ingrese el ususario.
import java.util.Scanner;

/*Esta clase nos permite iniciar la aplicacion y permite que el usuario realice el registro
de los empleados, ademas de que le genera un reporte al terminar la interaccion.*/
public class CLI {

    public static void launchApp() {
        Scanner scanner = new Scanner(System.in);

        //Declaramos el ArrayList de empleados.
        ArrayList<Empleado> empleados = new ArrayList<>();

        //Definimos la cantidad de veces que se repetira el ciclo.
        System.out.println("Ingrese la cantidad de empleados a capturar:");
        int cantidadEmpleados = scanner.nextInt();
        scanner.nextLine();

        /*Iniciamos nuestro ciclo de registro de empleados, el cual se
        repetira segun las veces que el usuario alla indicado.*/
        for (int i = 0; i < cantidadEmpleados; i++) {
            System.out.println("Empleado #" + (i + 1));
            System.out.print("Nombre completo: ");
            String nombreCompleto = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Horas trabajadas: ");
            int horasTrabajadas = scanner.nextInt();
            System.out.print("Horas extras trabajadas: ");
            int horasExtrasTrabajadas = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Fecha de nacimiento: ");
            String fechaNacimiento = scanner.nextLine();

            //Aqui asignamos una categoria al empleado.
            System.out.println("Seleccione la categoría del empleado:");
            System.out.println("1. Empleado ventas");
            System.out.println("2. Administrador");
            System.out.println("3. Gerente");
            int categoriaSeleccionada = scanner.nextInt();
            Categoria categoria = switch (categoriaSeleccionada) {
                case 1 -> DiferenciarCategorias.getEmpleadoVentas();
                case 2 -> DiferenciarCategorias.getAdministrador();
                case 3 -> DiferenciarCategorias.getGerente();
                default -> {
                    System.out.println("Opción no válida, se asignará la categoría de " +
                            "Empleado ventas por defecto.");
                    yield DiferenciarCategorias.getEmpleadoVentas();
                }
            };

            //Aqui agregamos un empleado al ArrayList, con los datos que nos dio el usuario
            Empleado empleado = new Empleado(nombreCompleto, horasTrabajadas,
                    horasExtrasTrabajadas, telefono, fechaNacimiento, categoria);
            empleados.add(empleado);
        }

        //Aqui imprimimos el reporte de nomina.
        GenerardorReporte.generarReporteNomina(empleados);
    }
}

