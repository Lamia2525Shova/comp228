package Exercise3;

public abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double mortgageAmount;
    protected double interestRate;
    protected int term;

    //constructor for Mortgage
    public Mortgage(String mortgageNumber, String customerName, double mortgageAmount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;

        if (mortgageAmount > MAX_MORTGAGE_AMOUNT) {
            this.mortgageAmount = MAX_MORTGAGE_AMOUNT;
        } else {
            this.mortgageAmount = mortgageAmount;
        }

        this.interestRate = interestRate;

        // Set the term based on valid constants
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            this.term = SHORT_TERM; // Default to short-term if invalid
        }
    }

    // Abstract method
    public abstract double calculateTotalOwed();

    //display information
    public String getMortgageInfo() {
        return "Bank: " + BANK_NAME + "\nMortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName + "\nMortgage Amount: $" + mortgageAmount +
                "\nInterest Rate: " + interestRate + "%\nTerm: " + term + " years" +
                "\nTotal Amount Owed: $" + calculateTotalOwed();
    }
}
