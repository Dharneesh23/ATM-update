
public class Transaction // transaction class
{
    private  String username;
    private String type;
    private  double amount;


    public Transaction(String username, String Withdraw, int amount, double balance)


    {
        this.username = getUsername();
        this.type = getType();
        this.amount =getAmount();

    }

    public String getType()// which type you can getter
  {
      return type;
  }
  public double getAmount()// getter an amount
  {
      return amount;
  }



    public String getUsername() // getter for username
    {
        return username;
    }

    public String toString() // to overwrite
    {
        return "Transaction \n " + "username=" + username + "\n" + " type=" + type + "\n" + "amount=" + amount;
    }
}