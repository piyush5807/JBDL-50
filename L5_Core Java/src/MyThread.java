public class MyThread extends Thread{

    private boolean isDeposit;
    private Long amount;

    private BankAccount bankAccount;

    MyThread(boolean isDeposit, Long amount, BankAccount bankAccount){
        this.isDeposit = isDeposit;
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        test2();
    }

    public void test(){
        System.out.println("Inside thread - " + currentThread().getName());

        try {                                    // Entry section
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (bankAccount) {            // Critical section
            System.out.println("Inside synchronized block - " + currentThread().getName());

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (isDeposit) {
                bankAccount.deposit(this.amount);
            } else {
                bankAccount.withdraw(this.amount);
            }
        }

        System.out.println("Done the transaction, exiting bye.. " +
                "" + currentThread().getName());  // Remainder section

    }

    public void test2(){
        System.out.println("Inside thread - " + currentThread().getName());

        System.out.println("Inside synchronized block - " + currentThread().getName());

        if (isDeposit) {
            bankAccount.deposit(this.amount);
        } else {
            bankAccount.withdraw(this.amount);
        }


        System.out.println("Done the transaction, exiting bye.. " +
                "" + currentThread().getName());
    }
}
