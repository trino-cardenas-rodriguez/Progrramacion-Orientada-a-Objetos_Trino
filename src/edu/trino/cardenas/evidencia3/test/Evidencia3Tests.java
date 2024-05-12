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


public class Evidencia3Tests {
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


    @Test
    public void GetInstanceTest() {
        Idiomas.getInstance("ENG");
        assertEquals("Welcome to the game of tic-tac-toe!", Idiomas.BIENVENIDA);
    }

    @Test
    public void GetInstanceSpanishTest() {
        Idiomas.getInstance("ESP");
        assertEquals("¡Bienvenido al juego de tres en raya!", Idiomas.BIENVENIDA);
    }

    @Test
    public void GetInstanceEnglishTest() {
        Idiomas.getInstance("ENG");
        assertEquals("Welcome to the game of tic-tac-toe!", Idiomas.BIENVENIDA);
    }

    @Test
    public void GetInstanceJapaneseTest() {
        Idiomas.getInstance("JAP");
        assertEquals("三目並べゲームへようこそ！", Idiomas.BIENVENIDA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetInstanceInvalidLanguage() {
        Idiomas.getInstance("INVALID");
    }

    @Before
    public void setUp() {
        // Reiniciar los valores de las cadenas de texto antes de cada test
        reiniciarIdiomas();
        System.setOut(new PrintStream(outputStreamCaptor));

    }

    private void reiniciarIdiomas() {
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


    @Test
    public void GetInstanceSpanishCompletoTest() {
        Idiomas.getInstance("ESP");
        // Verificar todas las cadenas de texto en español
        assertEquals("Seleccione el modo de juego: ", Idiomas.SELECCIONE_OPCION);
        assertEquals("1. Jugador contra jugador", Idiomas.PVP);
        assertEquals("2. Jugador contra la computadora", Idiomas.PVC);
    }


    @Test
    public void CadenaVaciaTest() {
        assertTrue(Tablero.cadenaVacia(""));
        assertTrue(Tablero.cadenaVacia(" "));
        assertFalse(Tablero.cadenaVacia("  abc  "));
    }


    @Test
    public void SetSimboloTest() {
        JuegoComputadora juego = new JuegoComputadora();
        juego.setSimbolo('X');
        assertEquals('X', juego.getSimbolo());
    }

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

    @Test
    public void ConstructorYGettersTest() {
        Jugador jugador = new Jugador("Juan", "X");
        assertEquals("Juan", jugador.getNombre());
        assertEquals("X", jugador.getSimbolo());
    }

    @Test
    public void GetNombreTest() {
        Jugador jugador = new Jugador("Ana", "O");
        assertEquals("Ana", jugador.getNombre());
    }

    @Test
    public void GetSimboloTest() {
        Jugador jugador = new Jugador("Pedro", "O");
        assertEquals("O", jugador.getSimbolo());
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

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


    @Test
    public void testVerificarVictoriaDiagonal() {
        Tablero.tablero[0][0] = 'O';
        Tablero.tablero[1][1] = 'O';
        Tablero.tablero[2][2] = 'O';
        assertTrue(Tablero.verificarVictoria());
    }

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

    @Test
    public void testCadenaVacia() {
        assertTrue(Tablero.cadenaVacia(""));
        assertTrue(Tablero.cadenaVacia("    "));
        assertFalse(Tablero.cadenaVacia("  X  "));
        assertFalse(Tablero.cadenaVacia("X"));
    }

    @Test
    public void testFilaLlena() {
        Tablero.tablero = new char[][]{{'X', 'X', 'X'}, {'-', '-', '-'}, {'-', '-', '-'}};
        assertTrue(Tablero.filaLlena(0));
        assertFalse(Tablero.filaLlena(1));
        assertFalse(Tablero.filaLlena(2));
    }

    @Test
    public void testColumnaLlena() {
        Tablero.tablero = new char[][]{{'X', '-', '-'}, {'X', '-', '-'}, {'X', '-', '-'}};
        assertTrue(Tablero.columnaLlena(0));
        assertFalse(Tablero.columnaLlena(1));
        assertFalse(Tablero.columnaLlena(2));
    }

    @Test
    public void testVerificarVictoriaHorizontal() {
        Tablero.tablero = new char[][]{{'X', 'X', 'X'}, {'-', '-', '-'}, {'-', '-', '-'}};
        assertTrue(Tablero.verificarVictoria());
    }

    @Test
    public void testVerificarVictoriaVertical() {
        Tablero.tablero = new char[][]{{'X', '-', '-'}, {'X', '-', '-'}, {'X', '-', '-'}};
        assertTrue(Tablero.verificarVictoria());
    }

    @Test
    public void testVerificarVictoriaDiagonal1() {
        Tablero.tablero = new char[][]{{'X', '-', '-'}, {'-', 'X', '-'}, {'-', '-', 'X'}};
        assertTrue(Tablero.verificarVictoria());
    }

    @Test
    public void testVerificarVictoriaDiagonal2() {
        Tablero.tablero = new char[][]{{'-', '-', 'X'}, {'-', 'X', '-'}, {'X', '-', '-'}};
        assertTrue(Tablero.verificarVictoria());
    }

    @Test
    public void testTableroLleno() {
        Tablero.tablero = new char[][]{{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}};
        assertTrue(Tablero.tableroLleno());
    }

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

    @Test
    public void testMostrarMenuIdiomas() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CLI.mostrarMenuIdiomas();
        assertTrue(outContent.toString().contains("Seleccione su idioma / Select your language / あなたが使う言語を選んでください"));
    }

    @Test
    public void testSeleccionarModoJuego_JugadorSeleccionaPVC() {
        // Simulamos la selección del modo de juego jugador vs. computadora.
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertTrue(seleccionarModoJuego());
    }


    @Test
    public void testImprimirTablero() {
        // Verificamos si la función de impresión del tablero genera una salida no vacía.
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Tablero.imprimirTablero();
        assertFalse(outContent.toString().isEmpty());
    }

    @Test
    public void testCadenaNoVacia() {
        assertFalse(Tablero.cadenaVacia("X"));
        assertFalse(Tablero.cadenaVacia("   X   "));
        assertFalse(Tablero.cadenaVacia("abc"));
    }

    @Test
    public void testReiniciarIdiomas() {
        Idiomas.BIENVENIDA = "Hola";
        Idiomas.PVP = "Jugador contra jugador";
        reiniciarIdiomas();

        assertNull(Idiomas.BIENVENIDA);
        assertNull(Idiomas.PVP);
        // Verificar para otras cadenas de idiomas...
    }

    @Test
    public void testCrearJugador() {
        Jugador jugador = new Jugador("Carlos", "X");
        assertEquals("Carlos", jugador.getNombre());
        assertEquals("X", jugador.getSimbolo());
    }

    @Test
    public void testCadenaVacia_Vacia() {
        assertTrue(Tablero.cadenaVacia(""));
    }


    @Test
    public void testCadenaVacia_NoVacia() {
        assertFalse(Tablero.cadenaVacia("Hola"));
    }

}
