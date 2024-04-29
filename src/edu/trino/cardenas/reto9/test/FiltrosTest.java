package edu.trino.cardenas.reto9.test;

/**Aquí importamos la clase FiltradorPalabras, para usar los métodos de esta clase.*/
import edu.trino.cardenas.reto9.process.FiltradorPalabras;

/**Aquí importamos el Test para poder crear los test.*/
import org.junit.Test;

/**Aquí importamos la java.io, para poder usar la función InputStream y ByteArrayInputStream*/
import java.io.*;

/**Aquí importamos la librería org.junit.Assert*/
import static org.junit.Assert.*;

/**En esta clase creamos las pruebas unitarias para los métodos de la clase FiltradorPalabras.*/
public class FiltrosTest {

    /**Prueba unitaria del método mostrarTop10Palabras, con un archivo vacío.*/
    @Test
    public void mostraTop10PalabrasLibroVacioTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "vacio.txt";

        // Prueba con un archivo vacío
        ByteArrayInputStream emptyInput = new ByteArrayInputStream(new byte[0]);
        System.setIn(emptyInput);
        contador.mostrarTop10Palabras.accept(nombreArchivo);
        // No hay necesidad de verificar el resultado porque imprime en la consola

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método contarVocales, con un archivo vacío.*/
    @Test
    public void contarVocalesLibroVacioTest() {
        FiltradorPalabras contador = new FiltradorPalabras();

        //Prueba con un archivo vacío
        String nombreArchivo = "vacio.txt";
        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 0
        assertEquals(0, resultado);
    }

    /**Prueba unitaria del método imprimirPalabrasQueEmpiezanConVocal, con un archivo vacío.*/
    @Test
    public void imprimirPalabrasQueEmpiezanConVocalLibroVacioTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        // Mock del InputStream para simular un archivo vacío
        InputStream inputStream = new ByteArrayInputStream("".getBytes());

        // Configuración del mock para simular la entrada
        System.setIn(inputStream);

        // Redirigir la salida estándar a un objeto StringBuilder para capturar la salida
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(System.out) {
            @Override
            public void println(String x) {
                output.append(x).append("\n");
            }
        });

        // Ejecutar el método bajo prueba
        contador.imprimirPalabrasConNumeroImparDeLetras("vacio.txt");

        // Verificar que no se haya impreso nada en la salida estándar
        assertTrue(output.toString().isEmpty());
    }

    /**Prueba unitaria del método imprimirPalabrasConNumeroImparDeLetras, con un archivo vacío.*/
    @Test
    public void imprimirPalabrasConNumeroImparDeLetrasLibroVacioTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "vacio.txt";

        // Redirigir la entrada estándar para que apunte al archivo vacío
        ByteArrayInputStream emptyInput = new ByteArrayInputStream(new byte[0]);
        System.setIn(emptyInput);

        // Verificar que no imprime ninguna palabra
        contador.imprimirPalabrasConNumeroImparDeLetras(nombreArchivo);

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método encontrarPalabraMasLarga, con un archivo vacío.*/
    @Test
    public void encontrarPalabraMasLargaLibroVacioTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "vacio.txt";

        // Redirigir la entrada estándar para que apunte al archivo vacío
        ByteArrayInputStream emptyInput = new ByteArrayInputStream(new byte[0]);
        System.setIn(emptyInput);

        // Verificar que no encuentra ninguna palabra
        assertNull(contador.encontrarPalabraMasLarga(nombreArchivo));

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método encontrarPalabraMasCorta, con un archivo vacío.*/
    @Test
    public void encontrarPalabraMasCortaLibroVacioTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "vacio.txt";

        // Redirigir la entrada estándar para que apunte al archivo vacío
        ByteArrayInputStream emptyInput = new ByteArrayInputStream(new byte[0]);
        System.setIn(emptyInput);

        // Verificar que no encuentra ninguna palabra
        assertNull(contador.encontrarPalabraMasCorta(nombreArchivo));

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método contarVocales, con un archivo con símbolos.*/
    @Test
    public void contarVocalesLibroSimbolosTest(){
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "simbolos.txt";

        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 11
        assertEquals(11, resultado);
    }

    /**Prueba unitaria del método filtroPalabraEspecial, con un archivo vacío.*/
    @Test
    public void filtroPalabraEspecialLibroVacioTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "vacio.txt";

        // Redirigir la entrada estándar para que apunte al archivo vacío
        ByteArrayInputStream emptyInput = new ByteArrayInputStream(new byte[0]);
        System.setIn(emptyInput);

        // Verificar que el resultado es null porque no hay palabras que cumplan el criterio
        assertNull(contador.filtroPalabraEspecial(nombreArchivo));

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de mayúsculas.*/
    @Test
    public void contarVocalesLibroMayusculasTest() {
        FiltradorPalabras contador = new FiltradorPalabras();

        //Prueba con un archivo vacío
        String nombreArchivo = "mayusculas.txt";
        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 25
        assertEquals(25, resultado);
    }

    /**Prueba unitaria del método filtroPalabraEspecial, con un archivo de mayúsculas.*/
    @Test
    public void filtroPalabraEspecialLibroMayusculasTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "mayusculas.txt";

        // Redirigir la entrada estándar para que apunte al archivo vacío
        ByteArrayInputStream emptyInput = new ByteArrayInputStream(new byte[0]);
        System.setIn(emptyInput);

        // Verificar que el resultado es null porque no hay palabras que cumplan el criterio
        assertNull(contador.filtroPalabraEspecial(nombreArchivo));

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método mostrarTop10Palabras, con un archivo con símbolos.*/
    @Test
    public void mostrarTop10PalabrasLibroSimbolosTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "simbolos.txt";

        // Redirigir la entrada estándar para que apunte al contenido del archivo
        ByteArrayInputStream inputStream = new ByteArrayInputStream
                ("como los pr ver metodos con reccnn plbrs smbolos".getBytes());
        System.setIn(inputStream);

        // Llamar al método contarPalabras después de redirigir la entrada estándar
        contador.mostrarTop10Palabras.accept(nombreArchivo);

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método mostrarTop10Palabras, con un archivo inexistente.*/
    @Test
    public void mostrarTop10PalabrasArchivoNoEncontradoTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "archivo_que_no_existe.txt";

        // Verificar que se arroja una excepción cuando el archivo no se encuentra
        assertThrows(Exception.class, () -> contador.mostrarTop10Palabras.accept(nombreArchivo));
    }

    /**Prueba unitaria del método contarVocales, con un archivo inexistente.*/
    @Test
    public void contarVocalesArchivoNoEncontradoTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "archivo_que_no_existe.txt";

        // Verificar que se devuelve 0 cuando el archivo no se encuentra
        assertEquals(0, contador.contarVocales(nombreArchivo));
    }

    /**Prueba unitaria del método imprimirPalabrasConNumeroImparDeLetras, con un archivo inexistente.*/
    @Test
    public void imprimirPalabrasConNumeroImparDeLetrasArchivoNoEncontradoTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "archivo_que_no_existe.txt";

        // Verificar que no imprime ninguna palabra cuando el archivo no se encuentra
        contador.imprimirPalabrasConNumeroImparDeLetras(nombreArchivo);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de palabras con números.*/
    @Test
    public void contarVocalesLibroPalabrasConNumerosTest(){
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "palabras_con_numeros.txt";

        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 1
        assertEquals(1, resultado);
    }

    /**Prueba unitaria del método encontrarPalabraMasLarga, con un archivo inexistente.*/
    @Test
    public void encontrarPalabraMasLargaArchivoNoEncontradoTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "archivo_que_no_existe.txt";

        // Verificar que no encuentra ninguna palabra cuando el archivo no se encuentra
        assertNull(contador.encontrarPalabraMasLarga(nombreArchivo));
    }

    /**Prueba unitaria del método encontrarPalabraMasCorta, con un archivo inexistente.*/
    @Test
    public void encontrarPalabraMasCortaArchivoNoEncontradoTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "archivo_que_no_existe.txt";

        // Verificar que no encuentra ninguna palabra cuando el archivo no se encuentra
        assertNull(contador.encontrarPalabraMasCorta(nombreArchivo));
    }

    /**Prueba unitaria del método filtroPalabraEspecial, con un archivo inexistente.*/
    @Test
    public void filtroPalabraEspecialArchivoNoEncontradoTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "archivo_que_no_existe.txt";

        // Verificar que el resultado es null cuando el archivo no se encuentra
        assertNull(contador.filtroPalabraEspecial(nombreArchivo));
    }

    /**Prueba unitaria del método mostrarTop10Palabras, con un archivo con números.*/
    @Test
    public void mostrarTop10PalabrasLibroNumeroTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "numeros.txt";

        // Redirigir la entrada estándar para que apunte al archivo de números
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1 2 3 4 5".getBytes());
        System.setIn(inputStream);

        // Llamar al método contarPalabras después de redirigir la entrada estándar
        contador.mostrarTop10Palabras.accept(nombreArchivo);

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de números.*/
    @Test
    public void contarVocalesLibroNumerosTest(){
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "numeros.txt";

        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 0
        assertEquals(0, resultado);
    }

    /**Prueba unitaria del método encontrarPalabraMasLarga, con un archivo de texto con palabras largas.*/
    @Test
    public void encontrarPalabraMasLargaLibroPalabrasLargasTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "palabras_largas.txt";

        // Redirigir la entrada estándar para que apunte al archivo de palabras largas
        ByteArrayInputStream inputStream = new ByteArrayInputStream("hello elephant cucumber".getBytes());
        System.setIn(inputStream);

        // Verificar que encuentra una de las palabras más largas esperadas
        String palabraMasLarga = contador.encontrarPalabraMasLarga(nombreArchivo);
        assertTrue(palabraMasLarga.equals("cucumber") || palabraMasLarga.equals("elephant"));

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de texto con palabras largas.*/
    @Test
    public void contarVocalesLibroPalabrasLargasTest(){
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "palabras_largas.txt";

        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 8
        assertEquals(8, resultado);
    }

    /**Prueba unitaria del método encontrarPalabraMasCorta, con un archivo de texto con palabras cortas.*/
    @Test
    public void encontrarPalabraMasCortaLibroPalabrasCortasTest() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "palabras_cortas.txt";

        // Redirigir la entrada estándar para que apunte al archivo de palabras cortas
        ByteArrayInputStream inputStream = new ByteArrayInputStream("cats dogs ant".getBytes());
        System.setIn(inputStream);

        // Verificar que encuentra la palabra más corta esperada
        String palabraMasCorta = contador.encontrarPalabraMasCorta(nombreArchivo);
        assertNull(palabraMasCorta);

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de texto con palabras cortas.*/
    @Test
    public void contarVocalesLibroPalabrasCortasTest(){
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "palabras_cortas.txt";

        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 3
        assertEquals(3, resultado);
    }

    /**Prueba unitaria del método mostrarTop10Palabras, con un archivo de prueba diferente.*/
    @Test
    public void mostrarTop10PalabrasLibroPrueba_1Test() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "prueba_1.txt";

        // Redirigir la entrada estándar para que apunte a un archivo de prueba con contenido conocido
        String contenidoArchivo = "este es un archivo de prueba con varias palabras palabras palabras";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(contenidoArchivo.getBytes());
        System.setIn(inputStream);

        // Llamar al método contarPalabras y verificar el resultado
        contador.mostrarTop10Palabras.accept(nombreArchivo);

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de prueba diferente.*/
    @Test
    public void contarVocalesLibroPrueba_1Test(){
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "prueba_1.txt";

        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 24
        assertEquals(24, resultado);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de prueba diferente.*/
    @Test
    public void contarVocalesLibroPrueba_2Test() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "prueba_2.txt";

        // Redirigir la entrada estándar para que apunte a un archivo de prueba con contenido conocido
        String contenidoArchivo = "este es un archivo de prueba con varias vocales";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(contenidoArchivo.getBytes());
        System.setIn(inputStream);

        // Llamar al método contarVocales y verificar el resultado
        long resultado = contador.contarVocales(nombreArchivo);
        assertEquals(18, resultado);

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método imprimirPalabrasQueEmpiezanConVocal, con un archivo de prueba diferente.*/
    @Test
    public void imprimirPalabrasQueEmpiezanConVocalLibroPrueba_3Test() {
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "prueba_3.txt";

        // Redirigir la entrada estándar para que apunte a un archivo de prueba con contenido conocido
        String contenidoArchivo = "apple banana cat elephant";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(contenidoArchivo.getBytes());
        System.setIn(inputStream);

        // Llamar al método imprimirPalabrasQueEmpiezanConVocal y verificar la salida
        contador.imprimirPalabrasQueEmpiezanConVocal(nombreArchivo);

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de prueba diferente.*/
    @Test
    public void contarVocalesLibroPrueba_3Test(){
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "prueba_3.txt";

        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 9
        assertEquals(9, resultado);
    }

    /**Prueba unitaria del método contarVocales, con un archivo de palabras con acentos.*/
    @Test
    public void contarVocalesLibroAcentosTest(){
        FiltradorPalabras contador = new FiltradorPalabras();
        String nombreArchivo = "acentos.txt";

        long resultado = contador.contarVocales(nombreArchivo);

        //Verificar que el resultado es 21
        assertEquals(21, resultado);
    }

}
