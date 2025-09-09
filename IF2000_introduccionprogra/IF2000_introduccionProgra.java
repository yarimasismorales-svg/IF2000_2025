package IF2000_introduccionprogra;
import logic.*;
import domain.*;

public class IF2000_introduccionProgra {


    public static void main(String[] args) {
     
      //  String name = "Lion";
       //   int age = 40;

      //    System.out.println("Hello world");
        //  System.out.println("name:" + name);
        //  System.out.println("age:" + age);
    /*tipos de datos numericos
    float double , long , short, numeric, money, decimal
    Manejo de fechas:
    Date
    Cdenas de caracteres:
    String
    objectos: 
    object

    Data
  /
    Ejecicios_Semana2_PracticaEnClase ej;
    ej = new Ejecicios_Semana2_PracticaEnClase();
    //ej.Quiz2_A_primos(5);
    //ej.EjercicioA(5);
    //ej.EjercioB(12);
    //ej.EjercicoC(10);
    //ej.EjercicioD();
    //ej.ejercicioE();
    //ej.ejercicioF();
    ej.Quiz_3_cuadrado(5);

    Lab_1 lab= new Lab_1();
    //lab.Ejercicio_1();
    //lab.Ejercicio_2();
    //lab.Ejercicio_3();
    //lab.Ejercicio_4();
    //lab.Ejercicio_5();
    //lab.Ejercicio_6();
    //lab.Ejercicio_7();
    //lab.Ejercicio_8();
    //lab.Ejercicio_9();
    //lab.Ejercicio_10();
    //lab.Ejercicio_11();
    //lab.Ejercicio_12();

     /*Lab2 lab2;
    lab2 = new Lab2();

    lab2.ejercicio1();
    lab2.ejercicio2();
    lab2.ejercicio3();
    lab2.ejercicio4();
    lab2.ejercicio5();
    lab2.ejercicio6();
    lab2.ejercicio7();
    lab2.ejercicio8();
    lab2.ejercicio9();
    lab2.ejercicio10();
    lab2.ejercicio11();
    lab2.ejercicio12();
    lab2.ejercicio13();
    lab2.ejercicio14();
    lab2.ejercicio15();*/

    Person client = new Person ("Edgardo", "Corrales", "1-223-4545","4755545",18);

    SavingAccount account1 = 
    new SavingAccount("2025-09-04",12,5,  "14974779", 25000, client);

    account1.deposit(3000);
    System.out.println(account1.toString());

    


    
    }
    
}
