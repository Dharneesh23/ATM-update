

public class User // user class
{
    private static String username;
    private static String password;
    private static double balance;


    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.balance = 0.0;

    }

    public static  String getUsername() // getter for username
    {
        return username;
    }

    public static String getPassword() // getter for user password
    {
        return password;
    }

    public static  double getBalance() // getter for user balance
    {
        return balance;
    }

    public static void setBalance(double balances) // setter for balance
    {
        balance = balances;
    }

}