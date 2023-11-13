interface BankAccount {
    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();
}

class ConcreteBankAccount implements BankAccount {
    private double balance;

    public ConcreteBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class BankAccountProxy implements BankAccount {
    private ConcreteBankAccount realAccount;
    private String accountNumber;
    private String password;

    public BankAccountProxy(String accountNumber, String password) {
        realAccount = new ConcreteBankAccount(0.0);
        this.accountNumber = accountNumber;
        this.password = password;
    }

    private boolean authenticate() {
        return "12345".equals(accountNumber) && "password123".equals(password);
    }

    private void checkAccess() {
        if (!authenticate()) {
            throw new SecurityException("Access denied");
        }
    }

    public void deposit(double amount) {
        checkAccess();
        realAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        checkAccess();
        realAccount.withdraw(amount);
    }

    public double getBalance() {
        checkAccess();
        return realAccount.getBalance();
    }
}

public class Main {
    public static void main(String[] args)
    {
        BankAccount account = new BankAccountProxy("12345", "password123");

        account.deposit(100.0);
        account.withdraw(50.0);
        double balance = account.getBalance();

        System.out.println("Account balance: $" + balance);
    }
}
