package Main;

import java.util.Scanner;

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

    // 43. Contar dígitos de un número
    public void contarDigitos(int numero) {
        numero = Math.abs(numero);
        int digitos = String.valueOf(numero).length();
        System.out.println("Tiene " + digitos + " dígito(s).");
    }

    // 44. Decimal a Romano
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

    // 45. Calcular seno usando serie de Taylor
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

    // 46. Fibonacci
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

    // 47. Ascensor
    public void ascensor() {
        int piso = 1;
        Scanner sc = new Scanner(System.in);

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
    }

    // 48. Fecha del día siguiente
    public void fechaSiguiente(int dia, int mes, int anio) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            diasPorMes[1] = 29;
        }

        dia++;

        if (dia > diasPorMes[mes - 1]) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                anio++;
            }
        }

        System.out.println("La fecha del día siguiente es: " + dia + "/" + mes + "/" + anio);
    }

    // 49. Calcular salario de empleados
    public void calcularSalarios() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("¿Hay más trabajadores? (S/N): ");
            String continuar = sc.next().toUpperCase();
            if (continuar.equals("N")) break;

            System.out.print("Número de empleado: ");
            int numero = sc.nextInt();

            System.out.print("Nombre del empleado: ");
            sc.nextLine();
            String nombre = sc.nextLine();

            System.out.print("Horas trabajadas: ");
            int horas = sc.nextInt();

            System.out.print("Sueldo por hora: ");
            double sueldoHora = sc.nextDouble();

            System.out.print("¿Pertenece al sindicato? (S/N): ");
            String sindicato = sc.next().toUpperCase();

            double salarioBruto;
            if (horas <= 40) {
                salarioBruto = horas * sueldoHora;
            } else {
                int extras = horas - 40;
                salarioBruto = (40 * sueldoHora) + (extras * sueldoHora * 1.5);
            }

            double deduccion = salarioBruto * 0.09;
            if (sindicato.equals("S")) {
                deduccion += salarioBruto * 0.03;
            }

            double salarioNeto = salarioBruto - deduccion;

            System.out.println("Empleado: " + nombre);
            System.out.println("Número: " + numero);
            System.out.println("Salario bruto: " + salarioBruto);
            System.out.println("Deducciones: " + deduccion);
            System.out.println("Salario neto: " + salarioNeto);
        }
    }

    // 50. Jornal diario por turnos
    public void jornalDiario(int horas, boolean esDomingo, String turno) {
        int tarifa;

        if (turno.equalsIgnoreCase("diurno")) {
            tarifa = 500;
            if (esDomingo) tarifa += 200;
        } else {
            tarifa = 800;
            if (esDomingo) tarifa += 30;
        }

        int jornal = horas * tarifa;
        System.out.println("Jornal diario: " + jornal + " colones");
    }

    // 51. Hora dentro de un segundo
    public void siguienteSegundo(int h, int m, int s) {
        s++;

        if (s == 60) {
            s = 0;
            m++;
            if (m == 60) {
                m = 0;
                h++;
                if (h == 24) {
                    h = 0;
                }
            }
        }

        System.out.printf("Hora en un segundo: %02d:%02d:%02d\n", h, m, s);
    }

    // 52a. Suma simple
    public void sumaSimple(int n) {
        int suma = 0;
        for (int x = 0; x <= n; x++) {
            suma += 2 * x + 1;
        }
        System.out.println("Resultado suma simple: " + suma);
    }

    // 52b. Suma doble
    public void sumaDoble(int m, int n) {
        int suma = 0;
        for (int y = 0; y <= m; y++) {
            for (int x = 1; x <= n; x++) {
                suma += 2 * x + (y * y);
            }
        }
        System.out.println("Resultado suma doble: " + suma);
    }
}
