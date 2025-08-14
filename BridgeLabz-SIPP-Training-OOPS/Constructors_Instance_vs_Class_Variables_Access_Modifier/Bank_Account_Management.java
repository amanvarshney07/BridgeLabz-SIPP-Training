package Constructors_Instance_vs_Class_Variables_Access_Modifier;

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsInfo() {
        System.out.println("Accessing Account Number (public): " + accountNumber);
        System.out.println("Accessing Account Holder (protected): " + accountHolder);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class Bank_Account_Management {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("1234567890", "Aman", 10000);
        acc1.displayAccountInfo();
        acc1.setBalance(12000);
        System.out.println("Updated Balance: ₹" + acc1.getBalance());

        System.out.println("\n--- Savings Account Info ---");
        SavingsAccount sAcc = new SavingsAccount("9876543210", "kgfrtr", 15000, 4.5);
        sAcc.displayAccountInfo();
        sAcc.displaySavingsInfo();
    }
}

