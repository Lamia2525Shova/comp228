package src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionTest {

    public static void main(String[] args) {

        System.out.println("Lamia Alam Shova. \nStudent ID: 301259598");
        System.out.println("Account{owner='John', balance=$1000.0}");

        Account sharedAccount = new Account("John");

        //transaction objects
        Transaction t1 = new Transaction(sharedAccount, TransactionType.Withdraw, 200);
        Transaction t2 = new Transaction(sharedAccount, TransactionType.Deposit, 1000);
        Transaction t3 = new Transaction(sharedAccount, TransactionType.Deposit, 500);
        Transaction t4 = new Transaction(sharedAccount, TransactionType.Withdraw, 100);

        //thread pool - 4
        //using an ExecutorService to handle multiple threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        //prevents new tasks from being submitted to the thread pool.
        executorService.shutdown();

        //wait for all threads to complete
        while (!executorService.isTerminated()) {
            //empty loop to ensure tasks finish
        }
        System.out.println("SharedAccount: " + sharedAccount);
    }
}

