import domainlab3.Person;
import domainlab3.SavingAccount;

public class IF2000_Laboratorio3 {
    public static void main(String[] args) {
        // Crear un cliente
        Person client = new Person("Edgardo", "Corrales", "1-223-4545", "4755545", 18);

        // Crear una cuenta de ahorros
        SavingAccount account1 = new SavingAccount("2025-09-04", 12, 5, "14974779", 25000, client);

        // Realizar un depósito
        account1.deposit(3000);

        // Mostrar información de la cuenta
        System.out.println(account1.toString());
    }
}


