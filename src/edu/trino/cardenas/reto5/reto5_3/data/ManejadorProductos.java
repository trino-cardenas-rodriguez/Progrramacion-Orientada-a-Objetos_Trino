package edu.trino.cardenas.reto5.reto5_3.data;

import java.util.ArrayList;

public class ManejadorProductos {

    public void agregarProducto(ArrayList<Producto> listaProductos, Producto producto){
        listaProductos.add(new Producto(producto.nombre, producto.precio,
                producto.cantidad, producto.importeTotal));
    }

    public void calcularImporteTotal (Producto producto){
        producto.importeTotal = producto.cantidad * producto.precio;
    }

    public void mostrarListaProductos(ArrayList<Producto> listaProductos){
        System.out.println(listaProductos);
    }
}
