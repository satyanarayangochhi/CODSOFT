/* TASK3- ATM Interface
 * Author - Satya Narayan Gochhi
 */

import java.util.Scanner;

 public class ATM {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         BankAccount user = new BankAccount(0);
         ATM atm = new ATM(user);
 
         int choice;
         do {
             System.out.println("\nWelcome to SATYA ATM.");
             System.out.println("Choose an option:");
             System.out.println("1. Deposit");
             System.out.println("2. Withdraw");
             System.out.println("3. Check Balance");
             System.out.println("4. Exit");
             System.out.print("Choose what do you want to do: ");
             choice = scanner.nextInt();
 
             double amount;
             switch (choice) {
                 case 1:
                     System.out.print("\nEnter how much you want to deposit: Rs ");
                     amount = scanner.nextDouble();
                     atm.deposit(amount);
                     break;
                 case 2:
                     System.out.print("Enter withdrawal amount: Rs ");
                     amount = scanner.nextDouble();
                     atm.withdraw(amount);
                     break;
                 case 3:
                     System.out.println("Current balance: Rs " + atm.checkBalance());
                     break;
                 case 4:
                     System.out.println("Thank you for using the ATM. See you again!");
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         } while (choice != 4);
         scanner.close();
     }
 
     private BankAccount account;
 
     public ATM(BankAccount account) {
         this.account = account;
     }
 
     public double checkBalance() {
         return account.getBalance();
     }
 
     public void deposit(double amount) {
         if (amount <= 0) {
             System.out.println("Invalid deposit amount.");
             return;
         }
         account.setBalance(account.getBalance() + amount);
         System.out.println("Deposited Rs " + amount + ". New balance: Rs " + account.getBalance());
     }
 
     public void withdraw(double amount) {
         if (amount <= 0) {
             System.out.println("Invalid withdrawal amount.");
             return;
         }
         if (amount > account.getBalance()) {
             System.out.println("Insufficient funds. Withdrawal failed.");
             return;
         }
         account.setBalance(account.getBalance() - amount);
         System.out.println("Withdrew Rs" + amount + ". New balance: Rs" + account.getBalance());
     }
 }
 
 class BankAccount {
     private double balance;
 
     public BankAccount(double initialBalance) {
         balance = initialBalance;
     }
 
     public double getBalance() {
         return balance;
     }
 
     public void setBalance(double newBalance) {
         balance = newBalance;
     }
 }
 