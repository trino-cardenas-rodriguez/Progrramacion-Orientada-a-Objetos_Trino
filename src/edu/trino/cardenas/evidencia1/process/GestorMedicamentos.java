package edu.trino.cardenas.evidencia1.process;

import edu.trino.cardenas.evidencia1.data.Medicamento;
import java.util.ArrayList;
import java.util.Date;

public class GestorMedicamentos {

    public static void agregarMedicamemnto(ArrayList<Medicamento> listaMedicamentos, String nombreQuimico,
                                           String nombreGenerico, String nombreRegistrado,
                                           double precioPublico, String formaFarmaceutica){
        double precioVenta = precioPublico;
        switch (formaFarmaceutica){
            case "solida":
                precioVenta *= 1.09;
                break;
            case "semisolida":
                precioVenta *= 1.12;
                break;
            case "liquida":
                precioVenta *= 1.13;
                break;
            default:
                System.out.println("No se ha encontrado la forma farmaceutica indicada. " +
                        "\nNo se le aplicara descuento al precio publico!");
        }

    Medicamento medicamento = new Medicamento(nombreQuimico, nombreGenerico, nombreRegistrado,
            precioPublico, precioVenta, formaFarmaceutica);
        listaMedicamentos.add(medicamento);
    }

    public static void generarReporte(String nombre, ArrayList<Medicamento> listaMedicamentos){
        Date fecha = new Date();
        int cantidadMedicamentos = listaMedicamentos.size();

        System.out.println("Registro realizado por: " + nombre);
        System.out.println("Fecha de reporte: " + fecha);
        System.out.println("Cantidad de medicamentos contenidos en la lista: " + cantidadMedicamentos);
        System.out.println("--------------Medicamentos--------------");

        for (Medicamento medicamento : listaMedicamentos) {
            System.out.println(medicamento.toString());
        }
    }
}
