package system;

public class Bill {

    private long meterCode;
    private String region;
    private int unit;
    private double amount;
    private boolean isPaid;

    // updated 
    protected double payment;
    protected long paymentID;
    protected static double currentTariff = 1.0;
    protected final static String[] regions = {"Masr-ELGedida", "Nasr-City", "Ain-Shams", "Helmya"};

    public Bill() {
    }

    ;
    
    public Bill(long meterCode, String region, int unit, double amount,
            boolean isPaid, double payment, long paymentID) {

        this.meterCode = meterCode;
        this.amount = amount;
        this.region = region;
        this.unit = unit;
        this.isPaid = isPaid;
        this.payment = payment;
        this.paymentID = paymentID;
    }

    public String getRegion() {
        return region;
    }

    public double getAmount() {
        return amount;
    }

    public double getUnits() {
        return unit;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public long getMeterCode() {
        return meterCode;
    }

    // updated
    public double getPayment() {
        return payment;
    }

    public long getPaymentID() {
        return paymentID;
    }

    // updated
    @Override
    public String toString() {

        return "Bill details :\n - Metercode: " + meterCode + "\n - Region: " + region
                + "\n - Amount: " + amount + "\n - Units: " + unit + "\n - Payment: " + payment + "\n - payment ID: " + paymentID;
    }

}
