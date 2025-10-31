
public class Tablero {
    // (actualizado) Tablero principal en src/ — usar este y no archivos legacy
    private static final int TAMAÑO = 8;
    private Ficha[][] matriz;

    /**
     * Constructor del tablero
     */
    public Tablero() {
        matriz = new Ficha[TAMAÑO][TAMAÑO];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero colocando las fichas en su posición inicial
     */
    private void inicializarTablero() {
        // Fichas negras en filas A-C (0-2)
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < TAMAÑO; col++) {
                if (esCasillaNegra(fila, col)) matriz[fila][col] = new Ficha("B");
            }
        }
        // Fichas rojas en filas F-H (5-7)
        for (int fila = 5; fila < TAMAÑO; fila++) {
            for (int col = 0; col < TAMAÑO; col++) {
                if (esCasillaNegra(fila, col)) matriz[fila][col] = new Ficha("R");
            }
        }
    }

    /**
     * Verifica si una casilla es negra
     */
    private boolean esCasillaNegra(int fila, int col) {
        return (fila + col) % 2 == 1;
    }

    /**
     * Muestra el estado actual del tablero
     */
    public void mostrarTablero() {
        System.out.println();
        System.out.print("    ");
        for (int c = 1; c <= TAMAÑO; c++) System.out.print(c + "   ");
        System.out.println();
        System.out.println("  +---+---+---+---+---+---+---+---+");
        for (int fila = 0; fila < TAMAÑO; fila++) {
            System.out.print((char) ('A' + fila) + " |");
            for (int col = 0; col < TAMAÑO; col++) {
                Ficha f = matriz[fila][col];
                if (f == null) {
                    System.out.print(esCasillaNegra(fila, col) ? " · |" : "   |");
                } else {
                    System.out.print(" " + f + " |");
                }
            }
            System.out.println();
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }
    }

    /**
     * Verifica si una posición está dentro del tablero
     */
    public boolean esPosicionValida(int fila, int col) {
        return fila >= 0 && fila < TAMAÑO && col >= 0 && col < TAMAÑO;
    }

    /**
     * Obtiene la ficha en una posición específica
     */
    public Ficha obtenerFicha(int fila, int col) {
        if (!esPosicionValida(fila, col)) return null;
        return matriz[fila][col];
    }

    /**
     * Mueve una ficha de una posición a otra
     */
    public boolean moverFicha(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        if (!esMovimientoValido(filaOrigen, colOrigen, filaDestino, colDestino)) return false;
        Ficha ficha = matriz[filaOrigen][colOrigen];
        matriz[filaDestino][colDestino] = ficha;
        matriz[filaOrigen][colOrigen] = null;
        return true;
    }

    /**
     * Verifica si un movimiento es diagonal simple (sin capturas)
     */
    public boolean esMovimientoDiagonalSimple(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        return Math.abs(filaDestino - filaOrigen) == 1 && Math.abs(colDestino - colOrigen) == 1;
    }

    /**
     * Verifica si el movimiento sigue la dirección correcta según el color
     */
    public boolean esDireccionCorrecta(int filaOrigen, int filaDestino, String color) {
        if ("R".equals(color)) return filaDestino < filaOrigen;
        return filaDestino > filaOrigen; // B
    }

    /**
     * Verifica si un movimiento es válido
     */
    public boolean esMovimientoValido(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        if (!esPosicionValida(filaOrigen, colOrigen) || !esPosicionValida(filaDestino, colDestino)) {
            System.out.println("Posición fuera del tablero.");
            return false;
        }
        Ficha ficha = obtenerFicha(filaOrigen, colOrigen);
        if (ficha == null) {
            System.out.println("No hay ficha en la posición de origen.");
            return false;
        }
        if (obtenerFicha(filaDestino, colDestino) != null) {
            System.out.println("La casilla de destino está ocupada.");
            return false;
        }
        if (!esMovimientoDiagonalSimple(filaOrigen, colOrigen, filaDestino, colDestino)) {
            System.out.println("El movimiento debe ser diagonal de una casilla (sin capturas).");
            return false;
        }
        if (!esDireccionCorrecta(filaOrigen, filaDestino, ficha.getColor())) {
            System.out.println("Movimiento en dirección incorrecta para la ficha " + ficha.getColor() + ".");
            return false;
        }
        return true;
    }
}