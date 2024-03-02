package edu.trino.cardenas.reto5.reto5_5.data;

import java.util.ArrayList;

public class ManejadorArticulos {

    public void agregarArticulo(ArrayList<Articulo> carrito, Articulo articulo){
        carrito.add(new Articulo(articulo.nombre, articulo.precio, articulo.iva,
                articulo.importeNeto, articulo.cantidad));
    }

    public void calcularImporteNeto(Articulo articulo){
        articulo.importeNeto = articulo.precio + (articulo.precio * articulo.iva);
    }

    public void mostrarCarrito(ArrayList<Articulo> carrito){
        System.out.println(carrito);
    }
}
