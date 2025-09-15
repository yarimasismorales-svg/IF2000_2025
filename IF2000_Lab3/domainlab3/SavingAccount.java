package domainlab3;

import domainlab3.Account;
import domainlab3.Person;

public class SavingAccount extends Account {

    // Atributes
    private String initialDate;
    private int months;
    private float interest;

    public Person p;
    // Constructor

    public SavingAccount(String initialDate, int months, float interest) {
        this.initialDate = initialDate;
        this.months = months;
        this.interest = interest;
        this.p = new Person();
    }

    public SavingAccount(String initialDate, int months, float interest, String accountNumber, double balance,
            Person client) {
        super(accountNumber, balance, client);
        this.initialDate = initialDate;
        this.months = months;
        this.interest = interest;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(this.getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= this.getBalance())
            super.setBalance(this.getBalance() - amount);
        else
            System.out.println("You dont have enough money");
    }

    @Override
    public double interestCalculation() {

        double total;
        total = this.getMonths()
                * super.getBalance()
                * this.getInterest();

        return super.getBalance() + total;
    }// endInterestCalculation

    @Override
public String toString() {
    double interestEarned = getBalance() * getInterest() * getMonths() / 100;
    double balanceWithInterest = getBalance() + interestEarned;

    String result = "\nAccount Type: SAVING ACCOUNT"
            + "\n---------------------------------"
            + "\nInitial date of account: " + this.getInitialDate()
            + "\nMonths of saving: " + this.getMonths()
            + "\nInterest rate: " + this.getInterest() + "%"
            + "\nGained interest: " + interestEarned
            + "\nBalance after interest: " + balanceWithInterest;

    return super.toString() + result;
}
}