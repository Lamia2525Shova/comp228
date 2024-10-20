package Exercise1;

public class Health extends Insurance {

    // Constructor for Health insurance
    public Health() {
        super("Health Insurance");
    }


    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    // Display information
    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + getInsuranceType());
        System.out.println("Monthly Cost: $" + getMonthlyCost());
    }

}


