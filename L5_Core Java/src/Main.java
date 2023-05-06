public class Main {

    public static void main(String[] args) throws InterruptedException {

        BankAccount bankAccount = new BankAccount(1, "Test_account", 5000.0);

        MyThread t1 = new MyThread(true, 500.0, bankAccount);
        MyThread t2 = new MyThread(false, 300.0, bankAccount);

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(bankAccount.getBalance());


        long end = System.currentTimeMillis();

        System.out.println("Time taken = " + (end - start));
    }
}