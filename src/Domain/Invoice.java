package Domain;

import java.time.LocalDate;
import java.util.Objects;

public class Invoice {
    private String Id;
    private double amount;
    private String briefing;
    private String date;

    public Invoice(String id, double amount, String briefing, String date) {
        Id = id;
        this.amount = amount;
        this.briefing = briefing;
        this.date = date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBriefing() {
        return briefing;
    }

    public void setBriefing(String briefing) {
        this.briefing = briefing;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}