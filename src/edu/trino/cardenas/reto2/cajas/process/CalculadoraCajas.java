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

    public static double calcularTotalIngresos(double cantidadCajasVendidas, double precioCajasVendidas) {
        double montoVenta = cantidadCajasVendidas * precioCajasVendidas;
        double totalIngresosVentas = 0;
        totalIngresosVentas = totalIngresosVentas+montoVenta;
        return totalIngresosVentas;
    }

    public static double calcularTotalEgresos(double cantidadCajasCompradas, double precioCajasCompradas) {
        double montoCompra = cantidadCajasCompradas * precioCajasCompradas;
        double totalEgresosCompras = 0;
        totalEgresosCompras = totalEgresosCompras+montoCompra;
        return totalEgresosCompras;
    }

    public static double calcularMontoCaja(double cantidadCajasVendidas, double precioCajasVendidas,
                                           double cantidadCajasCompradas, double precioCajasCompradas) {
        double montoVenta = cantidadCajasVendidas * precioCajasVendidas;
        double totalIngresosVentas = 0;
        totalIngresosVentas = totalIngresosVentas+montoVenta;
        double montoCompra = cantidadCajasCompradas * precioCajasCompradas;
        double totalEgresosCompras = 0;
        totalEgresosCompras = totalEgresosCompras+montoCompra;
        return totalIngresosVentas-totalEgresosCompras;
    }

}
