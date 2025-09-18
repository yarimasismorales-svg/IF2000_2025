
package domainlab3;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import domainlab3.Person;

public abstract class Account {
    // Atributos
    private String accountNumber;
    private double balance;
    private Person client;

    
    // Bitácora
    private List<LogEntry> logs = new ArrayList<>();


    // Constructor
    public Account() {
       
    }
    public Account(String accountNumber, double balance, Person client) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
    }
    // Getters y Setters
    public String getAccountNumber() {
        return accountNumber;
    }   
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Person getClient() {
        return client;
    }
    public void setClient(Person client){
        this.client = client;
    }

public abstract void deposit(double amount);
public abstract void withdraw(double amount);
public abstract double interestCalculation();

// Bitácora
    public void addLog(String type) {
        logs.add(new LogEntry(type, this));
    }

    public List<LogEntry> getLogs() {
        return logs;
    }


@Override
public String toString(){
    String result = "\nBANK ACCOUNT INFORMATIONM\n"+
    "Account Number: " + this.getAccountNumber() + 
    "\n"
     +
    "Balance: " + this.getBalance()
    +  "\n"
    +"\nAccount owner: " + this.getClient().toString();

    return result;
}
}


