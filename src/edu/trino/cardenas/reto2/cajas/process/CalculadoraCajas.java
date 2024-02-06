package edu.trino.cardenas.reto2.cajas.process;

/*Esta clse sirve para realizar las operaciones de referentes a la compra y venta
de cajas, e incluye los siguentes metodos:
    Calculo del monto de compra
    Calcular del monto de venta
    Calcular el monto en la caja
    Total de cajas compradas
    Total de cajas vendidas
    Total de ingresos
    Total de egresos*/
public class CalculadoraCajas {

    /*Aqui defino unos metodos que me serviran como contadores
    o acumuladores, y asi poder llamarlas desde el CLI.*/
    public static double totalCajasCompradas = 0;
    public static double totalCajasVendidas = 0;
    public static double totalIngresos = 0;
    public static double totalEgresos = 0;

    /**Este metodo sirve para realizar el calculo del monto de compra,
     con base en cuantas cajas compra el usuario y a que precio las compra.
     Ademas tambien utilizo los metodos que declare al inicio como
     contadores para ir sumando la cantidad de cajas compradas y
     el monto de compra de estas; declarando asi el total de
     cajas compradas y el total de egresos.
     @param cantidadCajasCompradas que compro el usuario
     @param precioCajasCompradas al que compro las cajas
     @return monto de compra*/
    public static double calcularMontoCompra(double cantidadCajasCompradas, double precioCajasCompradas) {
        double montoCompra = cantidadCajasCompradas * precioCajasCompradas;
        totalCajasCompradas += cantidadCajasCompradas;
        totalEgresos += montoCompra;
        return montoCompra;
    }

    /**Este metodo sirve para realizar el calculo del monto de venta,
     con base en cuantas cajas vende el usuario y a que precio las vende.
     Ademas tambien utilizo los metodos que declare al inicio como
     contadores para ir sumando la cantidad de cajas vendidas y
     el monto de venta de estas; declarando asi el total de
     cajas vendidas y el total de ingresos..
     @param cantidadCajasVendidas que compro el usuario
     @param precioCajasVendidas al que compro las cajas
     @return monto de venta*/
    public static double calcularMontoVenta(double cantidadCajasVendidas, double precioCajasVendidas) {
        double montoVenta = cantidadCajasVendidas * precioCajasVendidas;
        totalCajasVendidas += cantidadCajasVendidas;
        totalIngresos += montoVenta;
        return montoVenta;
    }

    /**Este metodo sirve para calcular el monto que hay en la caja,
     utilizando el total de ingresos y el todtal de egresos.
     @return monto en caja*/
    public static double calcularMontoEnCaja() {
        return totalIngresos - totalEgresos;
    }
}

