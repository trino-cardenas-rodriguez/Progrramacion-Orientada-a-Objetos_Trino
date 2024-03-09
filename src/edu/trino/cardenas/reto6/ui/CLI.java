package edu.trino.cardenas.reto6.ui;

import edu.trino.cardenas.reto6.data.Categoria;
import edu.trino.cardenas.reto6.data.DiferenciarCategorias;
import edu.trino.cardenas.reto6.data.Empleado;
import edu.trino.cardenas.reto6.process.ManejadorSueldos;

import java.util.ArrayList;
import java.util.Scanner;

public class CLI {

    public static void LaunchApp() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Empleado> empleados = new ArrayList<>();

        System.out.println("Ingrese la cantidad de empleados a capturar:");
        int cantidadEmpleados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadEmpleados; i++) {
            System.out.println("Empleado #" + (i + 1));
            System.out.print("Nombre completo: ");
            String nombreCompleto = scanner.nextLine();
            System.out.print("Horas trabajadas: ");
            int horasTrabajadas = scanner.nextInt();
            System.out.print("Horas extras trabajadas: ");
            int horasExtrasTrabajadas = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Fecha de nacimiento: ");
            String fechaNacimiento = scanner.nextLine();

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
                    System.out.println("Opción no válida, se asignará la categoría de Empleado ventas por defecto.");
                    yield DiferenciarCategorias.getEmpleadoVentas();
                }
            };

            Empleado empleado = new Empleado(nombreCompleto, horasTrabajadas, horasExtrasTrabajadas, telefono, fechaNacimiento, categoria);
            empleados.add(empleado);
        }

        ManejadorSueldos.generarReporteNomina(empleados);
    }
}
