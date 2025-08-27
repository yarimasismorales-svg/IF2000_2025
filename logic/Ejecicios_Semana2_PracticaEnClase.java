

public class Ejecicios_Semana2_PracticaEnClase {

    public Ejecicios_Semana2_PracticaEnClase(){

    }
    
    public void Quiz2_A_primos(int n){
    for(int i = 1 ;i <= n; i++){
  System.out.print(" ");
    
    for (int j = 1; j <=(n-i)-1; j++){
         System.out.print(" ");
    }
    for (int k = 1;k <=(2*i-1); k++){
        System.out.print("*");

    }
    System.out.print("");


}
}
}