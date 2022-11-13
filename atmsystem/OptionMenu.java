package atmsystem;

import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(11021214, 1234);
                data.put(11012124, 4321);

                System.out.println("Welcome to the ATM Project!");
                System.out.println("Enter your customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                x = 2;
            }
            /*
             * for(Map.Entry<Integer,Integer> it : data.entrySet()){
             * if(it.getkey()==getCustomerNumber() && it.getValue()==getPinNumber){
             * getAccountType(); } }
             */
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
        } while (x == 1);
    }

    public void changePassword() {
        try {
            int cn = getCustomerNumber();
            System.out.println("Enter New Pin Number:");
            int newPin = menuInput.nextInt();
            data.put(cn, newPin);
        } catch (Exception e) {
            System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
        }
    }

    public void getAccountType() {
        System.out.println("Select the Account you Want to Access: ");
        System.out.println("Current Account- Type 1");
        System.out.println("Savings Account- Type 2");
        System.out.println("Exit- Type 3");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getCurrent();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for using this ATM, bye.  \n");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getCurrent() {
        System.out.println("Current Account: ");
        System.out.println(" View Balance - Type 1");
        System.out.println(" Withdraw Funds - Type 2");
        System.out.println(" Deposit Funds - Type 3");
        System.out.println(" Change Password - Type 4");
        System.out.println(" Exit - Type 5");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
                getAccountType();
                break;

            case 2:
                getCurrentWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCurrentDepositInput();
                getAccountType();
                break;
            case 4:
                changePassword();
            case 5:
                System.out.println("Thank You for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getCurrent();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println(" View Balance - Type 1");
        System.out.println(" Withdraw Funds - Type 2");
        System.out.println(" Deposit Funds - Type 3");
        System.out.println(" Change Password - Type 4");
        System.out.println(" Exit - Type 5");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getsavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                changePassword();
                break;
            case 5:
                System.out.println("Thank You for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getCurrent();
        }
    }

}
