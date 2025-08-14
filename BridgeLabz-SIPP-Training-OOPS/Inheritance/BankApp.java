package Inheritance;

class BankAccount {
 String accountNumber;
 double balance;

 public BankAccount(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 public void showBasicInfo() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: ₹" + balance);
 }
}

class SavingsAccount extends BankAccount {
 double interestRate;

 public SavingsAccount(String accountNumber, double balance, double interestRate) {
     super(accountNumber, balance);
     this.interestRate = interestRate;
 }

 public void displayAccountType() {
     System.out.println("Account Type: Savings Account");
     showBasicInfo();
     System.out.println("Interest Rate: " + interestRate + "%");
 }
}

class CheckingAccount extends BankAccount {
 double withdrawalLimit;

 public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
     super(accountNumber, balance);
     this.withdrawalLimit = withdrawalLimit;
 }

 public void displayAccountType() {
     System.out.println("Account Type: Checking Account");
     showBasicInfo();
     System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
 }
}

class FixedDepositAccount extends BankAccount {
 int durationInMonths;

 public FixedDepositAccount(String accountNumber, double balance, int durationInMonths) {
     super(accountNumber, balance);
     this.durationInMonths = durationInMonths;
 }

 public void displayAccountType() {
     System.out.println("Account Type: Fixed Deposit Account");
     showBasicInfo();
     System.out.println("Duration: " + durationInMonths + " months");
 }
}

public class BankApp {
 public static void main(String[] args) {
     SavingsAccount sa = new SavingsAccount("SA123", 15000.0, 4.5);
     CheckingAccount ca = new CheckingAccount("CA456", 10000.0, 5000.0);
     FixedDepositAccount fda = new FixedDepositAccount("FD789", 25000.0, 12);

     sa.displayAccountType();
     System.out.println();
     ca.displayAccountType();
     System.out.println();
     fda.displayAccountType();
 }
}

