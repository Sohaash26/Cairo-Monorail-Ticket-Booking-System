
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Employee extends User {

    Connection connect = null;
    Statement s = null;
    ResultSet rs;
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
    
    private float Salary;
    private String Career;

    public String getCareer() {
        return Career;
    }

    public void setCareer(String Career) {
        this.Career = Career;
    }
    
    public Employee()
    {
        super();
        try{
        connect = DriverManager.getConnection(url , "Pharmacy" , "123");
        s=connect.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFname() {
        return Fname;
    }

    @Override
    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    @Override
    public String getLname() {
        return Lname;
    }

    @Override
    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    @Override
    public String getPhone_Num() {
        return Phone_Num;
    }

    @Override
    public void setPhone_Num(String Phone_Num) {
        this.Phone_Num = Phone_Num;
    }

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public void setPassword(String Password) {
        this.Password = Password;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }
    
    
    
    @Override
    public void createAccount(String email , String password) {
        
        try
       {
           
        connect = DriverManager.getConnection(url , "Pharmacy" , "123");
        s=connect.createStatement();
        
        this.setEmail(email);
        this.setPassword(password);
        
        PreparedStatement add = connect.prepareStatement("INSERT INTO EMPLOYEE (?,?)");
        add.setString(1, getEmail());
        add.setString(2,getPassword());
        int row = add.executeUpdate();
     
        System.out.println("Account has been created!");
        connect.close();
        
       }
       catch(SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }

    @Override
    public void deleteAccount(String email) {
        try
        {
            
        connect = DriverManager.getConnection(url , "Pharmacy" , "123");
        s=connect.createStatement();
        this.setEmail(email);
        String sql = "DELETE FROM EMPLOYEE WHERE EMAIL=" + getEmail();
        s.executeUpdate(sql);
        s.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editAccount(String email, String password) {
       try
        {
            
        connect = DriverManager.getConnection(url , "Pharmacy" , "123");
        s=connect.createStatement();
        this.setEmail(email);
        this.setPassword(password);
        String sql1 = "UPDATE EMAIL= '" + getEmail()+ "' WHERE Emp_ID= " + getId();
        String sql2 = "UPDATE PASSWORD= '" +getPassword()+ "' WHERE Emp_ID " + getId();
        s.executeUpdate(sql1);
        s.executeUpdate(sql2);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
