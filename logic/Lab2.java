package logic;

import java.util.Scanner;

public class Lab2 {
    
private final Scanner scanner;

    public Lab2() {
        scanner = new Scanner(System.in);
    }

    public void ejercicio1() {
        int suma = 0;
        for (int i = 2; i <= 1000; i += 2) {
            suma += i;
        }
        System.out.println("La suma de los números pares entre 2 y 1000 es: " + suma);
    }

    public void ejercicio2() {
        System.out.print("Ingrese la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
        System.out.println("La temperatura en grados Fahrenheit es: " + fahrenheit);
    }

    public void ejercicio3() {
        System.out.print("Ingrese el valor base (x): ");
        int x = scanner.nextInt();
        System.out.print("Ingrese el exponente (n): ");
        int n = scanner.nextInt();

        int resultado = 1;
        for (int i = 0; i < n; i++) {
            resultado *= x;
        }
        System.out.println("El resultado de " + x + " elevado a la " + n + " es: " + resultado);
    }

    public void ejercicio4() {
        System.out.print("Ingrese un número del 1 al 12 para mostrar el mes correspondiente: ");
        int mes = scanner.nextInt();

        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        if (mes >= 1 && mes <= 12) {
            System.out.println("El mes es: " + meses[mes - 1]);
        } else {
            System.out.println("Número ingresado inválido.");
        }
    }

    public void ejercicio5() {
        System.out.print("Ingrese un número: ");
        int x = scanner.nextInt();
        int resultado = (x > 0) ? x + 5 : (x < 0) ? x * x : 1;
        System.out.println("El resultado de la función F(x) es: " + resultado);
    }

    public void ejercicio6() {
        System.out.print("Ingrese el lado a: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el lado b: ");
        double b = scanner.nextDouble();
        System.out.print("Ingrese el lado c: ");
        double c = scanner.nextDouble();

        double semiperimetro = (a + b + c) / 2;
        double area = Math.sqrt(semiperimetro * (semiperimetro - a) * (semiperimetro - b) * (semiperimetro - c));
        System.out.println("El área del triángulo es: " + area);
    }

    public void ejercicio7() {
        System.out.print("Ingrese el valor de A: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese el valor de B: ");
        int b = scanner.nextInt();

        int temp = a;
        a = b;
        b = temp;

        System.out.println("Después del intercambio:");
        System.out.println("Valor de A: " + a);
        System.out.println("Valor de B: " + b);
    }

    public void ejercicio8() {
        System.out.print("Ingrese x0: ");
        double x0 = scanner.nextDouble();
        System.out.print("Ingrese y0: ");
        double y0 = scanner.nextDouble();
        System.out.print("Ingrese x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Ingrese y1: ");
        double y1 = scanner.nextDouble();

        if (x0 == x1) {
            System.out.println("No se puede calcular la pendiente: división por cero.");
            return;
        }

        double m = (y1 - y0) / (x1 - x0);
        double b = y0 - (m * x0);
        System.out.println("La ecuación de la recta es: y = " + m + "x + " + b);
    }

    public void ejercicio9() {
        System.out.print("Ingrese un número natural K: ");
        int k = scanner.nextInt();
        int suma = 0;

        for (int i = 1; i < k; i++) {
            suma += i;
        }

        System.out.println("La suma de los números naturales menores que " + k + " es: " + suma);
    }

    public void ejercicio10() {
        System.out.print("¿Cuántos números desea promediar? ");
        int cantidad = scanner.nextInt();
        int suma = 0;

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            suma += scanner.nextInt();
        }

        double promedio = (double) suma / cantidad;
        System.out.println("El promedio es: " + promedio);
    }

    public void ejercicio11() {
        int sumaPares = 0, sumaImpares = 0;
        int cantidadPares = 0, cantidadImpares = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int num = scanner.nextInt();

            if (num % 2 == 0) {
                sumaPares += num;
                cantidadPares++;
            } else {
                sumaImpares += num;
                cantidadImpares++;
            }
        }

        int sumaTotal = sumaPares + sumaImpares;

        System.out.println("Cantidad de pares: " + cantidadPares);
        System.out.println("Suma de pares: " + sumaPares);
        System.out.println("Cantidad de impares: " + cantidadImpares);
        System.out.println("Suma de impares: " + sumaImpares);
        System.out.println("Suma total: " + sumaTotal);
    }

    public void ejercicio12() {
        int sumaPares = 0;
        int sumaImpares = 0;

        for (int i = 1; i <= 200; i++) {
            if (i % 2 == 0) {
                sumaPares += i;
            } else {
                sumaImpares += i;
            }
        }

        System.out.println("Suma de pares entre 1 y 200: " + sumaPares);
        System.out.println("Suma de impares entre 1 y 200: " + sumaImpares);
    }

    public void ejercicio13() {
        int sumaCuadrados = 0;
        for (int i = 1; i <= 100; i++) {
            sumaCuadrados += i * i;
        }
        System.out.println("La suma de los cuadrados de los primeros 100 números naturales es: " + sumaCuadrados);
    }

    public void ejercicio14() {
        System.out.print("Ingrese un número para calcular su factorial: ");
        int n = scanner.nextInt();
        long factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("El factorial de " + n + " es: " + factorial);
    }

    public void ejercicio15() {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int numero = scanner.nextInt();
            if (numero > max) {
                max = numero;
            }
        }

        System.out.println("El número mayor ingresado es: " + max);
    }
}
