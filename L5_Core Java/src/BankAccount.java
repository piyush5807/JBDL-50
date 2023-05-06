public class BankAccount {

    private int id;
    private String name;

    private volatile Double balance;

    public BankAccount(int id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(Double amount){
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("In deposit: current thread : " + Thread.currentThread().getName() + ", balance = " + this.balance);
        this.balance += amount;


//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


    }

    public void withdraw(Double amount){
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        synchronized (this) {
        System.out.println("In withdraw: current thread : " + Thread.currentThread().getName() + ", balance = " + this.balance);
            this.balance -= amount;
//        }

        // BankAccount@495

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
