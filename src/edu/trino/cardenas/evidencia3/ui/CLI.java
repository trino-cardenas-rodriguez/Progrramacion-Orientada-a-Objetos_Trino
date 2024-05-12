package edu.trino.cardenas.evidencia3.ui;

/**Importamos la clase Jugador de la carpeta data para poder definir los atributos del jugador.*/
import edu.trino.cardenas.evidencia3.data.Jugador;

/**Importamos la clase Tablero de la carpeta process para poder utilizar los metodos del tablero.*/
import edu.trino.cardenas.evidencia3.process.Tablero;
import static edu.trino.cardenas.evidencia3.process.Tablero.*;

/**Importamos la funcion random para generar numeros random.*/
import java.util.Random;

/**Importamos el scanner de java para poder reconocer los datos que ingrese el ususario.*/
import java.util.Scanner;

/**Esta clase sirve para poder mostar al usuario los menus de idiomas y de modo de juego;
 * ademas se realizan algunas validaciones para el ingreso de datos y se imprimen errores.*/
public class CLI {
    private static boolean contraComputadora;
    static Scanner scanner = new Scanner(System.in);

    /**Este metodo permite mostrar el menu de idiomas.*/
    public static void mostrarMenuIdiomas() {
        System.out.println("""
                --------------------------------------------------------------------------
                Seleccione su idioma / Select your language / あなたが使う言語を選んでください:
                ESP: Español / Spanish / スペイン語
                ENG: Inglés / English / 英語
                JAP: Japonés / Japanese / 日本語""");
    }

    /**Este metodo permite mostrar al usuario el menu de modo de juego y
     * que pueda seleccionar el modo que quiera jugar.*/
    public static boolean seleccionarModoJuego(){
        System.out.println(Idiomas.BIENVENIDA);
        System.out.println(Idiomas.SELECCIONE_OPCION);
        System.out.println(Idiomas.PVP);
        System.out.println(Idiomas.PVC);

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        if (opcion == 1){
            return false;
        } else if (opcion == 2) {
            return true;
        } else {
            System.out.println(Idiomas.OPCION_INVALIDA);
            return seleccionarModoJuego();
        }
    }

    /**Este metodo nos permite iniciar el juego con un bucle en el que se define el modo de juego y que,
     * si el usuario decea, puede jugar otra partida.*/
    public static void iniciarJuego() {

        do {
            if (!contraComputadora) {
                // Juego contra otra persona
                jugarContraJugador();
            } else {
                // Juego contra la computadora
                jugarContraComputadora();
            }

            System.out.println(Idiomas.JUGAR_NUEVAMENTE);
            scanner.nextLine();
            String respuesta = scanner.nextLine().toLowerCase();

            while (!respuesta.equals("si") && !respuesta.equals("no")) {
                System.out.println(Idiomas.RESPUESTA_INVALIDA);
                respuesta = scanner.nextLine().toLowerCase();
            }

            if (respuesta.equals("no")) {
                System.out.println(Idiomas.GRACIAS_POR_JUGAR);
                break;
            }

            // Reiniciar el tablero para una nueva partida
            Tablero.reiniciarTablero();

        } while (true);
    }

    /**Este metodo es el que nos permite jugar contra otro jugador, contiene validaciones de ingreso de datos.*/
    private static void jugarContraJugador() {
        // Elegir aleatoriamente quién empieza
        turnoJugador1 = new Random().nextBoolean();
        System.out.println(Idiomas.NUEVA_PARTIDA);

        System.out.print(Idiomas.NOMBRE_JUGADOR_1);
        String nombreJugador1 = scanner.nextLine();
        while (cadenaVacia(nombreJugador1)) {
            System.out.println(Idiomas.NOMBRE_VACIO);
            System.out.print(Idiomas.NOMBRE_JUGADOR_1);
            nombreJugador1 = scanner.nextLine();
        }
        System.out.print(Idiomas.SIMBOLO_JUGADOR_1);
        String simboloJugador1 = scanner.nextLine().toUpperCase();

        while (cadenaVacia(simboloJugador1) || simboloJugador1.length() != 1 ||
                !simbolosValidos.contains(simboloJugador1)) {
            System.out.println(Idiomas.SIMBOLO_NO_VALIDO);
            System.out.print(Idiomas.INGRESE_SIMBOLO);
            simboloJugador1 = scanner.nextLine().toUpperCase();
        }

        jugador1 = new Jugador(nombreJugador1, simboloJugador1);


        // Validar el nombre del jugador 2
        String nombreJugador2;
        do {
            System.out.print(Idiomas.NOMBRE_JUGADOR_2);
            nombreJugador2 = scanner.nextLine();
            if (nombreJugador2.equalsIgnoreCase(nombreJugador1)) {
                System.out.println(Idiomas.NOMBRE_JUGADOR_2_DIFERENTE);
            }
        } while (nombreJugador2.equalsIgnoreCase(nombreJugador1));

        String simboloJugador2;
        System.out.print(Idiomas.SIMBOLO_JUGADOR_2 + simboloJugador1 + "): ");
        simboloJugador2 = scanner.nextLine().toUpperCase();

        while (simboloJugador2.equals(simboloJugador1) || cadenaVacia(simboloJugador2) ||
                simboloJugador2.length() != 1 || !simbolosValidos.contains(simboloJugador2)) {
            System.out.println(Idiomas.SIMBOLO_NO_VALIDO_DIFERENTE + simboloJugador1);
            System.out.print(Idiomas.SIMBOLO_JUGADOR_2 + simboloJugador1 + "): ");
            simboloJugador2 = scanner.nextLine().toUpperCase();
        }
        jugador2 = new Jugador(nombreJugador2, simboloJugador2);

        imprimirTablero(); // Mostrar el tablero antes de solicitar la jugada

        while (true) {
            if (turnoJugador1) {
                turnoJugador(jugador1);
            } else {
                turnoJugador(jugador2);
            }

            if (verificarVictoria()) {
                System.out.println("¡" + (turnoJugador1 ? jugador1.getNombre() : jugador2.getNombre()) +
                        Idiomas.HA_GANADO);
                break;
            }
            if (tableroLleno()) {
                System.out.println(Idiomas.EMPATE);
                break;
            }

            turnoJugador1 = !turnoJugador1;
        }

        // Actualizar el salón de la fama
        if (verificarVictoria()) {
            salonDeLaFama.actualizar(turnoJugador1 ? jugador1.getNombre() : jugador2.getNombre());
        }

        // Mostrar el salón de la fama al final de la partida
        salonDeLaFama.mostrar();
    }

    /**Este metodo nos permite jugar contra la computadora, contiene validaciones de ingresos de datos.*/
    public static void jugarContraComputadora(){
        System.out.println(Idiomas.NUEVA_PARTIDA);
        System.out.print(Idiomas.NOMBRE);
        String nombreJugador1 = scanner.nextLine();
        while (cadenaVacia(nombreJugador1)) {
            System.out.println(Idiomas.NOMBRE_VACIO);
            System.out.print(Idiomas.NOMBRE);
            nombreJugador1 = scanner.nextLine();
        }
        System.out.print(Idiomas.INGRESE_SIMBOLO);
        String simboloJugador1 = scanner.nextLine().toUpperCase();

        while (cadenaVacia(simboloJugador1) || simboloJugador1.length() != 1 ||
                !simbolosValidos.contains(simboloJugador1)) {
            System.out.println(Idiomas.SIMBOLO_NO_VALIDO);
            System.out.print(Idiomas.INGRESE_SIMBOLO);
            simboloJugador1 = scanner.nextLine().toUpperCase();
        }
        jugador1 = new Jugador(nombreJugador1, simboloJugador1);
        jugador2 = new Jugador("Computadora", simboloJugador1.equals("X") ? "O" : "X");

        imprimirTablero(); // Mostrar el tablero antes de solicitar la jugada

        while (true) {
            if (turnoJugador1) {
                turnoJugador(jugador1);
            } else {
                turnoComputadora();
            }

            if (verificarVictoria()) {
                System.out.println("¡" + (turnoJugador1 ? jugador1.getNombre() : jugador2.getNombre()) +
                        Idiomas.HA_GANADO);
                break;
            }
            if (tableroLleno()) {
                System.out.println(Idiomas.EMPATE);
                break;
            }

            turnoJugador1 = !turnoJugador1;
        }

        // Actualizar el salón de la fama
        if (verificarVictoria()) {
            salonDeLaFama.actualizar(jugador1.getNombre());
        }
    }

    /**Este metodo se ejecuta en cada turno de jugador, contiene validaciones de filas y columnas.*/
    public static void turnoJugador(Jugador jugador) {
        System.out.println(Idiomas.TURNO + jugador.getNombre() + " (" + jugador.getSimbolo() + ")");

        // Solicitar la fila
        int fila;
        do {
            System.out.print(Idiomas.FILA);
            String inputFila = scanner.nextLine();
            try {
                fila = Integer.parseInt(inputFila) - 1; // Ajustar la fila ingresada a la indexación del arreglo
            } catch (NumberFormatException e) {
                System.out.println(Idiomas.NUMERO_INVALIDO);
                fila = -1; // Valor inválido para continuar el bucle
            }
            if (fila < 0 || fila > 2 || filaLlena(fila)) {
                System.out.println(Idiomas.FILA_INVALIDA);
            }
        } while (fila < 0 || fila > 2 || filaLlena(fila));

        // Solicitar la columna
        int columna;
        do {
            System.out.print(Idiomas.COLUMNA);
            String inputColumna = scanner.nextLine();
            try {
                columna = Integer.parseInt(inputColumna) - 1; // Ajustar la columna ingresada a la indexación del arreglo
            } catch (NumberFormatException e) {
                System.out.println(Idiomas.NUMERO_INVALIDO);
                columna = -1; // Valor inválido para continuar el bucle
            }
            if (columna < 0 || columna > 2 || columnaLlena(columna)) {
                System.out.println(Idiomas.COLUMNA_INVALIDA);
            }
        } while (columna < 0 || columna > 2 || columnaLlena(columna));

        // Verificar si la casilla está ocupada
        if (tablero[fila][columna] != '-') {
            System.out.println(Idiomas.CASILLA_OCUPADA);
            turnoJugador(jugador); // Solicitar una nueva jugada
        } else {
            // Colocar el símbolo en el tablero
            tablero[fila][columna] = jugador.getSimbolo().charAt(0);
            imprimirTablero();
        }
    }

    /**Este metodo es el que nos permite espesar toda la aplicacion.*/
    public static void launchGame() {
        mostrarMenuIdiomas();
        String idiomaSeleccionado = scanner.nextLine().toUpperCase();
        Idiomas.getInstance(idiomaSeleccionado);

        contraComputadora = seleccionarModoJuego(); // Obtener el valor del modo de juego
        Tablero juego = new Tablero(contraComputadora); // Crear una instancia de Juego con el modo de juego seleccionado

        iniciarJuego();
    }
}

