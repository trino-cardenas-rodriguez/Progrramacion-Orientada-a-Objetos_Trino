package edu.trino.cardenas.evidencia1.process;

/*Aqui se importa la clase Medicamento de la carpeta data del package
edu.trino.cardenas.evidencia1.data para poder utilizar el constructor
dentro de los metodos siguientes.*/
import edu.trino.cardenas.evidencia1.data.Medicamento;

//Aqui se importa ArrayList de java para poder utilizarlo.
import java.util.ArrayList;

//Aqui se importa la libreria Date de java para poder escribir la fecha actualizada.
import java.util.Date;

/*Esta clase permite realizar los metodos de agregar medicamento al ArrayList,
y, generar el reporte de medicamentos registrados.*/
public class GestorMedicamentos {

    /*Este metodo nos permite agregar un medicamento al ArrayList; ademas de que nos
    permite aumentarle un porcentaje a dicho medicamento dependiendo de su forma farmaceutica.*/
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

    /*Este metodo nos permite generar el reporte de medicamentos registrados,
    incluyento en nombre de quien hace el registro, la fecha del registro,
    el numero de medicamentos que se registraron y los medicamentos registrados.*/
    public static void generarReporte(String nombre, ArrayList<Medicamento> listaMedicamentos){
        Date fecha = new Date();
        int cantidadMedicamentos = listaMedicamentos.size();

        System.out.println("---------------------Reporte---------------------");
        System.out.println("Registro realizado por: " + nombre);
        System.out.println("Fecha de registro: " + fecha);
        System.out.println("Cantidad de medicamentos contenidos en la lista: " + cantidadMedicamentos);
        System.out.println("--------------Medicamentos--------------");

        for (Medicamento medicamento : listaMedicamentos) {
            System.out.println(medicamento.toString());
        }
    }
}
