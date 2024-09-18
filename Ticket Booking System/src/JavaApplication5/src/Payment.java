
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Payment {
    private int PaymentID;
    private String Payment_Type;
    
    
    Connection connect = null;
    Statement s = null;
    ResultSet rs;
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
    
    
    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public String getPayment_Type() {
        return Payment_Type;
    }

    public void setPayment_Type(String Payment_Type) {
        this.Payment_Type = Payment_Type;
    }
    
    public void makePayment(int PaymentID , String Payment_Type)
    {
        try
       {
           
        connect = DriverManager.getConnection(url , "Pharmacy" , "123");
        s=connect.createStatement();
        
        this.setPaymentID(PaymentID);
        this.setPayment_Type(Payment_Type);
        
        PreparedStatement add = connect.prepareStatement("INSERT INTO PAYMENT (?,?)");
        add.setInt(1, getPaymentID());
        add.setString(2,getPayment_Type());
        int row = add.executeUpdate();
     
        System.out.println("Payment has been created!");
        connect.close();
        
       }
       catch(SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }
    public void removePayment(int PaymentID)
    {
        try
        {
            
        connect = DriverManager.getConnection(url , "Pharmacy" , "123");
        s=connect.createStatement();
        this.setPaymentID(PaymentID);
        String sql = "DELETE FROM Payment WHERE Payment_ID=" + getPaymentID();
        s.executeUpdate(sql);
        s.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean checkPayment(int PaymentID)
    {
         try
            {
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            PreparedStatement ps = connect.prepareStatement("SELECT * FROM PAYMENTS WHERE PAYMENT_ID =" + PaymentID);
            ps.setInt(1,PaymentID);
            rs = ps.executeQuery();
            while(rs.next())
            {
                if(PaymentID == rs.getInt("Payment_ID"))
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
}
