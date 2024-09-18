import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Customer extends User{
    
    
    Connection connect = null;
    Statement s = null;
    ResultSet rs;
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
    
    private int creditCardNum;
    private int Cust_ID; // Primary key of customer
    private int Cust_invFK; // inv fk of customer
    
    public Customer()
    {
        super();
         try
        {
          
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            s=connect.createStatement();
            System.out.println("DB Connected sucessfully!");
        } 
        catch(SQLException e)
         {
            System.out.println("DB connection Failed!");
          }
    }
    
    public int getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(int creditCardNum) {
        this.creditCardNum = creditCardNum;
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
        String sql = "DELETE FROM MANAGER WHERE EMAIL=" + getEmail();
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
        String sql1 = "UPDATE EMAIL= '" + getEmail()+ "' WHERE Cust_ID= " + getId();
        String sql2 = "UPDATE PASSWORD= '" +getPassword()+ "' WHERE Cust_ID " + getId();
        s.executeUpdate(sql1);
        s.executeUpdate(sql2);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
        
    
    public void order(String name , int fk)
    {
        try
       {    
           Product p = new Product();
           p.setProduct_name(name);
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            s = connect.createStatement();
            
            s.executeUpdate("INSERT INTO Inventory (Product_Name , Inv_id) VALUES (' " + p.getProduct_name() + "', " + fk + ")");
            JOptionPane.showMessageDialog(null, "Product has been added in the inventory!");
            System.out.println("Product added in the inventory");
       }
       catch(SQLException e)
       {
           System.out.println(e.getMessage());
       }
      
    }
    public boolean searchProduct(String name)
    {
       try
       {
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            PreparedStatement ps = connect.prepareStatement("SELECT PROD_NAME FROM PRODUCTS WHERE PROD_NAME=" + name);
            ps.setString(1,name);
            while(rs.next())
            {
                if(name.equals(rs.getString("PROD_NAME")))
                {
                    return true;
                }
            }
       }
       catch(SQLException e)
       {
           System.out.println(e.getMessage());
       }
       return false;
    }
    public void viewProductDetails()
    {
        
    }
    public String submitFeedback()
    {
        return null; 
    }
    
    public void removeProduct(int id)
    {
        try
        {
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmacy Delivery System" , "Pharmacy" , "123");
            String sql = "DELETE FROM Product WHERE PROD_ID=" + id;
            Statement s = c.createStatement();
            s.execute(sql);
            s.close();
            c.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}


