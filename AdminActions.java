
import java.util.ArrayList;
import java.util.Scanner;

public class AdminActions {    // admin action class


    public boolean adminLogin(Scanner sc, ArrayList<Admin> admins) { // adminLogin method to pass the parameter to scanner and arraylist
        // why boolean ? i will return true and false in this method so i will declered as boolean
        System.out.print("Enter Admin ID : ");
        String id = sc.next();
        System.out.print("Enter Admin Password : ");
        String password = sc.next();

        for (Admin admin : admins) { // for each loop : admins is a array list and stored to admin arraylist object
            if (admin.getAdminId().equals(id) && admin.getAdminPassword().equals(password)) {
                System.out.println("***LOGIN SUCCESSFULLY***");
                return true;
            }
        }
        System.out.println("***WRONG ADMIN***");
        return false;
    }

    public void addUser(Scanner sc, ArrayList<User> users) {   // adduser method to pass the parameter and add the user
        System.out.print("Enter the new username : ");
        String username = sc.next();
        System.out.print("Enter the new password : ");
        String password = sc.next();

        for (User user : users) { // for each loop : users is a array list and stored to user arraylist  object
            if (user.getUsername().equals(username)) { // to check the condition
                System.out.println("***User already exists***");
                return;
            }
        }

        users.add(new User(username, password));// added to array list
        System.out.println("***User added successfully***");
    }

    public void deleteUser(Scanner sc, ArrayList<User> users) {  // deleteUser method to pass the parameter and delete the user
        System.out.print("Enter username for delete : ");
        String username = sc.next();
        System.out.println("Enter the user password :");
        String password = sc.next();
        users.remove( User.getUsername().equals(username)); // to remove the user
        System.out.println("***User deleted successfully***");
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(new User(username, password));
                System.out.println("***User deleted successfully***");
                return;
            }
        }

    }

    public void viewUsers(ArrayList<User> users) {  // viewUser method and pass the parameter at arraylist
        if (users.isEmpty()) { // to check the condition s
            System.out.println("NO user can found!!!");
        } else {
            for (User user : users) { // for each loop : users is a array list and stored to user array  object
                System.out.println("User_Id:" + user.getUsername());
                System.out.println("Balance :" + user.getBalance());
            }
        }
    }

    public void depositAmount(Scanner sc, ArrayList<Notes> note,ArrayList<Transaction> transactions) {
        for(Notes notes:note)
        {
            System.out.println(notes.getNotes()+" "+ notes.getCount()); // to print how many notes and its counts
        }
        System.out.print("Enter amount to add to ATM mechine: ");
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
                        notes.setCount(notes.getCount() + twothoushand);
                        break;
                    case 500:
                        notes.setCount(notes.getCount() + fivhun);
                        break;
                    case 200:
                        notes.setCount(notes.getCount() + twohun);
                        break;
                    case 100:
                        notes.setCount(notes.getCount() + hun);
                        break;
                    default:
                        System.out.println("you enter note is not their");

                }

            }
           System.out.println("Amount was successfully added to atm"+atmAmount);
            ATM.setAtmbalance(ATM.getAtmbalance()+atmAmount);// to set the atm balance
            transactions.add(new Transaction(Admin.getAdminId(), "Deposit", atmAmount,ATM.getAtmbalance()));// add to the transation


        }
        else {
            System.out.println("WRONG Denoation");
        }
        for(Notes notes:note)
        {
            System.out.println(notes.getNotes()+" "+notes.getCount());
        }
        }

        public void viewuserTransactions (ArrayList < Transaction > transactions)// to view the users
        {
            System.out.println("Transaction :");
            for (Transaction transaction : transactions) {
                System.out.println(transaction + "\n user_name:"+User.getUsername()+"\n Balance:"+User.getBalance());
                System.out.println(transaction);
            }
        }

        public void viewTransactions (Scanner sc, ArrayList<Transaction> transactions)// to view the transation
        {

            System.out.println("View Transactions :");
            System.out.println("1. Admin Transactions\n2. User Transactions");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.next());

            switch (choice) {
                case 1:
                    System.out.println("Admin Transactions:");
                    for (Transaction transaction : transactions) {
                            System.out.println(transaction );

                    }
                    break;
                case 2:
                    System.out.println("User Transactions:");
                    for (Transaction transaction : transactions) {

                            System.out.println(transaction+ " \n User_name: "+User.getUsername() +"\n Balance"+User.getBalance());
                        }

                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        public void viewAdmins (ArrayList < Admin > admins) // to view an admin
        {
            System.out.println("List of Admins:");
            for (Admin admin : admins) {
                System.out.println(admin.getAdminId());
            }
        }

}
