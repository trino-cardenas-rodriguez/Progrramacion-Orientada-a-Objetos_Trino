package edu.trino.cardenas.reto6.process;

//Aqui se importa la clase Empleado para poder usar sus datos.
import edu.trino.cardenas.reto6.data.Empleado;

//Aqui se importa ArrayList de java para poder utilizarlo.
import java.util.ArrayList;

//En esta clase se definen el metodo que nos genera el registro de nomina.
public class GenerardorReporte {

    //Este metodo realiza las operaciones segun los datos que nos brinda el usuario y genera el reporte de nomina.
    public static void generarReporteNomina(ArrayList<Empleado> empleados) {

        //Aqui declaramos las variables que se utilizaran dentro del metodo.
        double totalNomina = 0;
        double totalSueldoNormal = 0;
        double totalPagoHorasExtras = 0;
        int totalHorasLaboradas = 0;
        int totalPersonasConHorasExtras = 0;
        int totalPersonasSinHorasExtras = 0;

        //Aqui realizamos las operaciones, una ves por cada empleado registrado.
        for (Empleado empleado : empleados) {
            double sueldoNormal = empleado.getHorasTrabajadas() * empleado.getCategoria().getSueldoBase();
            double pagoHorasExtras = empleado.getHorasExtrasTrabajadas() * empleado.getCategoria().getPagoHoraExtra();

            totalNomina += sueldoNormal + pagoHorasExtras;
            totalSueldoNormal += sueldoNormal;
            totalPagoHorasExtras += pagoHorasExtras;
            totalHorasLaboradas += empleado.getHorasTrabajadas() + empleado.getHorasExtrasTrabajadas();

            if (empleado.getHorasExtrasTrabajadas() > 0) {
                totalPersonasConHorasExtras++;
            } else {
                totalPersonasSinHorasExtras++;
            }
        }

        //Aqui se genera el formato de imprecion del reporte.
        System.out.println("\nReporte de Nómina");
        System.out.println("Total de la nómina de la empresa: $" + totalNomina);
        System.out.println("Total a pagar por sueldo normal: $" + totalSueldoNormal);
        System.out.println("Total a pagar por horas extras: $" + totalPagoHorasExtras);
        System.out.println("Total de horas laboradas en la empresa: " + totalHorasLaboradas + " horas");
        System.out.println("Total de personas que tienen horas extras: " + totalPersonasConHorasExtras);
        System.out.println("Total de personas que no tienen horas extras: " + totalPersonasSinHorasExtras);
    }
}