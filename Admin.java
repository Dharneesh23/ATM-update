
public class Admin     //Admin class
{
    private static String adminId;      // private : its a private information so using encaplaction concept to maintation,
    //static : I will use on main places so i declared as static ...the static will use we do not need to create an object so declered as an static
private static  String adminPassword; // private : its a private information so using encaplaction concept to maintation,
    //static : I will use on main places so i declared as static ...the static will use we do not need to create an object so declered as an static

    public Admin(String adminId, String adminPassword)// method to pass the parameter adminid and adminpass to this method
    {
        this.adminId = adminId;//this: this will point to its self this.adminId will point to class variable adminId
        // adminId is point out the parameter
        this.adminPassword = adminPassword;//this: this will point to its self this.adminId will point to class variable adminId
        // adminId is point out the parameter
    }

    public static String getAdminId()   // getter for adminId
    {
        return adminId;
    }

    public static String getAdminPassword()   // getter for adminpassword
    {
        return adminPassword;
    }

}