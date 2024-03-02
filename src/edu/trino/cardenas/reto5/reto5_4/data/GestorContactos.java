package edu.trino.cardenas.reto5.reto5_4.data;

import java.util.ArrayList;

public class GestorContactos {

    public void agregarContacto(ArrayList<Contacto> listaContactos, Contacto contacto){
        listaContactos.add(new Contacto(contacto.nombre, contacto.direccion,
                contacto.telefonoCasa, contacto.telefonoTrabajo));
    }
}
