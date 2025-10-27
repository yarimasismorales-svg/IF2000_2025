import java.util.Scanner;

public class Juegos {
    private Tablero tablero;
    private String turnoActual;   // "R" o "B"
    private String jugadorColor;  // color elegido por el usuario
    private Scanner scanner;

    public Juegos() {
        tablero = new Tablero();
        scanner = new Scanner(System.in);
        jugadorColor = elegirColorUsuario();
        turnoActual = "R"; // las Rojas comienzan
        System.out.println("Has elegido jugar con las " + (jugadorColor.equals("R") ? "Rojas" : "Negras") + ".");
        if (!turnoActual.equals(jugadorColor)) {
            System.out.println("Nota: Comienzan las Rojas. Espera tu turno.");
        }
    }

    private String elegirColorUsuario() {
        while (true) {
            System.out.print("Elige color para jugar (R para Rojas / B para Negras, escribir 'S' para salir): ");
            String e = scanner.nextLine().trim().toUpperCase();
            if (e.equals("R") || e.equals("B")) return e;
            if (e.equals("S")) {
                System.out.println("Saliendo...");
                System.exit(0);
            }
            System.out.println("Entrada inválida. Escribe 'R' o 'B'.");
        }
    }

    private void cambiarTurno() {
        turnoActual = turnoActual.equals("R") ? "B" : "R";
    }

    private String nombreTurno() {
        return turnoActual.equals("R") ? "Rojas" : "Negras";
    }

    private int letraAFila(char letra) {
        return Character.toUpperCase(letra) - 'A';
    }

    private int[] solicitarCoordenadas(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (o 'SALIR' para terminar): ");
            String entrada = scanner.nextLine().trim().toUpperCase();
            if (entrada.equals("SALIR") || entrada.equals("S")) {
                System.out.println("Saliendo...");
                System.exit(0);
            }
            if (entrada.length() < 2) {
                System.out.println("Formato inválido. Ejemplo: A2");
                continue;
            }
            char letra = entrada.charAt(0);
            String resto = entrada.substring(1);
            if (letra < 'A' || letra > 'H') {
                System.out.println("Fila inválida. Usa letras A-H.");
                continue;
            }
            try {
                int colNumero = Integer.parseInt(resto);
                if (colNumero < 1 || colNumero > 8) {
                    System.out.println("Columna inválida. Usa números 1-8.");
                    continue;
                }
                int fila = letraAFila(letra);
                int col = colNumero - 1;
                if (!tablero.esPosicionValida(fila, col)) {
                    System.out.println("Coordenadas fuera del tablero. Filas A-H, Columnas 1-8.");
                    continue;
                }
                return new int[]{fila, col};
            } catch (NumberFormatException ex) {
                System.out.println("Formato inválido en la columna. Ejemplo: A2");
            }
        }
    }

    public void jugar() {
        System.out.println("=== JUEGO DE DAMAS SIMPLE ===");
        System.out.println("- Filas: A-H (letra). Columnas: 1-8 (número).");
        System.out.println("- Formato coordenadas: letra+número (ej: A2).");
        System.out.println("- Movimientos: diagonal de una casilla (sin capturas).");
        System.out.println();

        while (true) {
            tablero.mostrarTablero();
            System.out.println("\nTurno: " + nombreTurno() + (turnoActual.equals(jugadorColor) ? " (tu turno)" : ""));
            int[] origen = solicitarCoordenadas("Origen (ej: A2): ");
            Ficha f = tablero.obtenerFicha(origen[0], origen[1]);
            if (f == null) {
                System.out.println("No hay ficha en origen. Intenta otra vez.");
                continue;
            }
            if (!f.getColor().equals(turnoActual)) {
                System.out.println("No puedes mover esa ficha. No es el color en turno.");
                continue;
            }
            int[] destino = solicitarCoordenadas("Destino (ej: B3): ");
            if (destino == null) {
                System.out.println("Destino inválido. Intenta de nuevo.");
                continue;
            }

            // evitar mover a la misma casilla
            if (origen[0] == destino[0] && origen[1] == destino[1]) {
                System.out.println("Origen y destino son iguales. Elige otra casilla.");
                continue;
            }

            // llamada segura a moverFicha
            boolean movido = tablero.moverFicha(origen[0], origen[1], destino[0], destino[1]);
            if (movido) {
                cambiarTurno();
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        }
        
    }

   
    }

