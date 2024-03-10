package edu.trino.cardenas.reto6.process;

import edu.trino.cardenas.reto6.data.Empleado;

import java.util.ArrayList;

public class ManejadorSueldos {

    public static void generarReporteNomina(ArrayList<Empleado> empleados) {
        double totalNomina = 0;
        double totalSueldoNormal = 0;
        double totalPagoHorasExtras = 0;
        int totalHorasLaboradas = 0;
        int totalPersonasConHorasExtras = 0;
        int totalPersonasSinHorasExtras = 0;

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


        System.out.println("\nReporte de Nómina");
        System.out.println("Total de la nómina de la empresa: $" + totalNomina);
        System.out.println("Total a pagar por sueldo normal: $" + totalSueldoNormal);
        System.out.println("Total a pagar por horas extras: $" + totalPagoHorasExtras);
        System.out.println("Total de horas laboradas en la empresa: " + totalHorasLaboradas + " horas");
        System.out.println("Total de personas que tienen horas extras: " + totalPersonasConHorasExtras);
        System.out.println("Total de personas que no tienen horas extras: " + totalPersonasSinHorasExtras);
    }
}