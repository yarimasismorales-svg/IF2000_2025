package domainlab3;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;
    private List<LogEntry> logs = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public Account getAccount(String accountNumber) {
        if (accountNumber == null) return null;
        for (Account a : accounts) {
            if (a != null && accountNumber.equals(a.getAccountNumber())) return a;
        }
        return null;
    }

    public void addLog(LogEntry entry) {
        if (entry != null) logs.add(entry);
    }

    public List<LogEntry> getLogs() {
        return logs;
    }

    public void transfer(Account from, Account to, double amount) {
        if (from.getBalance() >= amount) {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Not enough balance to transfer.");
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
