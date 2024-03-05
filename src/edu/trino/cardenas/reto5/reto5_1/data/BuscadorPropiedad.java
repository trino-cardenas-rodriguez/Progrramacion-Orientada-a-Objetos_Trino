package edu.trino.cardenas.reto5.reto5_1.data;

import java.util.ArrayList;

public class BuscadorPropiedad {

    /*Aqui se haria una validacion de, si las coordenadas de la propiedad estan
    cerca de la ubicacion (coordenadas) del usuario, se agregara a la lista de propiedades cercanas*/
    public void agregarPropiedad (ArrayList<Propiedad> propiedadesCercanas,
                                  Propiedad propiedad, Usuario usuario){
        double ubicacion = usuario.ubicacion;
        double coordenadas = propiedad.coordenadas;
        propiedadesCercanas.add(new Propiedad(propiedad.direccion,
                propiedad.coordenadas, propiedad.estado));
    }

    public void mostrarListaPropiedades (ArrayList<Propiedad> propiedadesCercanas){
        System.out.println(propiedadesCercanas);
    }
}