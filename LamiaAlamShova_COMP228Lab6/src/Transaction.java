package src;

public class Transaction implements Runnable {
    // this class implements the Runnable interface to allow transactions to be run as threads.
    private Account account;
    private TransactionType transactionType;
    private double amount;

    //constructor to initialize all the fields
    public Transaction(Account account, TransactionType transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        //run method to executes a transaction by calling the performTransaction method of the Account class.
        account.performTransaction(transactionType, amount);
    }
}
