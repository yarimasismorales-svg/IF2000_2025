package domainlab3;

public class SimpeMovil {
    public SimpeMovil() {}

    /**
     * Transfer amount from source account to target account, validating balances.
     * Returns true if transfer succeeded.
     */
    public boolean transfer(Bank sourceBank, String sourceAccountNumber, Bank targetBank, String targetAccountNumber, double amount) {
        if (sourceBank == null || targetBank == null) return false;

        Account src = sourceBank.getAccount(sourceAccountNumber);
        Account tgt = targetBank.getAccount(targetAccountNumber);

        if (src == null || tgt == null) return false;

        if (src.getBalance() < amount) return false;

        // perform transfer
        src.withdraw(amount);
        tgt.deposit(amount);

        // create and store logs in respective banks
        LogEntry out = new LogEntry("transfer-out", src);
        LogEntry in = new LogEntry("transfer-in", tgt);
        sourceBank.addLog(out);
        targetBank.addLog(in);

        return true;
    }

}
