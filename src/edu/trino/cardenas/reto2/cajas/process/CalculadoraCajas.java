package edu.trino.cardenas.reto2.cajas.process;
public class CalculadoraCajas {
    private static double totalCajasCompradas = 0;
    private static double totalCajasVendidas = 0;
    private static double totalIngresos = 0;
    private static double totalEgresos = 0;

    public static double calcularMontoCompra(double cantidadCajasCompradas, double precioCajasCompradas) {
        double montoCompra = cantidadCajasCompradas * precioCajasCompradas;
        totalCajasCompradas += cantidadCajasCompradas;
        totalEgresos += montoCompra;
        return montoCompra;
    }

    public static double calcularMontoVenta(double cantidadCajasVendidas, double precioCajasVendidas) {
        double montoVenta = cantidadCajasVendidas * precioCajasVendidas;
        totalCajasVendidas += cantidadCajasVendidas;
        totalIngresos += montoVenta;
        return montoVenta;
    }

    public static double calcularTotalCajasCompradas() {
        return totalCajasCompradas;
    }

    public static double calcularTotalCajasVendidas() {
        return totalCajasVendidas;
    }

    public static double calcularTotalIngresos() {
        return totalIngresos;
    }

    public static double calcularTotalEgresos() {
        return totalEgresos;
    }

    public static double calcularMontoCaja() {
        return totalIngresos - totalEgresos;
    }
}

