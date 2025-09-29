public class Main {
    public static void main(String[] args) {
        Lab4 ej = new Lab4();


        System.out.println("----- EJERCICIO 42: Números perfectos menores a 1000 -----");
        ej.numerosPerfectos();

        System.out.println("\n----- EJERCICIO 43: Contar dígitos -----");
        ej.contarDigitos(-1234);  // Cambia el número para probar otros casos

        System.out.println("\n----- EJERCICIO 44: Decimal a Romano -----");
        ej.decimalARomano(1987);  // Cambia el número entre 1 y 3000

        System.out.println("\n----- EJERCICIO 45: Calcular seno de x (en radianes) -----");
        ej.calcularSeno(Math.PI / 6);  // x = π/6 ≈ 0.5236

        System.out.println("\n----- EJERCICIO 46: Serie Fibonacci -----");
        ej.fibonacci(8);  // Cambia el número del término a mostrar

        System.out.println("\n----- EJERCICIO 47: Simulación de Ascensor -----");
        // Descomenta la línea si deseas probarla (interactiva)
        // ej.ascensor();

        System.out.println("\n----- EJERCICIO 48: Fecha del día siguiente -----");
        ej.fechaSiguiente(28, 2, 2024);  // Año bisiesto

        System.out.println("\n----- EJERCICIO 49: Calcular salario de empleados -----");
        // Descomenta la línea si deseas probarla (requiere entrada del usuario)
        // ej.calcularSalarios();

        System.out.println("\n----- EJERCICIO 50: Jornal diario por turnos -----");
        ej.jornalDiario(8, true, "diurno");  // 8 horas, domingo, turno diurno

        System.out.println("\n----- EJERCICIO 51: Hora dentro de un segundo -----");
        ej.siguienteSegundo(23, 59, 59);  // Prueba con el fin del día

        System.out.println("\n----- EJERCICIO 52a: Suma simple -----");
        ej.sumaSimple(5);  // n = 5

        System.out.println("\n----- EJERCICIO 52b: Suma doble -----");
        ej.sumaDoble(3, 4);  // m = 3, n = 4
    }
}
