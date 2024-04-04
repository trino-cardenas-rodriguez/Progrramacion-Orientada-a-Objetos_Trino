package edu.trino.cardenas.evidencia2.ui;

/*Esta es una clase que hereda los atributos de la clase base Textos.*/
public class English extends Textos{

    /*Aqui declaramos las variables de la clase base con los textos en ingles, las
    cuales cuando el usuario seleccione el idioma ingles.*/
    public English (){

        ERROR_INESPERADO = "Unexpected error ";

        INICIO_SECION = "Hello, please log in";
        USUARIO = "Enter your username: ";
        CONTRASENA = "Enter your password: ";
        DATOS_INCORRECTOS = "Incorrect user or password. Please try again.";
        INICIO_EXITOSO = "Login successful, access allowed.";
        SALDO_PAGAR = "The total balance to be paid for your realised consumption is: $";
    }
}
