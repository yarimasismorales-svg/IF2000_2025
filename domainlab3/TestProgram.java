package domainlab3;
import domainlab3.Person;

public class TestProgram {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", "Smith", "111", "8888-8888", 30);
        Person p2 = new Person("Bob", "Brown", "222", "8777-1234", 25);

        SavingAccount sa = new SavingAccount("2023-01-01", 12, 5, "SA123", 1000, p1);
        CheckingAccount ca = new CheckingAccount("CA456", 500, p2, 2.5f);

        Bank bcr = new Bank("BCR");

        bcr.addAccount(sa);
        bcr.addAccount(ca);

        sa.deposit(200);
        sa.withdraw(50);

        ca.deposit(300);
        ca.withdraw(100);

        System.out.println(sa);
        System.out.println(ca);

        // Transfer
        bcr.transfer(sa, ca, 100);

        // Print logs
        System.out.println("\nLogs for SA:");
        for (LogEntry log : sa.getLogs()) {
            System.out.println(log);
        }

        System.out.println("\nLogs for CA:");
        for (LogEntry log : ca.getLogs()) {
            System.out.println(log);
        }
    }
}
