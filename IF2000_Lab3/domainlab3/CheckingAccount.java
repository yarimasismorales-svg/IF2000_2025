package domainlab3;

public class CheckingAccount extends Account {

    private float interest;

    public CheckingAccount(String accountNumber, double balance, Person client, float interest) {
        super(accountNumber, balance, client);
        this.interest = interest;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
       // addLog("deposit");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            //addLog("withdraw");
        } else {
            System.out.println("Not enough balance.");
        }
    }

    @Override
    public double interestCalculation() {
        double earned = getBalance() * interest / 100;
        return getBalance() + earned;
    }
}

