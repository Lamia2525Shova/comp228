package Exercise3;

public class BusinessMortgage extends Mortgage {

    //constructor for BusinessMortgage
    public BusinessMortgage(String mortgageNumber, String customerName, double mortgageAmount, double primeRate, int term) {
        super(mortgageNumber, customerName, mortgageAmount, primeRate + 1.0, term); // 1% over prime rate
    }


    @Override
    public double calculateTotalOwed() {
        double totalInterest = (mortgageAmount * (interestRate / 100)) * term;
        return mortgageAmount + totalInterest;
    }
}
