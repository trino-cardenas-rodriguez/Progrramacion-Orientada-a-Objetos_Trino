package edu.trino.cardenas.reto5.reto5_2.data;

import java.util.ArrayList;

public class CarteraCuentaHabientes {

    public void agregarcuenta(ArrayList<Cuenta> cuentas, Cuenta cuenta){
        cuentas.add(new Cuenta(cuenta.ahorroTotal, cuenta.numeroCuenta, cuenta.propietario));
    }

    public void mostrarCartera(ArrayList<Cuenta> cuentas){
        System.out.println(cuentas);
    }
}
