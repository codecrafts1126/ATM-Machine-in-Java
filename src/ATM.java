// NOTE: This is my first project in Java, so it may contain suboptimal programming practices and questionable logic.
// Please keep this in mind when evaluating my code.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ATM {
    private static int cn,pin;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the ATM Project!");
        inputFromUser();
    }

    static void inputFromUser() throws IOException {
        Scanner pscan = new Scanner(System.in);
        System.out.print("Enter your 8 digit ATM Card Number: ");
        cn = pscan.nextInt();
        System.out.print("Enter your 4 digit Pin Number: ");
        pin = pscan.nextInt();
        auth();
    }

    static void auth() throws IOException {
        File file = new File("accountInfo.txt");
        Scanner fscan = new Scanner(file);
        boolean authBoo = false;
        while (fscan.hasNextLine()) {
            String line = fscan.nextLine();
            String[] subLine = line.split(",");
            if (cn == Integer.parseInt(subLine[0]) && pin == Integer.parseInt(subLine[1])) {
                authBoo = true;
                break;
            }
        }
        if (authBoo) accType();
        else {
            System.out.println("\nIncorrect Customer Number/PIN.");
            System.out.println("Please enter again.\n");
            inputFromUser();
            auth();
            }
    }

    static void accType() throws IOException {
        System.out.println("\nSelect the account you want to access.");
        System.out.println("Type 1: Checking Account");
        System.out.println("Type 2: Saving Account");
        System.out.println("Type 3: Exit");

        int choice = scan.nextInt();
        if (choice == 1) {
            accMenu(choice);
        } else if (choice == 2) {
            accMenu(choice);
        } else if (choice == 3) {
            System.exit(0);
        } else {
            System.out.println("\nIncorrect! Choose a valid option again.");
            accType();
        }
    }

    static void accMenu(int choice) throws IOException {
        if (choice==1) System.out.println("Checking Account:");
        else System.out.println("Saving Account:");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Exit");

        int choose = scan.nextInt();
        if (choice == 1 && choose == 1) {
            accBalance(1);
        } else if (choice == 1 && choose == 2) {
            accWithdraw(1);
        } else if (choice == 2 && choose == 1) {
            accBalance(2);
        }else if (choice == 2 && choose == 2) {
            accWithdraw(2);
        } else if (choose == 3) {
            System.exit(0);
        } else {
            System.out.println("Incorrect! Choose a valid option again.\n");
            accMenu(choice);
        }
    }

    static void accBalance(int choice) throws IOException {
        File file = new File("accountInfo.txt");
        Scanner fscan = new Scanner(file);
        int balance = -1;
        while (fscan.hasNextLine()) {
            String line = fscan.nextLine();
            String[] subLine = line.split(",");
            if (cn == Integer.parseInt(subLine[0])) {
                if (choice == 1) balance = Integer.parseInt(subLine[2]);
                else balance = Integer.parseInt(subLine[3]);
                break;
            }
        } if (balance == -1) {
            System.out.println("We're having some issues, Try Again!");
            System.exit(0);
        } else {
        if (choice==1) System.out.println("Your current balance from Checking Account is $"+ balance +"\n");
        else System.out.println("Your current balance from Saving Account is $"+ balance +"\n");
        accType();
        }
    }

    static void accWithdraw(int choice) throws IOException {
        System.out.println("\nEnter the amount you want to withdraw: ");
        int withBal = scan.nextInt();
        File file = new File("accountInfo.txt");
        Scanner fscan = new Scanner(file);
        int balance = -1;
        while (fscan.hasNextLine()) {
            String line = fscan.nextLine();
            String[] subLine = line.split(",");
            if (cn == Integer.parseInt(subLine[0])) {
                if (choice == 1) balance = Integer.parseInt(subLine[2]);
                else balance = Integer.parseInt(subLine[3]);
                break;
            }
        }
        if (balance == -1) {
            System.out.println("We're having some issues, Try Again!");
            System.exit(0);
        } else if (withBal <=0) {
            System.out.println("Please enter a valid amount!\n");
            accWithdraw(choice);
        } else if(withBal > balance) {
                System.out.println("Insufficient Balance!\n");
            accWithdraw(choice);
            } else {
            transaction(choice,withBal);
        }
    }

    static void transaction(int choice, int withBal) throws IOException {
        File file = new File("accountInfo.txt");
        String newData = "";
        boolean transSuccess = false;
        Scanner fscan = new Scanner(file);
        while (fscan.hasNextLine()) {
            String line = fscan.nextLine();
            String[] subLine = line.split(",");
            int a = Integer.parseInt(subLine[0]);
            int b = Integer.parseInt(subLine[2]);
            int c = Integer.parseInt(subLine[3]);
            if (cn == a) {
                if (choice == 1) {
                    b = b - withBal;
                    transSuccess = true;
                } else {
                    c = c - withBal;
                    transSuccess = true;
                }
            }
            String newLine = a + "," + subLine[1] + "," + b + "," + c;
            newData += newLine + "\n";
        }

        if (transSuccess) {
            fscan.close();
            FileWriter fWrite = new FileWriter("accountInfo.txt");
            fWrite.write(newData);
            fWrite.close();
            System.out.println("Transaction Successful!");
            System.exit(0);
        } else {
            System.out.println("Transaction Failed!");
            System.exit(0);
        }
    }

    }