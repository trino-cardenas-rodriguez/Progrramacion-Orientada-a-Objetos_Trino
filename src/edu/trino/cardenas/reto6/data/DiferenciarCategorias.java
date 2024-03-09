package edu.trino.cardenas.reto6.data;

public class DiferenciarCategorias {

    private static Categoria empleadoVentas;
    private static Categoria administrador;
    private static Categoria gerente;

    public DiferenciarCategorias() {
        empleadoVentas = new Categoria("Empleado ventas",
                "EV", 100.00, 50.00);
        administrador = new Categoria("Administrador",
                "ADM", 180.00, 100.00);
        gerente = new Categoria("Gerente",
                "GER", 250.00, 150.00);
    }

    public static Categoria getEmpleadoVentas() {
        return empleadoVentas;
    }

    public static Categoria getAdministrador() {
        return administrador;
    }

    public static Categoria getGerente() {
        return gerente;
    }
}
