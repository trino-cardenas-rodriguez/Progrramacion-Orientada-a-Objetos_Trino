package edu.trino.cardenas.reto2.cajas.process;
public class CalculadoraCajas {
    public static double calcularMontoCompra(double cantidadCajasCompradas, double precioCajasCompradas){
        return cantidadCajasCompradas * precioCajasCompradas;
    }

    public static double calcularMontoVenta(double cantidadCajasVendidas, double precioCajasVendidas){
        return cantidadCajasVendidas * precioCajasVendidas;
    }

    public static int calcularTotalCajasCompradas(int cantidadCajasCompradas) {
        int totalCajasCompradas = 0;
        totalCajasCompradas = totalCajasCompradas + cantidadCajasCompradas;
        return totalCajasCompradas;
    }
    public static int calcularTotalCajasVendidas(int cantidadCajasVendidas) {
        int totalCajasVendidas = 0;
        totalCajasVendidas = totalCajasVendidas+cantidadCajasVendidas;
        return totalCajasVendidas;
    }

    public static double calcularTotalIngresos(double montoVenta) {
        double totalIngresosVentas = 0;
        totalIngresosVentas = totalIngresosVentas+montoVenta;
        return totalIngresosVentas;
    }

    public static double calcularTotalEgresos(double montoCompra) {
        double totalEgresosCompras = 0;
        totalEgresosCompras = totalEgresosCompras+montoCompra;
        return totalEgresosCompras;
    }

    public static double calcularMontoCaja(double totalIngresosVentas, double totalEgresosCompras) {
        return totalIngresosVentas-totalEgresosCompras;
    }

}
