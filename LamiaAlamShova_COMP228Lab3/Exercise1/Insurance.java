package Exercise1;

public abstract class Insurance {
    protected String insuranceType;
    protected double monthlyCost;

    //set insurance type
    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    // getters
    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    // Abstract methods
    public abstract void setInsuranceCost(double cost);
    public abstract void displayInfo();
}

