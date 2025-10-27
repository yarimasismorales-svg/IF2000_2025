import java.util.Scanner;

/*Clase que representa una ficha del juego de damas
 */
class Ficha {
    private String color;
    
    /**Constructor de la ficha
     @param color "R" para rojo, "B" para negro
     */
    public Ficha(String color) {
        this.color = color;
    }
    
    /**
     * Obtiene el color de la ficha
      @return color de la ficha
     */
    public String getColor() {
        return this.color;
    }
    
    @Override
    public String toString() {
        return this.color;
    }
}


class Tablero {
    private static final int TAMAÑO = 8;
    private Ficha[][] matriz;
    
    
    public Tablero() {
        this.matriz = new Ficha[TAMAÑO][TAMAÑO];
        inicializarFichas();
    }
    
    
    private void inicializarFichas() {
        
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < TAMAÑO; col++) {
              
                if ((fila + col) % 2 == 1) {
                    matriz[fila][col] = new Ficha("B");
                }
            }
        }
        
        
        for (int fila = 5; fila < 8; fila++) {
            for (int col = 0; col < TAMAÑO; col++) {
                if ((fila + col) % 2 == 1) {
                    matriz[fila][col] = new Ficha("R");
                }
            }
        }
    }
    
    /*Imprime el tablero en la consola de forma visual*/
    public void mostrarTablero() {
        System.out.println("\n    1   2   3   4   5   6   7   8");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        
        for (int fila = 0; fila < TAMAÑO; fila++) {
            System.out.print((fila + 1) + " |");
            for (int col = 0; col < TAMAÑO; col++) {
                Ficha ficha = matriz[fila][col];
                if (ficha == null) {
                    // Mostrar casilla vacía
                    if ((fila + col) % 2 == 0) {
                        System.out.print("   |");  // Casilla blanca
                    } else {
                        System.out.print(" · |");  // Casilla negra vacía
                    }
                } else {
                    // Mostrar ficha
                    System.out.print(" " + ficha + " |");
                }
            }
            System.out.println();
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }
    }
    
    /**
     * Verifica si una posición está dentro del tablero
     * @param fila fila a verificar
     * @param col columna a verificar
     * @return true si la posición es válida
     */
    public boolean esPosicionValida(int fila, int col) {
        return fila >= 0 && fila < TAMAÑO && col >= 0 && col < TAMAÑO;
    }
    
    /**
     * Obtiene la ficha en una posición específica
     * @param fila fila de la ficha
     * @param col columna de la ficha
     * @return la ficha en esa posición, o null si está vacía
     */
    public Ficha obtenerFicha(int fila, int col) {
        if (esPosicionValida(fila, col)) {
            return matriz[fila][col];
        }
        return null;
    }
    
    /**
     * Mueve una ficha de origen a destino
     * Asume que el movimiento ya fue validado
     * @param filaOrigen fila de origen
     * @param colOrigen columna de origen
     * @param filaDestino fila de destino
     * @param colDestino columna de destino
     */
    public void moverFicha(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        Ficha ficha = matriz[filaOrigen][colOrigen];
        matriz[filaDestino][colDestino] = ficha;
        matriz[filaOrigen][colOrigen] = null;
    }
}


/* Clase que representa el resultado de una validación de movimiento
 */
class ResultadoValidacion {
    private boolean esValido;
    private String mensaje;
    
    public ResultadoValidacion(boolean esValido, String mensaje) {
        this.esValido = esValido;
        this.mensaje = mensaje;
    }
    
    public boolean esValido() {
        return esValido;
    }
    
    public String getMensaje() {
        return mensaje;
    }
}


/* Clase principal que controla el flujo del juego, turnos y validaciones */

class Juego {
    private Tablero tablero;
    private String turnoActual;
    private Scanner scanner;
    
    /*Constructor que inicializa el juego */
    public Juego() {
        this.tablero = new Tablero();
        this.turnoActual = "R";  // Las rojas comienzan
        this.scanner = new Scanner(System.in);
    }
    
    private void cambiarTurno() {
        if (turnoActual.equals("R")) {
            turnoActual = "B";
        } else {
            turnoActual = "R";
        }
    }
    
    /**Obtiene el nombre del color en turno
     * @return nombre del color
     */
    private String obtenerNombreTurno() {
        return turnoActual.equals("R") ? "Rojas" : "Negras";
    }
    
    
    private boolean esMovimientoDiagonal(int filaOrigen, int colOrigen, 
                                        int filaDestino, int colDestino) {
        int diferenciaFila = Math.abs(filaDestino - filaOrigen);
        int diferenciaCol = Math.abs(colDestino - colOrigen);
        return diferenciaFila == 1 && diferenciaCol == 1;
    }
    
    
    private boolean esDireccionCorrecta(int filaOrigen, int filaDestino, String color) {
        if (color.equals("R")) {
            return filaDestino > filaOrigen;  // Hacia abajo
        } else {  // color.equals("B")
            return filaDestino < filaOrigen;  // Hacia arriba
        }
    }
    
    /**Valida si un movimiento es legal
     * @return ResultadoValidacion con el resultado y mensaje
     */
    private ResultadoValidacion validarMovimiento(int filaOrigen, int colOrigen, 
                                                  int filaDestino, int colDestino) {
        // 1. Verificar que las coordenadas estén dentro del tablero
        if (!tablero.esPosicionValida(filaOrigen, colOrigen)) {
            return new ResultadoValidacion(false, "La posición de origen está fuera del tablero");
        }
        
        if (!tablero.esPosicionValida(filaDestino, colDestino)) {
            return new ResultadoValidacion(false, "La posición de destino está fuera del tablero");
        }
        
        
        Ficha fichaOrigen = tablero.obtenerFicha(filaOrigen, colOrigen);
        if (fichaOrigen == null) {
            return new ResultadoValidacion(false, "No hay ninguna ficha en la posición de origen");
        }
        
        
        if (!fichaOrigen.getColor().equals(turnoActual)) {
            return new ResultadoValidacion(false, 
                "No puedes mover una ficha " + fichaOrigen.getColor() + 
                ". Es el turno de las " + obtenerNombreTurno());
        }
        
        
        if (!esMovimientoDiagonal(filaOrigen, colOrigen, filaDestino, colDestino)) {
            return new ResultadoValidacion(false, "El movimiento debe ser diagonal de una casilla");
        }
        
        if (!esDireccionCorrecta(filaOrigen, filaDestino, fichaOrigen.getColor())) {
            String direccion = fichaOrigen.getColor().equals("R") ? "hacia abajo" : "hacia arriba";
            return new ResultadoValidacion(false, 
                "Las fichas " + fichaOrigen.getColor() + " solo pueden moverse " + direccion);
        }
        
        Ficha fichaDestino = tablero.obtenerFicha(filaDestino, colDestino);
        if (fichaDestino != null) {
            return new ResultadoValidacion(false, "La casilla de destino ya está ocupada");
        }
        
        return new ResultadoValidacion(true, "Movimiento válido");
    }
    
    /**
     * Solicita y valida la entrada de coordenadas del usuario
     * @param mensaje mensaje a mostrar
     * @return array con fila y columna (convertidas a índice base 0)
     */
    private int[] solicitarCoordenadas(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine().trim();
                
                
                String[] coords = entrada.replace(",", " ").split("\\s+");
                
                if (coords.length != 2) {
                    System.out.println("Error: Debes ingresar exactamente 2 números (fila y columna)");
                    continue;
                }
                
                int fila = Integer.parseInt(coords[0]);
                int col = Integer.parseInt(coords[1]);
                
                
                return new int[]{fila - 1, col - 1};
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar números válidos");
            }
        }
    }
    
    
    public void jugar() {
        System.out.println("=== JUEGO DE DAMAS ===");
        System.out.println("Instrucciones:");
        System.out.println("- Las fichas R (rojas) se mueven hacia abajo");
        System.out.println("- Las fichas B (negras) se mueven hacia arriba");
        System.out.println("- Los movimientos son diagonales de una casilla");
        System.out.println("- Ingresa las coordenadas como: fila columna (ejemplo: 6 3)");
        System.out.println("- Las coordenadas van del 1 al 8");
        
        while (true) {
            // 1. Mostrar el tablero
            tablero.mostrarTablero();
            
            // 2. Indicar de quién es el turno
            System.out.println("\nTurno de las " + obtenerNombreTurno() + " (" + turnoActual + ")");
            
            // 3. Solicitar movimiento
            int[] origen = solicitarCoordenadas("Ingresa la posición de origen (fila columna): ");
            int filaOrigen = origen[0];
            int colOrigen = origen[1];
            
            int[] destino = solicitarCoordenadas("Ingresa la posición de destino (fila columna): ");
            int filaDestino = destino[0];
            int colDestino = destino[1];
            
        
            ResultadoValidacion resultado = validarMovimiento(
                filaOrigen, colOrigen, filaDestino, colDestino
            );
            
            if (!resultado.esValido()) {
                System.out.println("\n❌ Movimiento inválido: " + resultado.getMensaje());
                System.out.print("Presiona Enter para intentar de nuevo...");
                scanner.nextLine();
                continue;
            }
            
            
            tablero.moverFicha(filaOrigen, colOrigen, filaDestino, colDestino);
            System.out.println("\n✓ Movimiento realizado correctamente");
            
            cambiarTurno();
        }
    }
}

public class Damaschinas {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}