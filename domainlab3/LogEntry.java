package domainlab3;

import java.time.LocalDateTime;

public class LogEntry{
    private static int counter = 1;
    private int eventId;
    private String eventType; // deposit or withdraw
    private LocalDateTime date;
    private String accountAffected;

    public LogEntry(String eventType, Account account) {
        this.eventId = counter++;
        this.eventType = eventType;
        this.date = LocalDateTime.now();
        this.accountAffected = account.getAccountNumber();
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId +
                ", Type: " + eventType +
                ", Date: " + date +
                ", Account: " + accountAffected;
    }
}
