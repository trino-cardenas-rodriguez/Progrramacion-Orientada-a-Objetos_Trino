package edu.trino.cardenas.evidencia2.ui;

/*Esta es una clase que hereda los atributos de la clase base Textos.*/
public class Spanish extends Textos{

    /*Aqui declaramos las variables de la clase base con los textos en español, las
    cuales se usaran predeterminadamente o si el usuario lo indica.*/
    public Spanish() {

        ERROR_INESPERADO = "Error inesperado ";

        INICIO_SECION = "Hola, por favor inicie sesion.";
        USUARIO = "Ingrese su usuario: ";
        CONTRASENA = "Ingrese su contraseña: ";
        DATOS_INCORRECTOS = "Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.";
        INICIO_EXITOSO = "Inicio de sesión exitoso, acceso permitido.";
        SALDO_PAGAR = "El saldo total a pagar por su consumo realizado es de: $";
    }
}
