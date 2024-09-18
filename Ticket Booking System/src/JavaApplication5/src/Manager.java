import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Manager extends User {

    
    Connection connect = null;
    Statement s = null;
    ResultSet rs;
    PreparedStatement ps;
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
   
    public Manager()
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
    @Override
    public void createAccount(String email , String password) {
       try
       {
           
        connect = DriverManager.getConnection(url , "Pharmacy" , "123");
        s=connect.createStatement();
        
        this.setEmail(email);
        this.setPassword(password);
        
        PreparedStatement add = connect.prepareStatement("INSERT INTO MANAGER (?,?)");
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
        String sql = "DELETE FROM MANAGER WHERE M_EMAIL=" + getEmail();
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
        String sql1 = "UPDATE EMAIL= '" + getEmail()+ "' WHERE M_ID= " + getId();
        String sql2 = "UPDATE PASSWORD= '" +getPassword()+ "' WHERE M_ID " + getId();
        s.executeUpdate(sql1);
        s.executeUpdate(sql2);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void addProduct(int product_id,String product_name,String description,float price,String type)
    {
         try
        {
            
        Product p = new Product();
        p.setProduct_id(product_id);
        p.setProduct_name(product_name);
        
        p.setPrice(price);
        p.setType(type);
        
       
        
        PreparedStatement add = connect.prepareStatement("INSERT INTO PRODUCT VALUES (?,?,?,?,?,?)");
        add.setInt(1, p.getProduct_id());
        add.setString(2,p.getProduct_name());
       
        add.setFloat(4,p.getPrice());
        add.setString(5,p.getType());
        add.setInt(6, p.getInv_fk());
        int row = add.executeUpdate();
     
        System.out.println("Product has been added!");
        connect.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void deleteProduct(int id){
        
        try{
            
        Product p = new Product();
        String sql = "DELETE FROM PRODUCT WHERE PROD_ID="+ p.getProduct_id();
        s = connect.createStatement();
        s.executeUpdate(sql);
        s.close();
        connect.close();

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        }
    
    public void viewSoldProducts()
    {
        try
        {
        connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmacy Delivery System" , "Pharmacy" , "123");
        s = connect.createStatement();
        rs = s.executeQuery("SELECT * FROM Product");
        DefaultTableModel model = new DefaultTableModel(new String[]{"Product ID", "Product name"} , 0);
        while(rs.next())
        {
            int id = rs.getInt("Prod_id");
            String name = rs.getString("Prod_name");
            model.addRow(new Object[]{id,name});
        }
        JTable table = new JTable();
        table.setModel(model);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
                
    }
    
    public void addEmployee(String fname , String lname , int id)
    {
        try
        {
           
            Employee emp = new Employee();
            emp.setFname(fname);
            emp.setLname(lname);
            emp.setId(id);
            s.executeUpdate("INSERT INTO Employee (Emp_ID , Fname , Lname) VALUES (" + emp.getId() + ", '" + emp.getFname() + "', '" +emp.getLname() + "')");
            System.out.println("Employee has been added!");
      
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }       
}
    
    public void removeEmployee(int id)
    {
         try{
            
        
       /* Employee emp = new Employee();
        emp.setId(id);
        
        String sql = "DELETE FROM Employee WHERE Emp_ID ="+ emp.getId();
        s = connect.createStatement();
        s.executeUpdate(sql);
         System.out.println("Employee removed!");
        s.close();
        connect.close();
             */
       Employee emp = new Employee();
       emp.setId(id);
       
       ps = connect.prepareStatement("SELECT * FROM Employee WHERE Emp_ID = ?");
       ps.setInt(1,id);
       rs = ps.executeQuery();
       while(rs.next())
       {
           if(id == rs.getInt("Emp_ID"))
           {
               s = connect.createStatement();
               s.executeUpdate("DELETE FROM Employee WHERE Emp_ID=" + id);
               JOptionPane.showMessageDialog(null,"Employee has been removed!");
           }
           else
           {
                JOptionPane.showMessageDialog(null,"Please enter an ID that is associated with the employee");
           }
       }
       
        }
        catch(SQLException e)
        {
            System.out.println("Failed to remove an employee");
        }
    }
    
    public void generateReport()
    {
        
    }
    
    public void viewFeedback(){
    try{
    String sql="SELECT *FROM Customer_Feedback";
    Statement st = connect.createStatement();
    ResultSet rs=null;
    rs=st.executeQuery(sql);
    while(rs.next()){
    System.out.println(rs.getInt("Feedback_id")+"\t"+rs.getString("FEEDBACK")+"\t"+rs.getInt("CUST_FBFK"));
}
    rs.close();
    st.close();
    connect.close();
} catch (SQLException ex) {
System.out.println("Connect failed ! ");
}}
    
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

    /**
     *
     * @param Password
     */
    @Override
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
 
}