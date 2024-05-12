package edu.trino.cardenas.evidencia3.ui;

public class Idiomas {
    public static String BIENVENIDA;
    public static String SELECCIONE_OPCION;
    public static String PVP;
    public static String PVC;
    public static String JUGAR_NUEVAMENTE;
    public static String RESPUESTA_INVALIDA;
    public static String GRACIAS_POR_JUGAR;
    public static String NUEVA_PARTIDA;
    public static String NOMBRE_JUGADOR_1;
    public static String NOMBRE_VACIO;
    public static String SIMBOLO_JUGADOR_1;
    public static String SIMBOLO_NO_VALIDO;
    public static String INGRESE_SIMBOLO;
    public static String NOMBRE_JUGADOR_2;
    public static String NOMBRE_JUGADOR_2_DIFERENTE;
    public static String SIMBOLO_JUGADOR_2;
    public static String SIMBOLO_NO_VALIDO_DIFERENTE;
    public static String HA_GANADO;
    public static String EMPATE;
    public static String NOMBRE;
    public static String TURNO;
    public static String FILA;
    public static String FILA_INVALIDA;
    public static String NUMERO_INVALIDO;
    public static String COLUMNA;
    public static String COLUMNA_INVALIDA;
    public static String CASILLA_OCUPADA;
    public static String ERROR_INICIALIZACION;
    public static String TABLERO;
    public static String COMPUTADORA_HA_JUGADO;
    public static String OPCION_INVALIDA;
    public static String ERROR_INESPERADO;

    public static void getInstance(String idioma) {
        Textos opcion = Textos.valueOf(idioma);
        switch (opcion) {
            case ESP:
                BIENVENIDA = "¡Bienvenido al juego de tres en raya!";
                SELECCIONE_OPCION = "Seleccione el modo de juego: ";
                PVP = "1. Jugador contra jugador";
                PVC = "2. Jugador contra la computadora";
                JUGAR_NUEVAMENTE = "¿Desean jugar nuevamente? (si/no)";
                RESPUESTA_INVALIDA = "Respuesta inválida. Por favor, ingrese 'si' " +
                        "para jugar nuevamente o 'no' para terminar.";
                GRACIAS_POR_JUGAR = "Gracias por jugar. ¡Hasta luego!";
                NUEVA_PARTIDA = "Comencemos una nueva partida...";
                NOMBRE_JUGADOR_1 = "Ingrese el nombre del jugador 1: ";
                NOMBRE_VACIO = "El nombre no puede estar vacío. Inténtelo de nuevo.";
                SIMBOLO_JUGADOR_1 = "Ingrese el símbolo del jugador 1 (@ # $ % & X 0 ? + =): ";
                SIMBOLO_NO_VALIDO = "El símbolo ingresado no es válido. Por favor, elija un símbolo de la lista.";
                INGRESE_SIMBOLO = "Ingrese su símbolo (@ # $ % & X 0 ? + =): ";
                NOMBRE_JUGADOR_2 = "Ingrese el nombre del jugador 2: ";
                NOMBRE_JUGADOR_2_DIFERENTE = "El nombre del segundo jugador no puede ser " +
                        "igual al del primero. Inténtelo de nuevo.";
                SIMBOLO_JUGADOR_2 = "Ingrese el símbolo del jugador 2 (diferente a: ";
                SIMBOLO_NO_VALIDO_DIFERENTE = "El símbolo ingresado no es válido. " +
                        "Por favor, elija un símbolo de la lista diferente a: ";
                HA_GANADO = " ha ganado!";
                EMPATE = "¡El tablero está lleno! ¡Es un empate!";
                NOMBRE = "Ingrese su nombre: ";
                TURNO = "Turno de ";
                FILA = "Ingrese la fila (1-3): ";
                FILA_INVALIDA = "Fila inválida o llena. Debe ser un número entre 1 y 3 y no debe estar llena.";
                NUMERO_INVALIDO = "Debe ingresar un número de un solo digito entre 1 y 3. Inténtelo de nuevo.";
                COLUMNA = "Ingrese la columna (1-3): ";
                COLUMNA_INVALIDA = "Columna inválida o llena. Debe ser un número entre 1 y 3 y no debe estar llena.";
                CASILLA_OCUPADA = "La casilla seleccionada está ocupada. Intente de nuevo.";
                ERROR_INICIALIZACION = "Error: falta de inicialización de variables.";
                TABLERO = "Tablero:";
                COMPUTADORA_HA_JUGADO = "La computadora ha jugado en la posición [";

                OPCION_INVALIDA = "Opción inválida. Por favor, seleccione una opción válida.";
                ERROR_INESPERADO = "Error inesperado ";
                break;

            case ENG:
                BIENVENIDA = "Welcome to the game of tic-tac-toe!";
                SELECCIONE_OPCION = "Select game mode: ";
                PVP = "1. Player vs. player";
                PVC = "2. Player against computer";
                JUGAR_NUEVAMENTE = "Do you wish to play again? (yes/no)";
                RESPUESTA_INVALIDA = "Invalid answer. Please enter ‘yes’ to play again or ‘no’ to end.";
                GRACIAS_POR_JUGAR = "Thank you for playing. See you later!";
                NUEVA_PARTIDA = "Let's start a new game...";
                NOMBRE_JUGADOR_1 = "Enter the name of player 1: ";
                NOMBRE_VACIO = "The name cannot be empty. Please try again.";
                SIMBOLO_JUGADOR_1 = "Enter the symbol of player 1 (@ # $ % & X 0 ? + =): ";
                SIMBOLO_NO_VALIDO = "The entered symbol is invalid. Please choose a symbol from the list.";
                INGRESE_SIMBOLO = "Enter your symbol (@ # $ % & X 0 ? + =): ";
                NOMBRE_JUGADOR_2 = "Enter the name of player 2: ";
                NOMBRE_JUGADOR_2_DIFERENTE = "The second player's name cannot be the same as the first " +
                        "player's name. Please try again.";
                SIMBOLO_JUGADOR_2 = "Enter player 2’s symbol (other than: ";
                SIMBOLO_NO_VALIDO_DIFERENTE = "The entered symbol is invalid. Please choose a symbol " +
                        "from the list other than: ";
                HA_GANADO = " have won!";
                EMPATE = "The board is full! It's a draw!";
                NOMBRE = "Enter your name: ";
                TURNO = "Turn of ";
                FILA = "Enter row (1-3): ";
                FILA_INVALIDA = "Invalid or full row. Must be a number between 1 and 3 and must not be full";
                NUMERO_INVALIDO = "You must enter a single digit number between 1 and 3. Try again.";
                COLUMNA = "Enter column (1-3): ";
                COLUMNA_INVALIDA = "Invalid or full column. Must be a number between 1 and 3 and must not be full.";
                CASILLA_OCUPADA = "The selected column is already full. Please try again.";
                ERROR_INICIALIZACION = "Error: variable initialisation failed.";
                TABLERO = "Board:";
                COMPUTADORA_HA_JUGADO = "The computer has played in position [";

                OPCION_INVALIDA = "Invalid option. Please select a valid option.";
                ERROR_INESPERADO = "Unexpected error ";
                break;

            case JAP:
                BIENVENIDA = "三目並べゲームへようこそ！";
                SELECCIONE_OPCION = "ゲームモードを選択します: ";
                PVP = "一.プレイヤー対プレイヤー";
                PVC = "二.プレイヤー対コンピューター";
                JUGAR_NUEVAMENTE = "また遊びたいですか? （しかし）";
                RESPUESTA_INVALIDA = "無効な回答です。もう一度再生するには「はい」を入力し、終了するには「いいえ」を入力してください。";
                GRACIAS_POR_JUGAR = "遊んでくれてありがとう。また後で！";
                NUEVA_PARTIDA = "新しいゲームを始めましょう...";
                NOMBRE_JUGADOR_1 = "プレイヤーの名前を入力してください 一: ";
                NOMBRE_VACIO = "名前を空にすることはできません。もう一度やり直してください。";
                SIMBOLO_JUGADOR_1 = "選手シンボルを入力してください 一(@ # $ % & X 0 ? + =): ";
                SIMBOLO_NO_VALIDO = "入力された記号は無効です。リストから記号を選択してください。";
                INGRESE_SIMBOLO = "記号を入力してください (@ # $ % & X 0 ? + =): ";
                NOMBRE_JUGADOR_2 = "プレイヤーの名前を入力してください 二: ";
                NOMBRE_JUGADOR_2_DIFERENTE = "番目のプレーヤーの名前は最初のプレーヤーと同じであってはなりません。" +
                        "もう一度やり直してください。";
                SIMBOLO_JUGADOR_2 = "選手シンボルを入力してください 二 (次とは異なります: ";
                SIMBOLO_NO_VALIDO_DIFERENTE = "入力された記号は無効です。別のリストからシンボルを選択してください：";
                HA_GANADO = " が勝ちました！";
                EMPATE = "ボードがいっぱいです！引き分けです！";
                NOMBRE = "名前を入力してください：";
                TURNO = "の番です。";
                FILA = "行を入力してください (一-三): ";
                FILA_INVALIDA = "無効な行、または完全な行。一から三までの数字で、一杯であってはならない。";
                NUMERO_INVALIDO = "一から三までの一桁の数字を入力してください。もう一度入力してください。";
                COLUMNA = "列を入力してください (一-三): ";
                COLUMNA_INVALIDA = "列が無効または一杯です。一から三までの数字で、一杯であってはなりません。";
                CASILLA_OCUPADA = "選択したマスはすでに埋まっています。もう一度お試しください。";
                ERROR_INICIALIZACION = "エラー：変数の初期化が不足しています。";
                TABLERO = "ボード：";
                COMPUTADORA_HA_JUGADO = "コンピュータはポジションにプレイしました［";

                OPCION_INVALIDA = "無効なオプションです。有効なオプションを選択してください。 ";
                ERROR_INESPERADO = "予期しないエラー ";
                break;
            default:
                throw new IllegalArgumentException("Invalid language selection");
        }
    }

    private enum Textos {
        ESP, ENG, JAP
    }
}
