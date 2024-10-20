package Exercise1;

public class Life extends Insurance {

    // constructor
    public Life() {
        super("Life Insurance");
    }


    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    // display information
    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + getInsuranceType()); // Should now display correctly
        System.out.println("Monthly Cost: $" + getMonthlyCost());
    }
}
