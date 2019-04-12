package Domain;

public class InvoiceSumReport {
    private String date;
    private double sum;


    public InvoiceSumReport(String date, double sum) {
        this.date = date;
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
