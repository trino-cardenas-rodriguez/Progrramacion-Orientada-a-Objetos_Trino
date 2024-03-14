package edu.trino.cardenas.reto6.data;

//Esta clase sirve para diferenciar las distintas categorias que hay, y crear sus getters
public class DiferenciarCategorias {

    //Aqui declaramos cada categoria con sus valores asignados.
    private static final Categoria empleadoVentas = new Categoria("Empleado ventas",
            "EV", 100.00, 50.00);
    private static final Categoria administrador = new Categoria("Administrador",
            "ADM", 180.00, 100.00);
    private static final Categoria gerente = new Categoria("Gerente",
            "GER", 250.00, 150.00);

    //Aqui generamos sus getters.
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

