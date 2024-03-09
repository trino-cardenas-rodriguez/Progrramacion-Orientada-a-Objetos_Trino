package edu.trino.cardenas.reto6.data;

import java.util.Date;

public class Empleado {

    private String nombreCompleto;
    private int horasTrabajadas;
    private int horasExtrasTrabajadas;
    private String telefono;
    private Date fechaDeNacimiento;
    private Categoria categoria;

    public Empleado(String nombreCompleto, int horasTrabajadas, int horasExtrasTrabajadas,
                    String telefono, Date fechaDeNacimiento, Categoria categoria) {
        this.nombreCompleto = nombreCompleto;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtrasTrabajadas = horasExtrasTrabajadas;
        this.telefono = telefono;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.categoria = categoria;
    }

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

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
