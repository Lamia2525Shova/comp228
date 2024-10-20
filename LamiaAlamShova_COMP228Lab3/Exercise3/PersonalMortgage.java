package Exercise3;

public class PersonalMortgage extends Mortgage {

    //constructor
    public PersonalMortgage(String mortgageNumber, String customerName, double mortgageAmount, double primeRate, int term) {
        super(mortgageNumber, customerName, mortgageAmount, primeRate + 2.0, term); // 2% over prime rate
    }


    @Override
    public double calculateTotalOwed() {
        double totalInterest = (mortgageAmount * (interestRate / 100)) * term;
        return mortgageAmount + totalInterest;
    }
}
