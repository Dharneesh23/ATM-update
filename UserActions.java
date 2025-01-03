
import java.util.ArrayList;
import java.util.Scanner;

public class UserActions { // user action class

    public User userLogin(Scanner sc, ArrayList<User> users) { // user login method
        System.out.print("Enter Username: ");
        String username = sc.next();

        User userad = null;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userad = user;
                break;
            }
        }

        if (userad == null) {
            System.out.println("User not found");
            return null;
        }

        int attempts = 1;
        while (attempts <= 3) { // to check the condition
            System.out.print("Enter your Password : ");
            String password = sc.next();

            if (userad.getPassword().equals(password)) {
                System.out.println("User logged in successfully.");
                return userad;
            } else {
                attempts++;
                if (attempts >= 3) {
                    System.out.println("Incorrect password You have only one  attempts remaining.");
                }
            }
        }

        System.out.println("Account was deactatived ");
        users.remove(userad);
        return null;
    }


    public void depositMoney(Scanner sc, ArrayList<Notes> note) { // deposit money to atm
        for (Notes notes : note) {
            System.out.println(notes.getNotes() + " " + notes.getCount());
        }
        System.out.print("Enter amount to deposite: ");
        int atmAmount = Integer.parseInt(sc.next());
        System.out.println("Enter the 2000rs notes");
        int twothoushand = Integer.parseInt(sc.next());
        System.out.println("Enter the 500rs notes");
        int fivhun = Integer.parseInt(sc.next());
        System.out.println("Enter the 200rs notes");
        int twohun = Integer.parseInt(sc.next());
        System.out.println("Enter the 100rs notes");
        int hun = Integer.parseInt(sc.next());
        int tol = twothoushand * 2000 + fivhun * 500 + twohun * 200 + hun * 100;
        if (tol == atmAmount) {
            for (Notes notes : ATM.getNote()) {
                int type = notes.getNotes();
                switch (type) {
                    case 2000:
                        notes.setCount(notes.getCount() + twothoushand); // get the count and set the count
                        break;
                    case 500:
                        notes.setCount(notes.getCount() + fivhun);// get the count and set the count
                        break;
                    case 200:
                        notes.setCount(notes.getCount() + twohun);// get the count and set the count
                        break;
                    case 100:
                        notes.setCount(notes.getCount() + hun);// get the count and set the count
                        break;
                    default:
                        System.out.println("you enter note is not their");

                }
            }
            System.out.println("Amount was successfully added to atm" + atmAmount);
            ATM.setAtmbalance(ATM.getAtmbalance() + atmAmount); // set the atm balance and user balance
            User.setBalance(User.getBalance() + atmAmount);   // set the  user balance

        } else {
            System.out.println("Wrong denotation");
        }
        for (Notes notes : note) {
            System.out.println(notes.getNotes() + " " + notes.getCount()); //to view how many notes and note count
        }


    }

    public void viewBalance() { // to view the user balance
        System.out.println("Your current balance***: " + User.getBalance());// to get the current balance in user account
    }

    public void viewTransactions(ArrayList<Transaction> transactions) {
        System.out.println("Transaction History for "  + " Balance:" + User.getBalance());

        for (Transaction transaction : transactions) {
            System.out.println(transaction);


        }


    }

    public static void withdraw(Scanner sc, ArrayList<Notes> note,ArrayList<Transaction> transactions) throws CloneNotSupportedException { // withdraw method
        System.out.println("Enter your withdraw amount ");
        int amount = Integer.parseInt(sc.next());
        ArrayList<String> denomation = new ArrayList<>();// to create array list ..array list name denomation
        ArrayList<Notes> copy_note = new ArrayList<>();//  to create array list ..array list name copy_note
        for (Notes notes : ATM.getNote()) { //to get the note and store to notes
            copy_note.add(notes.clone());// copy note arraylist to add the clone method
        }
        while (amount != 0) {
            for (Notes notes : copy_note) { // copy note arraylist to add to notes
                int not_e = notes.getNotes();// to get the notes and declared to not_e variable
                switch (not_e) {
                    case 2000, 500, 200, 100:
                        //this is common to all the cases
                        amount = (int) perform_Withdrawal(amount, denomation, notes);// to call the perform withdrawal method and type casting that method to integer
                        break;
                }
            }
            if (amount == 0) {
                ATM.setNote(copy_note);//  copy note will set to an note
                User.setBalance(User.getBalance() - amount);
                ATM.setAtmbalance(ATM.getAtmbalance() - amount);
                for (String notes : denomation) {
                    System.out.println(" * " + notes);
                }

                transactions.add(new Transaction(Admin.getAdminId(), "Deposit", amount,ATM.getAtmbalance()));// added to transation
                break;
            } else {
                System.out.println("There is no denomination in ATM mechine ! Reenter the amount");
                break;
            }
        }
        for (Notes notes : ATM.getNote()) {
            System.out.println(notes.getNotes() + "" +notes.getCount());
        }
    }

    public static double perform_Withdrawal(double Amount, ArrayList<String> denomation, Notes note) { //perform withdrawal method
        int count = (int) (Amount / note.getNotes());//withdraw amount will div to notes and stored to count
        if (note.getNotes() <= Amount && count <= note.getCount()) {
            Amount = Amount - (count * note.getNotes());
            note.setCount(note.getCount() - count);
            denomation.add(note.getNotes() + " " + count);
            return Amount;

        }
        return Amount;
    }

    public void changepin(Scanner sc) { // change pin
        System.out.println("Enter the old pin");
        String old_pin = sc.next();
        if (old_pin.equals(User.getPassword())) { // to check the old pin and get password
            System.out.println("Set the new pin ");
            String new_pin = sc.next();
            System.out.println("Conforimation pin ");
            String conf_pin =sc.next();
            if (new_pin.equals(conf_pin)) {
                System.out.println("Successfully the pin was changed");
            }
        }else {
            System.out.println("reentered");
        }
    }
}


