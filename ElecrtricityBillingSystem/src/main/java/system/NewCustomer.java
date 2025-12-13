package system;

public class NewCustomer extends User {
    
    private boolean meterReady;
    private String contractPath;

    public NewCustomer(int id, String name, String email, String password) {
        super(id, name, email, password);
        this.meterReady = false;
    }
    
    // (a) enable customer set all information 
    public void setAllInformation(int id, String name, String email, String password) {
        setId(id);
        setName(name);
        setEmail(email);
        setPassword(password);
    }
    
    public String getAllInformation(){
        return "The details of the customer is : " + "\nID : " + getId() + "\nname : " + 
                getName() + "\nemail : " + getEmail() + "\npassword : " + getPassword() + "\n";
    }
    
    // (b) enable customer attach contract
    public void attachContract(String contractPath){
        if(contractPath == null)
            return;
        this.contractPath = contractPath;
    }
    
    // (c) system will send email 
    public String checkMeterCode(long metercode) {
        if(metercode > 0){
            meterReady = true;
            return "An email sent to : " + email + " your meter code " + metercode + " is now ready\n";
        }        
        else
            return "Invalid details\n";
    }
     
    // return contract
    public String getContract(){
        if(contractPath != null)
            return contractPath;
        else
            return "Please set contract path\n";
    }
    
    
    
    
    
    
    
    
}
