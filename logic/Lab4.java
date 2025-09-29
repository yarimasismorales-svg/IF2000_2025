
package logic;
public class Lab4 {

    // 42. Números perfectos menores a 1000
    public void numerosPerfectos() {
        for (int num = 2; num < 1000; num++) {
            int suma = 0;
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    suma += i;
                }
            }
            if (suma == num) {
                System.out.println("Perfecto: " + num);
            }
        }
    }

    // 43. Determinar cuántos dígitos tiene un número (considerando negativos)
    public void contarDigitos(int numero) {
        numero = Math.abs(numero);
        int digitos = String.valueOf(numero).length();
        System.out.println("Tiene " + digitos + " dígito(s).");
    }

    // 44. Decimal a romano
    public void decimalARomano(int numero) {
        if (numero < 1 || numero > 3000) {
            System.out.println("Número fuera de rango.");
            return;
        }

        String[] miles = {"", "M", "MM", "MMM"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String romano = miles[numero / 1000] +
                        centenas[(numero % 1000) / 100] +
                        decenas[(numero % 100) / 10] +
                        unidades[numero % 10];

        System.out.println("Romano: " + romano);
    }

    // 45. Calcular seno de x (en radianes) con serie de Taylor
    public void calcularSeno(double x) {
        double resultado = 0;
        for (int n = 0; n < 17; n++) {
            int signo = (n % 2 == 0) ? 1 : -1;
            double potencia = Math.pow(x, 2 * n + 1);
            double factorial = factorial(2 * n + 1);
            resultado += signo * (potencia / factorial);
        }
        System.out.println("sen(" + x + ") = " + resultado);
    }

    private double factorial(int n) {
        double f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    // 46. Enésimo término de Fibonacci (1, 2, 3, 5, ...)
    public void fibonacci(int n) {
        if (n == 1) {
            System.out.println("1");
            return;
        }
        if (n == 2) {
            System.out.println("2");
            return;
        }

        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println("Término " + n + " de Fibonacci: " + c);
    }

    // 47. Simulación de ascensor
    public void ascensor() {
        int piso = 1;
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("Estás en el piso " + piso);
            System.out.println("¿Subir (S), Bajar (B), Salir (X)?");
            String opcion = sc.next().toUpperCase();

            if (opcion.equals("X")) break;

            if (opcion.equals("S")) {
                if (piso == 25) {
                    System.out.println("Ya estás en el último piso.");
                } else {
                    piso++;
                }
            } else if (opcion.equals("B")) {
                if (piso == 1) {
                    System.out.println("Ya estás en el primer piso.");
                } else {
                    piso--;
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
