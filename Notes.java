public class Notes implements Cloneable { // note class this class will inheritate to note action class
    private int notes;
    private  int count;
    public Notes(int notes,int count)
    {
        this.notes=notes;
        this.count=count;
    }
    public  int getNotes() // getter for notes
    {
        return notes;
    }
    public int getCount() { // getter for count
        return count;
    }

    public void setCount(int count) // setter for count
    {
       this. count=count;
    }
    @Override
    public Notes  clone() throws CloneNotSupportedException // override the clone method ...override object to notes
    {
        return (Notes)super.clone();// using super to access the top most class
    }

}
