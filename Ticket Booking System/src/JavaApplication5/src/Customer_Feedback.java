import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer_Feedback {
    
    private String Feedback;
    private int Feeedback_id, Cust_id;

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String Feedback) {
        this.Feedback = Feedback;
    }

    public int getFeeedback_id() {
        return Feeedback_id;
    }

    public void setFeeedback_id(int Feeedback_id) {
        this.Feeedback_id = Feeedback_id;
    }

    public int getCust_id() {
        return Cust_id;
    }

    public void setCust_id(int Cust_id) {
        this.Cust_id = Cust_id;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public Statement getS() {
        return s;
    }

    public void setS(Statement s) {
        this.s = s;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Customer_Feedback(String Feedback, int Feeedback_id, int Cust_id) {
        this.Feedback = Feedback;
        this.Feeedback_id = Feeedback_id;
        this.Cust_id = Cust_id;
    }
      
    Connection connect = null;
    Statement s = null;
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
 
    public Customer_Feedback(){
 
        try
        {
          
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            s=connect.createStatement();
            System.out.println("DB Connected sucessfully!");
        } 
        catch(SQLException e)
         {
            System.out.println("DB Failed!");
          }
 
    } 
 public void Add_Feedback(String fb,int custId){
 
     try{
         
         setFeedback(fb);
         setCust_id(custId);
         PreparedStatement add = connect.prepareStatement("INSERT INTO Customer_Feedback VALUES(?,?)");
         add.setInt(1,getCust_id());
         add.setString(2,getFeedback());
         String medhat="feedback added successfully. :)";
     }
     
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
 
 
 
 }
public void Remove_feedback(int fb_id){
    setFeeedback_id(fb_id);
    try{
          String sql="DELETE FROM Customer_Feedback WHERE Cust_ID= "+getFeeedback_id();
s = connect.createStatement();
        s.executeUpdate(sql);
        s.close();
        connect.close();

        }
catch(SQLException e){
   System.out.println("Failed to remove");
}
}
}