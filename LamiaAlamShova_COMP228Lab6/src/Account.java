package src;

public class Account {
    private String owner;
    private double balance;
    //Constructor
    public Account(String owner) {
        this.owner = owner;
        this.balance = 1000.0;
    }

    //method to handles thread-safe transactions
    //it accepts a TransactionType (either Deposit or Withdraw and amount)
    public synchronized void performTransaction(TransactionType transactionType, double amount) {

        if (transactionType == TransactionType.Withdraw) {
            if (balance >= amount) { //checks if there is enough money in the account to perform the withdrawal
                balance -= amount; //deducts the value of amount from the balance
                System.out.println("Trying to withdraw $" + amount + " from " + owner + "'s account");
                System.out.println("Successfully withdrawn $" + amount + " from " + owner + "'s account");
                System.out.println("---------------------------------------------------------------------------");
            } else {
                System.out.println("Unsuccessful: insufficient balance to withdraw $" + amount);
            }
        } else if (transactionType == TransactionType.Deposit) { // Corrected comparison
            balance += amount;
            System.out.println("Successfully deposited $" + amount + " to " + owner + "'s account.");
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Account{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}


