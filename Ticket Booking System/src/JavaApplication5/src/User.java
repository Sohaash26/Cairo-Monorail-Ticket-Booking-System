
public abstract class User {
    protected int id;
    protected String Fname , Lname;
    protected String Phone_Num;
    protected String Email;
    protected String Password;

    
    public User()
    {
        id = 0;
        Fname = Lname = Email = Password = null;
        Phone_Num = null;   
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setPhone_Num(String Phone_Num) {
        this.Phone_Num = Phone_Num;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getPhone_Num() {
        return Phone_Num;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
    
    public abstract void createAccount(String email , String password);
    public abstract void deleteAccount(String email);
    public abstract void editAccount(String email , String password);
    
}
