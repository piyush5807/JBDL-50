import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {

    private int id;
    private String name;

    private AtomicLong balance = new AtomicLong();

    public BankAccount(int id, String name, Long balance) {
        this.id = id;
        this.name = name;
        this.balance.set(balance);
    }

    public void deposit(Long amount){
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("In deposit: current thread : " + Thread.currentThread().getName() + ", balance = " + this.balance);
        this.balance.addAndGet(amount); // To achieve atomicity


//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


    }

    public void withdraw(Long amount){
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        synchronized (this) {
        System.out.println("In withdraw: current thread : " + Thread.currentThread().getName() + ", balance = " + this.balance);
            this.balance.addAndGet(-amount); // To achieve atomicity
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

    public AtomicLong getBalance() {
        return balance;
    }


}
