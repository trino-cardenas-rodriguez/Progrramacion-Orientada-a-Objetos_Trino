package edu.trino.cardenas.reto6.data;

//Esta clase sirve para declarar los atributos del empleado, generar su constructor y sus getters.
public class Empleado {

    //Aqui se declaran los atributos.
    private String nombreCompleto;
    private int horasTrabajadas;
    private int horasExtrasTrabajadas;
    private String telefono;
    private String fechaDeNacimiento;
    private Categoria categoria;

    //Aqui se crea el constructor.
    public Empleado(String nombreCompleto, int horasTrabajadas, int horasExtrasTrabajadas,
                    String telefono, String fechaDeNacimiento, Categoria categoria) {
        this.nombreCompleto = nombreCompleto;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtrasTrabajadas = horasExtrasTrabajadas;
        this.telefono = telefono;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.categoria = categoria;
    }

    //Aqui se crean los getters, aunque algunos no se utilizan.
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public int getHorasExtrasTrabajadas() {
        return horasExtrasTrabajadas;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
