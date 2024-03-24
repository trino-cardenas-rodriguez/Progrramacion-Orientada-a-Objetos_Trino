package edu.trino.cardenas.evidencia2.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManejadorProductos {

    public static List<Producto> generarProductosAleatorios() {
        List<Producto> productos = new ArrayList<>();
        Random random = new Random();
        String[] tipos = {"Cancion", "Videojuego", "Libro", "Pelicula"};
        String[] generos = {"Pop", "Rock", "Aventura", "Terror", "Ciencia Ficcion", "Romantica", "Novela", "Tecnologia"};
        boolean[] estrenos = {true, false};

        for (int i = 0; i < 20; i++) {
            String tipo = tipos[random.nextInt(tipos.length)];
            String genero = generos[random.nextInt(generos.length)];
            boolean esEstreno = estrenos[random.nextInt(estrenos.length)];
            Producto producto;

            switch (tipo) {
                case "Cancion":
                    producto = new Cancion("Cancion " + i, genero, esEstreno);
                    break;
                case "Videojuego":
                    producto = new VideoJuego("Videojuego " + i, genero, esEstreno);
                    break;
                case "Libro":
                    producto = new Libro("Libro " + i, genero, esEstreno);
                    break;
                case "Pelicula":
                    producto = new Pelicula("Pelicula " + i, genero, esEstreno);
                    break;
                default:
                    producto = new Producto("Producto " + i, tipo, 5.0, genero, esEstreno);
            }

            productos.add(producto);
        }

        return productos;
    }

    // Calcula el costo total basado en la lista de productos consumidos
    public static double calcularCostoTotal(List<Producto> productos) {
        double costoTotal = 0;
        for (Producto producto : productos) {
            costoTotal += producto.calcularCosto();
        }
        return costoTotal;
    }
}
