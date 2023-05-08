public class Main {

    public static void main(String[] args) throws InterruptedException {

        BankAccount bankAccount = new BankAccount(1, "Test_account", 5000l);

        MyThread t1 = new MyThread(true, 500l, bankAccount);
        MyThread t2 = new MyThread(false, 300l, bankAccount);

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