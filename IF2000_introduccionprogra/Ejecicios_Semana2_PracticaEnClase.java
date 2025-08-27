package IF2000_introduccionprogra;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejecicios_Semana2_PracticaEnClase{

    public Ejecicios_Semana2_PracticaEnClase(){

    }
    
    public void Quiz2_A_primos(int n){

    for (int i = 1; i <= n; i++){
    

    for (int j = 1; j <=(n-i) ; j++){
         System.out.print(" ");
    }


    for (int k = 1;k <=(2*i-1); k++){
       System.out.print("*");

    }

    System.out.println(" ");

    }

    }

public void EjercicioA(int n) {

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            // Borde superior o inferior, o bordes izquierdo/derecho
           if (i == 1 || i == n || j==1 || j == n)  {
                System.out.print("* ");
            } else {
                System.out.print("  "); // Espacios
            }
        }
        System.out.println(); // linea
    }
}

public void EjercioB(int n){

  int num = n;
    for (int i = 1; i <= n;i++){
        for (int j = 1; j <= num ; j++){

        System.out.print("*");
    }
    num--;
       System.out.println(" ");
    }

}
public void EjercicoC(int n){
  //int num = n;
    for (int i = 1; i <=n;i++){
        for (int j = 1; j <= n; j++){
            if(j < i){
             System.out.print(" ");
            }else{
           System.out.print("*");
            }
       
    }
    
       System.out.println(" ");
    

}

}
public void EjercicioD(){

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];

        System.out.println("Ingrese 10 números enteros:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        Arrays.sort(numeros); // Orden ascendente

        System.out.println("\nArreglo ordenado ascendentemente:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public void ejercicioD() {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];

        System.out.println("=== Ejercicio D: Ordenar Ascendente ===");
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        Arrays.sort(numeros);

        System.out.println("Arreglo ordenado ascendentemente:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println("\n");
    }

    // ================= E =================
    // Generar 100 números aleatorios, ordenar descendentemente y mostrar
    public void ejercicioE() {
        Random rand = new Random();
        int[] numeros = new int[100];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(1000); // valores entre 0 y 999
        }

        Arrays.sort(numeros); // ordena ascendente

        System.out.println("=== Ejercicio E: Ordenar Descendente ===");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("\n");
    }

    // ================= F =================
    // Mostrar tablero inicial con fichas negras y rojas
    public void ejercicioF() {
        char[][] tablero = new char[8][8];

        // Inicializar tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i < 3 && (i + j) % 2 == 0) tablero[i][j] = 'N'; // Negras arriba
                else if (i > 4 && (i + j) % 2 == 0) tablero[i][j] = 'R'; // Rojas abajo
                else tablero[i][j] = ' '; // Espacios vacíos
            }
        }

        // Imprimir tablero
        System.out.println("=== Ejercicio F: Tablero ===");
        System.out.print("   ");
        for (int j = 1; j <= 8; j++) System.out.print(j + " ");
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print((char) ('A' + i) + "  ");
            for (int j = 0; j < 8; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();



}
    
}

        public void Quiz_3_cuadrado(int n){
          
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            // Borde superior o inferior
           if (i == 1 || i == n || j==1 || j == n)  {
                System.out.print("* ");

           }else if (i == (n + 1) / 2 && j == (n + 1) / 2) {
            System.out.print("* "); // Asterisco centro
        
            } else {
                System.out.print("  "); 
            }
        }
        System.out.println(); // linea
    }
        }
    }







     

