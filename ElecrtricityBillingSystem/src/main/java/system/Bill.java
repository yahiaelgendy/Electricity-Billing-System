package system;

public class Bill {
    
    private int meterCode;
    private String region;
    private int unit;
    private int amount;
    private boolean isPaid;
    
    public Bill(int meterCode, String region, int unit, int amount, boolean isPaid ){
         
        this.meterCode = meterCode;
        this.amount = amount;
        this.region = region;
        this.unit = unit;
        this.isPaid = isPaid; 
    }
    
    public String getRegion() { return region; }
    public double getAmount() { return amount; }
    public double getUnits() { return unit; }
    public boolean isPaid() { return isPaid; }
    public long getMeterCode() { return meterCode; }
    
    @Override
    public String toString(){
        
        return "Bill [Meter: " + meterCode + " | Region: " + region + " | Amount: " + amount + " | Units: " + unit + "]";
    }
}