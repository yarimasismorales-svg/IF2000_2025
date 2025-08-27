package domain;

public abstract class Account {
    // Atributos
    private String accountNumber;
    private double balance;
    private Person client;

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

public abstract void deposit();
public abstract void withdraw();
public abstract double interesCalculation();

@Override
public String toString(){
    String result = "\nBANK ACCOUNT INFORMATIONM/n"+
    "Account Number: " + this.getAccountNumber() + 
    "/n"
     +
    "Balance: " + this.getBalance()
    +  "\n"
    +"\nAccount owner: " + this.getClient().toString();

    return result;
}
}


