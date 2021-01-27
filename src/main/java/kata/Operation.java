package kata;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Operation {
    private String label;
    private Date date;
    private BigDecimal amount;


    public Operation() {
    }

    public Operation(String label, Date date, BigDecimal amount) {
        this.label = label;
        this.date = date;
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public abstract BigDecimal amountOf();

    @Override
    public String toString() {
        return "Label:" + label + "," + "Date: " + date + "," + "Ammount: " + amountOf();
    }
}
