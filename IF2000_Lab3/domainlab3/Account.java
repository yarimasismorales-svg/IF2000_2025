
package domainlab3;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    // Atributos
    private String accountNumber;
    private double balance;
    private Person client;
    private List<LogEntry> logs = new ArrayList<>();

    // Constructor
    public Account() {
       
    }
    public Account(String accountNumber, double balance, Person client) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
    }
    public void addLog(String eventType) {
        LogEntry e = new LogEntry(eventType, this);
        logs.add(e);
    }

    public void addLog(LogEntry entry) {
        if (entry != null) logs.add(entry);
    }

    public List<LogEntry> getLogs() {
        return logs;
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

    @Override
    public String toString(){
        String result = "\nBANK ACCOUNT INFORMATION\n"+
                "Account Number: " + this.getAccountNumber() +
                "\n" +
                "Balance: " + this.getBalance() +
                "\n" +
                "\nAccount owner: " + (this.getClient() != null ? this.getClient().toString() : "<no client>");

        return result;
    }
}


