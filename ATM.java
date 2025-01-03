import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ATM // ATM class
{

    private  ArrayList<User> users = new ArrayList<>();//Array list for user
    private static  ArrayList<Transaction> transactions = new ArrayList<>();// Array list for transation
    private  ArrayList<Admin> admins = new ArrayList<>();// Array list for admin
    private static double Atmbalance;
    private static  ArrayList<Notes>  note = new ArrayList<>(Arrays.asList(new Twothoushand(2000,0), new Fivehundand(500,0),new Twohun(200,0),new Hun(100,0)));//array list for notes
     public static double getAtmbalance()//getter for atm balance
     {
         return Atmbalance;
     }
     public static void setAtmbalance(double Atmbal)// setter for atm balance
     {
         Atmbalance=Atmbal;
     }

    public static ArrayList<Notes> getNote() {// getter for notes
        return note;
    }
    public static  ArrayList<Notes> setNote(ArrayList<Notes>notes)// setter for note
    {
        note=notes;
        return notes;
    }




    public ATM()// Constructor
    {
        admins.add(new Admin("admin123", "12345"));// to set an default admin id and password
    }

    public void start() throws CloneNotSupportedException { //  start method
        Scanner sc = new Scanner(System.in);
        AdminActions adminActions = new AdminActions(); // to  create an object
        UserActions userActions = new UserActions();// to create an object

        while (true)
        {
            System.out.println("\nATM System Menu:");
            System.out.println("1. Admin Login\n2. User Login\n3. Exit");
            System.out.print("Enter your choice:\n ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    if (adminActions.adminLogin(sc, admins))
                    {
                        adminMenu(adminActions, sc);
                    }
                    break;
                case 2:
                    User loggedInUser = userActions.userLogin(sc, users);
                    if (loggedInUser != null)
                    {
                        userMenu(userActions, loggedInUser, sc);
                    }
                    break;
                case 3:
                    System.out.println("Exiting******...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void adminMenu(AdminActions adminActions, Scanner sc)
    {
        while (true)
        {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add User\n2. Delete User\n3. View Users\n4. Deposit\n5. View user Transactions\n6. View Admins \n7. View Transactions to choose admin or user\n8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();


            switch (choice)
            {
                case 1:
                    adminActions.addUser(sc, users);
                    break;
                case 2:
                    adminActions.deleteUser(sc, users);
                    break;
                case 3:
                    adminActions.viewUsers(users);
                    break;
                case 4:
                    adminActions.depositAmount(sc, note,transactions);
                    break;
                case 5:
                  adminActions.viewuserTransactions(transactions);
                    break;
                case 6:
                    adminActions.viewAdmins(admins);
                    break;
                case 7:
                    adminActions.viewTransactions(sc, transactions);
                    break;
                case 8:
                    System.out.println("Admin Exit***");
                    return;
                default:
                    System.out.println("Invalid choice**Please try again**");
            }
        }
    }

    private void userMenu(UserActions userActions, User user, Scanner sc) throws CloneNotSupportedException {
        while (true)
        {
            System.out.println("\nUser Menu:");
            System.out.println("1. Withdraw cash\n2. Deposit cash\n3. View Balance\n4. View Transactions\n5.Change pin\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.next());

            switch (choice)
            {
                case 1:
                    userActions.withdraw(sc,note,transactions);
                    break;
                case 2:
                    userActions.depositMoney(sc, note);
                    break;
                case 3:
                    userActions.viewBalance();
                    break;
                case 4:
                    userActions.viewTransactions(transactions);
                    break;
                case 5:
                    userActions.changepin(sc);
                         case 6:
                    System.out.println("User Exit");
                    return;
                default:
                    System.out.println("Invalid choice Please try again.");
            }
        }
    }
}