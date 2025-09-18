package IF2000_introduccionprogra;

import java.util.Scanner;

public class Lab_1 {
    public Lab_1() {
    }
    public  void Ejercicio_1(){
        //Determiner si es par e impar
       int numero1;
        int resultado=0;

        
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese un numero:");
        numero1=sc.nextInt();

        System.out.println("  ");

        //condición
        if(numero1%2==0){
             resultado=numero1;
             System.out.println("El numero es par:"+resultado);
        }else{
             resultado=numero1;
             System.out.println("El numero es impar:"+resultado);
        }
    }
    public void Ejercicio_2(){
        //Hacer un DF que calcula e imprime el valor absoluto de un número.
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero:");
        int numero =sc.nextInt();

        int valorAbsoluto=(numero<0)?-numero:numero;
        System.out.println("El valor absoluto es:"+valorAbsoluto);
}
    public void Ejercicio_3(){
        //Diseñar un DF que imprima y sume la serie de números 3, 6, 9, 12, 15, … ,99

        int suma=0;
        for(int i=3;i<=99;i=i+3){
            System.out.println(i);
            suma=suma+i;
        }
    }
    public void Ejercicio_4(){
        //Escriba un algoritmo que lea tres números y los imprima en orden ascendente.
        Scanner sc=new Scanner(System.in);
        int[]numeros=new int[3];
        System.out.println("Ingrese el primer numero:");
        numeros[0]=sc.nextInt();
        System.out.println("Ingrese el segundo numero:");
        numeros[1]=sc.nextInt();
        System.out.println("Ingrese el tercero numero:");
        numeros[2]=sc.nextInt();

        java.util.Arrays.sort(numeros);
        System.out.println("Los numeros ordenados de forma ascendente son:"+numeros[0]+","+numeros[1]+","+numeros[2]);
    }
    public void Ejercicio_5(){
        

        Scanner sc=new Scanner(System.in);
        int numero1,numero2,resultado;
        System.out.println("Ingrese el primer numero:");
        numero1=sc.nextInt();
        System.out.println("Ingrese el segundo numero:");
        numero2=sc.nextInt();
        if(numero1==numero2){
            resultado=numero1*numero2;
            System.out.println("Si los numeros son iguales, su valor es de :"+resultado);
        }else if(numero1>numero2){
            resultado=numero1-numero2;
            System.out.println("El primer numero es mayor que el segundo, su resta es:"+resultado);
        }else{
            resultado=numero1+numero2;
            System.out.println("El segundo numero es mayor que el primero,su suma es:"+resultado);
        }
        }
        public void Ejercicio_6(){
            /*Programa que lee un número de notas con valores de 0 a 10, termina cuando se le introduce
            una nota con el valor -1 y nos dice si hubo o no alguna con el valor 10*/

            Scanner sc=new Scanner(System.in);
            int nota;
            boolean nota_10=false;
            while (nota_10==false) {
                System.out.println("Ingrese una nota entre 0 y 10 (-1 para terminar):");
               nota=sc.nextInt();
               if(nota==10){
                nota_10=true;
                System.out.println("Hubo uno con valor 10");
               }else if(nota==-1){
                System.out.println("No hubo ninguna con valor 10");
                break;
               }else if(nota<0||nota>10){
                System.out.println("Nota invalida,ingrese una nota entre 0 y 10");            
            }

        }
        }
        public void Ejercicio_7(){
            /*Calcular el número de pulsaciones que debe tener una persona por cada 10 segundos de
        ejercicio aeróbico, la formula se aplica de acuerdo al sexo es:
        a. Femenino: numero_pulsaciones = (220 - edad)/10
        b. Masculino: numero_pulsaciones = (210 - edad)/10 */

            Scanner sc=new Scanner(System.in);
            int edad;
            String sexo;
            double numero_pulso;

            System.out.println("Ingrese su edad;");
            edad=sc.nextInt();
            System.out.println("Ingrese su sexo :");
            sexo=sc.next();
            if(sexo.equalsIgnoreCase("Femenino")){
                numero_pulso=(220-edad)/10.0;
                System.out.println("Su pulsación por 10 segundos de ejercicio Aerobicos es de:"+numero_pulso);
            }else if(sexo.equalsIgnoreCase("Masculino")){
                numero_pulso=(210-edad)/10.0;
                       System.out.println("Su pulsacion  por 10 segundos de ejercicio aerobico es:"+numero_pulso);
            }
            }
            public void Ejercicio_8(){
            

                    Scanner sc=new Scanner(System.in);
                    int años_en_la_empresa;
                    double salario_mensual,utilidad;
                    System.out.println("Ingrese su salario mensual:");
                    salario_mensual=sc.nextInt();
                    System.err.println("Ingrese sus años en la empresa:");
                    años_en_la_empresa=sc.nextInt();
                    if(años_en_la_empresa<1){
                        utilidad=salario_mensual*0.05;
                        System.out.println("Su utilidad es:"+utilidad);
                    }else if(años_en_la_empresa>=1&&años_en_la_empresa<2){
                        utilidad=salario_mensual*0.07;
                        System.out.println("Su utilidad es:"+utilidad);
                    }else if(años_en_la_empresa>=2&&años_en_la_empresa<5){
                        utilidad=salario_mensual*0.10;
                        System.out.println("Su utilidad es:"+utilidad);
                    }else if(años_en_la_empresa>=5&&años_en_la_empresa<10){
                        utilidad=salario_mensual*0.15;
                        System.out.println("Su utilidad es:"+utilidad);
                    }else if(años_en_la_empresa>=10){
                        utilidad=salario_mensual*0.20;
                        System.out.println("Su utilidad es:"+utilidad);
                    }
            }
                public void Ejercicio_9(){
                    
                        
                    Scanner sc =new Scanner(System.in);
                    int numero,contador=0;
                    System.out.println("Ingrese el numero:");
                    numero=sc.nextInt();
                    for(int i=1;i<=numero; i++){
                        if(numero%i==0){
                            contador++;
                        }
                        System.out.println("El numero de divisores es:"+contador);
                    }

            }
            public void Ejercicio_10(){

                Scanner sc =new Scanner(System.in);
                int numero_computadoras;
                double precio_unitario=11000;
                double precio_total,descuento,monto_a_pagar;
                System.out.println("Ingresar cantidad de computadoras que desea comprar:");
                numero_computadoras=sc.nextInt();
                precio_total=numero_computadoras*precio_unitario;
                if(numero_computadoras<5){
                    descuento=precio_total*0.10;
                    monto_a_pagar=precio_total-descuento;
                    System.out.println("Cantidad de computadoras compradas:"+numero_computadoras);
                    System.out.println("Precio total sin descuento:"+precio_total);
                    System.out.println("Monto descontado:"+descuento);
                    System.out.println("Monto total a pagar:"+monto_a_pagar);
                }else if(numero_computadoras>=5&&numero_computadoras<10){
                    descuento=precio_total*0.20;
                    monto_a_pagar=precio_total-descuento;
                    System.out.println("Cantidad de computadoras compradas:"+numero_computadoras);
                    System.out.println("Precio total sin descuento:"+precio_total);
                    System.out.println("Monto descontado:"+descuento);
                    System.out.println("Monto total a pagar:"+monto_a_pagar);
                }else if(numero_computadoras>=10){
                    descuento=precio_total*0.040;
                    monto_a_pagar=precio_total-descuento;
                    System.out.println("Cantidad de computadoras compradas:"+numero_computadoras);
                    System.out.println("Precio total sin descuento:"+precio_total);
                    System.out.println("Monto descontado:"+descuento);
                    System.out.println("Monto total a pagar:"+monto_a_pagar);
                }

            }
            public  void Ejercicio_11(){
                /*Diseñe un DF que genere la lista de los números primos, que existen entre el número 2 y un
                    número natural N leído del teclado. */

                    Scanner sc = new Scanner(System.in);
                    int N,contador;
                    System.out.println("Ingrese un numero natural N:");
                    N=sc.nextInt();
                    System.out.println("Los numeros primos entre 2 y "+N+"Son:");
                    for(int i=2; i<=N;i++){
                        contador=0;
                        for(int j=1;j<=i;j++){
                            if(i%j==0){
                                contador++;
                            }
                            System.out.println("El numero de divisores es:"+contador);
                        }
                    }
            }
            public void Ejercicio_12(){
                //algoritmo que calcule el área de un triángulo en función de base y altura

                Scanner sc=new Scanner(System.in);
                double base,altura,area;
                System.err.println("Ingrese la base del triangulo:");
                base=sc.nextDouble();
                System.err.println("Ingrese la altura del triangulo:");
                altura=sc.nextDouble();
                area=(base*altura)/2;
                System.err.println("El area del triangulo es:"+area);
            }
        }
    
    
 
