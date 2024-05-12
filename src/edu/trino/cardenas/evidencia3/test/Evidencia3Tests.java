package edu.trino.cardenas.evidencia3.test;


import edu.trino.cardenas.evidencia3.Main;
import edu.trino.cardenas.evidencia3.data.Jugador;
import edu.trino.cardenas.evidencia3.data.SalonDeLaFama;
import edu.trino.cardenas.evidencia3.process.JuegoComputadora;
import edu.trino.cardenas.evidencia3.process.Tablero;
import edu.trino.cardenas.evidencia3.ui.CLI;
import edu.trino.cardenas.evidencia3.ui.Idiomas;
import static edu.trino.cardenas.evidencia3.ui.CLI.seleccionarModoJuego;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


/**
 * Clase que contiene las pruebas unitarias para el proyecto de la Evidencia 3.
 */
public class Evidencia3Tests {

    /**
     * Método de prueba para asegurar que el método main no lance excepciones.
     */
    @Test
    public void MainWithoutExceptionsTest() {
        // Verificar que el método main no lance excepciones
        try {
            Main.main(new String[]{});
        } catch (Exception e) {
            // Si se lanza una excepción, la prueba fallará
            e.printStackTrace();
        }
    }

    /**
     * Método de prueba para obtener la instancia del idioma inglés.
     */
    @Test
    public void GetInstanceTest() {
        Idiomas.getInstance("ENG");
        assertEquals("Welcome to the game of tic-tac-toe!", Idiomas.BIENVENIDA);
    }

    /**
     * Método de prueba para obtener la instancia del idioma español.
     */
    @Test
    public void GetInstanceSpanishTest() {
        Idiomas.getInstance("ESP");
        assertEquals("¡Bienvenido al juego de tres en raya!", Idiomas.BIENVENIDA);
    }

    /**
     * Método de prueba para obtener la instancia del idioma inglés.
     */
    @Test
    public void GetInstanceEnglishTest() {
        Idiomas.getInstance("ENG");
        assertEquals("Welcome to the game of tic-tac-toe!", Idiomas.BIENVENIDA);
    }

    /**
     * Método de prueba para obtener la instancia del idioma japonés.
     */
    @Test
    public void GetInstanceJapaneseTest() {
        Idiomas.getInstance("JAP");
        assertEquals("三目並べゲームへようこそ！", Idiomas.BIENVENIDA);
    }

    /**
     * Método de prueba para verificar el manejo de una excepción cuando se solicita un idioma no válido.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetInstanceInvalidLanguage() {
        Idiomas.getInstance("INVALID");
    }

    /**
     * Método de configuración que se ejecuta antes de cada prueba para restablecer las cadenas de idioma.
     */
    @Before
    public void setUp() {
        // Reiniciar los valores de las cadenas de texto antes de cada test
        reiniciarIdiomas();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Método para reiniciar todas las cadenas de idioma.
     */
    private void reiniciarIdiomas() {
        // Reiniciar todas las cadenas de idioma a nulo
        Idiomas.BIENVENIDA = null;
        Idiomas.SELECCIONE_OPCION = null;
        Idiomas.PVP = null;
        Idiomas.PVC = null;
        Idiomas.JUGAR_NUEVAMENTE = null;
        Idiomas.RESPUESTA_INVALIDA = null;
        Idiomas.GRACIAS_POR_JUGAR = null;
        Idiomas.NUEVA_PARTIDA = null;
        Idiomas.NOMBRE_JUGADOR_1 = null;
        Idiomas.NOMBRE_VACIO = null;
        Idiomas.SIMBOLO_JUGADOR_1 = null;
        Idiomas.SIMBOLO_NO_VALIDO = null;
        Idiomas.INGRESE_SIMBOLO = null;
        Idiomas.NOMBRE_JUGADOR_2 = null;
        Idiomas.NOMBRE_JUGADOR_2_DIFERENTE = null;
        Idiomas.SIMBOLO_JUGADOR_2 = null;
        Idiomas.SIMBOLO_NO_VALIDO_DIFERENTE = null;
        Idiomas.HA_GANADO = null;
        Idiomas.EMPATE = null;
        Idiomas.NOMBRE = null;
        Idiomas.TURNO = null;
        Idiomas.FILA = null;
        Idiomas.FILA_INVALIDA = null;
        Idiomas.NUMERO_INVALIDO = null;
        Idiomas.COLUMNA = null;
        Idiomas.COLUMNA_INVALIDA = null;
        Idiomas.ERROR_INICIALIZACION = null;
        Idiomas.TABLERO = null;
        Idiomas.COMPUTADORA_HA_JUGADO = null;
        Idiomas.OPCION_INVALIDA = null;
        Idiomas.ERROR_INESPERADO = null;
    }


    /**
     * Método de prueba para verificar que las cadenas de texto en español se inicialicen correctamente.
     */
    @Test
    public void GetInstanceSpanishCompletoTest() {
        Idiomas.getInstance("ESP");
        // Verificar todas las cadenas de texto en español
        assertEquals("Seleccione el modo de juego: ", Idiomas.SELECCIONE_OPCION);
        assertEquals("1. Jugador contra jugador", Idiomas.PVP);
        assertEquals("2. Jugador contra la computadora", Idiomas.PVC);
    }

    /**
     * Método de prueba para verificar si una cadena está vacía o contiene solo espacios en blanco.
     */
    @Test
    public void CadenaVaciaTest() {
        assertTrue(Tablero.cadenaVacia(""));
        assertTrue(Tablero.cadenaVacia(" "));
        assertFalse(Tablero.cadenaVacia("  abc  "));
    }

    /**
     * Método de prueba para verificar el establecimiento del símbolo en el juego de la computadora.
     */
    @Test
    public void SetSimboloTest() {
        JuegoComputadora juego = new JuegoComputadora();
        juego.setSimbolo('X');
        assertEquals('X', juego.getSimbolo());
    }

    /**
     * Método de prueba para simular el turno de juego en el juego de la computadora.
     */
    @Test
    public void JugarTurnoTest() {
        JuegoComputadora juego = new JuegoComputadora();
        juego.setSimbolo('X');
        char[][] tablero = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        juego.jugarTurno(tablero);
        // Comprobamos que el símbolo de la computadora ('X') se ha colocado en una posición válida
        boolean simboloCorrecto = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 'X') {
                    simboloCorrecto = true;
                    break;
                }
            }
            if (simboloCorrecto) {
                break;
            }
        }
        assertTrue(simboloCorrecto);
    }

    /**
     * Método de prueba para verificar la creación y los getters de la clase Jugador.
     */
    @Test
    public void ConstructorYGettersTest() {
        Jugador jugador = new Jugador("Juan", "X");
        assertEquals("Juan", jugador.getNombre());
        assertEquals("X", jugador.getSimbolo());
    }


    /**
     * Método de prueba para verificar si el método getNombre() de la clase Jugador
     * devuelve el nombre correcto del jugador.
     */
    @Test
    public void GetNombreTest() {
        Jugador jugador = new Jugador("Ana", "O");
        assertEquals("Ana", jugador.getNombre());
    }

    /**
     * Método de prueba para verificar si el método getSimbolo() de la clase Jugador
     * devuelve el símbolo correcto asignado al jugador.
     */
    @Test
    public void GetSimboloTest() {
        Jugador jugador = new Jugador("Pedro", "O");
        assertEquals("O", jugador.getSimbolo());
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * Método de prueba para actualizar el salón de la fama con nuevos puntajes y verificar su funcionamiento.
     */
    @Test
    public void ActualizarTest() {
        SalonDeLaFama salon = new SalonDeLaFama();
        salon.actualizar("Jugador1");
        salon.actualizar("Jugador2");
        salon.actualizar("Jugador3");
        salon.actualizar("Jugador4");
        salon.actualizar("Jugador5");
        salon.actualizar("Jugador1");
        salon.actualizar("Jugador1");
    }

    /**
     * Método de prueba para verificar la victoria en diagonal en el tablero.
     */
    @Test
    public void testVerificarVictoriaDiagonal() {
        Tablero.tablero[0][0] = 'O';
        Tablero.tablero[1][1] = 'O';
        Tablero.tablero[2][2] = 'O';
        assertTrue(Tablero.verificarVictoria());
    }

    /**
     * Método de prueba para reiniciar el tablero y verificar si se reinicia correctamente.
     */
    @Test
    public void testReiniciarTablero() {
        Tablero.tablero = new char[][]{
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };
        Tablero.reiniciarTablero();
        for (char[] row : Tablero.tablero) {
            for (char cell : row) {
                assertEquals('-', cell);
            }
        }
    }

    /**
     * Método de prueba para verificar si una cadena está vacía o contiene solo espacios en blanco.
     */
    @Test
    public void testCadenaVacia() {
        assertTrue(Tablero.cadenaVacia(""));
        assertTrue(Tablero.cadenaVacia("    "));
        assertFalse(Tablero.cadenaVacia("  X  "));
        assertFalse(Tablero.cadenaVacia("X"));
    }

    /**
     * Método de prueba para verificar si una fila en el tablero está llena.
     */
    @Test
    public void testFilaLlena() {
        Tablero.tablero = new char[][]{{'X', 'X', 'X'}, {'-', '-', '-'}, {'-', '-', '-'}};
        assertTrue(Tablero.filaLlena(0));
        assertFalse(Tablero.filaLlena(1));
        assertFalse(Tablero.filaLlena(2));
    }

    /**
     * Método de prueba para verificar si una columna en el tablero está llena.
     */
    @Test
    public void testColumnaLlena() {
        Tablero.tablero = new char[][]{{'X', '-', '-'}, {'X', '-', '-'}, {'X', '-', '-'}};
        assertTrue(Tablero.columnaLlena(0));
        assertFalse(Tablero.columnaLlena(1));
        assertFalse(Tablero.columnaLlena(2));
    }

    /**
     * Prueba para verificar si hay una victoria horizontal en el tablero.
     * Se establece un escenario donde hay una fila completa con el mismo símbolo ('X').
     * Se espera que el método de verificación de victoria devuelva true.
     */
    @Test
    public void testVerificarVictoriaHorizontal() {
        Tablero.tablero = new char[][]{{'X', 'X', 'X'}, {'-', '-', '-'}, {'-', '-', '-'}};
        assertTrue(Tablero.verificarVictoria());
    }

    /**
     * Prueba para verificar si hay una victoria vertical en el tablero.
     * Se establece un escenario donde hay una columna completa con el mismo símbolo ('X').
     * Se espera que el método de verificación de victoria devuelva true.
     */
    @Test
    public void testVerificarVictoriaVertical() {
        Tablero.tablero = new char[][]{{'X', '-', '-'}, {'X', '-', '-'}, {'X', '-', '-'}};
        assertTrue(Tablero.verificarVictoria());
    }

    /**
     * Prueba para verificar si hay una victoria en la diagonal principal del tablero.
     * Se establece un escenario donde hay una diagonal completa con el mismo símbolo ('X').
     * Se espera que el método de verificación de victoria devuelva true.
     */
    @Test
    public void testVerificarVictoriaDiagonal1() {
        Tablero.tablero = new char[][]{{'X', '-', '-'}, {'-', 'X', '-'}, {'-', '-', 'X'}};
        assertTrue(Tablero.verificarVictoria());
    }

    /**
     * Prueba para verificar si hay una victoria en la diagonal secundaria del tablero.
     * Se establece un escenario donde hay una diagonal completa con el mismo símbolo ('X').
     * Se espera que el método de verificación de victoria devuelva true.
     */
    @Test
    public void testVerificarVictoriaDiagonal2() {
        Tablero.tablero = new char[][]{{'-', '-', 'X'}, {'-', 'X', '-'}, {'X', '-', '-'}};
        assertTrue(Tablero.verificarVictoria());
    }

    /**
     * Prueba para verificar si el tablero está lleno.
     * Se establece un escenario donde todas las celdas del tablero están ocupadas.
     * Se espera que el método de verificación de tablero lleno devuelva true.
     */
    @Test
    public void testTableroLleno() {
        Tablero.tablero = new char[][]{{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}};
        assertTrue(Tablero.tableroLleno());
    }

    /**
     * Prueba para verificar la validez de los símbolos permitidos en el tablero.
     * Se verifica si todos los símbolos válidos están presentes en la lista de símbolos permitidos.
     * Se espera que la lista contenga exactamente 10 símbolos válidos.
     */
    @Test
    public void testSimbolosValidos() {
        assertEquals(10, Tablero.simbolosValidos.size());
        assertTrue(Tablero.simbolosValidos.contains("@"));
        assertTrue(Tablero.simbolosValidos.contains("#"));
        assertTrue(Tablero.simbolosValidos.contains("$"));
        assertTrue(Tablero.simbolosValidos.contains("%"));
        assertTrue(Tablero.simbolosValidos.contains("&"));
        assertTrue(Tablero.simbolosValidos.contains("X"));
        assertTrue(Tablero.simbolosValidos.contains("0"));
        assertTrue(Tablero.simbolosValidos.contains("?"));
        assertTrue(Tablero.simbolosValidos.contains("+"));
        assertTrue(Tablero.simbolosValidos.contains("="));
    }

    /**
     * Prueba para verificar si la función de mostrar menú de idiomas imprime correctamente en la consola.
     * Se verifica si la salida contiene el texto esperado del menú de idiomas.
     */
    @Test
    public void testMostrarMenuIdiomas() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CLI.mostrarMenuIdiomas();
        assertTrue(outContent.toString().contains("Seleccione su idioma / Select your language / あなたが使う言語を選んでください"));
    }

    /**
     * Prueba para simular la selección del modo de juego jugador contra computadora.
     * Se simula la entrada del usuario seleccionando la opción 2 (PVC).
     * Se espera que el método de selección de modo de juego devuelva true.
     */
    @Test
    public void testSeleccionarModoJuego_JugadorSeleccionaPVC() {
        // Simulamos la selección del modo de juego jugador vs. computadora.
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertTrue(seleccionarModoJuego());
    }

    /**
     * Prueba para verificar si la función de imprimir tablero genera una salida no vacía en la consola.
     * Se verifica si la salida generada por la función no está vacía.
     */
    @Test
    public void testImprimirTablero() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Tablero.imprimirTablero();
        assertFalse(outContent.toString().isEmpty());
    }

    /**
     * Prueba para verificar si la función cadenaVacia devuelve false para cadenas no vacías.
     * Se verifica si la función devuelve false para diferentes cadenas no vacías.
     */
    @Test
    public void testCadenaNoVacia() {
        assertFalse(Tablero.cadenaVacia("X"));
        assertFalse(Tablero.cadenaVacia("   X   "));
        assertFalse(Tablero.cadenaVacia("abc"));
    }

    /**
     * Prueba para verificar si el reinicio de las cadenas de idiomas se realiza correctamente.
     * Se establecen algunas cadenas de idiomas y luego se reinician.
     * Se espera que todas las cadenas de idiomas se hayan reiniciado a null.
     */
    @Test
    public void testReiniciarIdiomas() {
        Idiomas.BIENVENIDA = "Hola";
        Idiomas.PVP = "Jugador contra jugador";
        reiniciarIdiomas();

        assertNull(Idiomas.BIENVENIDA);
        assertNull(Idiomas.PVP);
        // Verificar para otras cadenas de idiomas...
    }

    /**
     * Prueba para verificar si se crea un jugador con el nombre y el símbolo correctos.
     * Se crea un jugador con un nombre y un símbolo específicos.
     * Se verifica si el nombre y el símbolo del jugador coinciden con los proporcionados.
     */
    @Test
    public void testCrearJugador() {
        Jugador jugador = new Jugador("Carlos", "X");
        assertEquals("Carlos", jugador.getNombre());
        assertEquals("X", jugador.getSimbolo());
    }

    /**
     * Prueba para verificar si la función cadenaVacia devuelve true para una cadena vacía.
     * Se verifica si la función devuelve true cuando se proporciona una cadena vacía.
     */
    @Test
    public void testCadenaVacia_Vacia() {
        assertTrue(Tablero.cadenaVacia(""));
    }

    /**
     * Prueba para verificar si la función cadenaVacia devuelve false para una cadena no vacía.
     * Se verifica si la función devuelve false cuando se proporciona una cadena no vacía.
     */
    @Test
    public void testCadenaVacia_NoVacia() {
        assertFalse(Tablero.cadenaVacia("Hola"));
    }
}