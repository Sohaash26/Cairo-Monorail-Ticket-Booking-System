
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.String;
import java.sql.PreparedStatement;

import java.util.Date; // Date class

    public class Order {
        
    private int order_id; // primary key
    private boolean status;
    private int customer_fk; // foreign key of customer
    private String dateCreated;
    private String dateShipped;
    private String location;
    
   
     
    Connection connect;
    Statement s;
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
    
    
    public Order(int order_id, boolean status, int customer_id ,String dateCreated, String dateShipped, String location)
    {
    
    this.order_id = order_id;
    this.status = status;
    this.customer_fk = customer_id;
    this.dateCreated = dateCreated;
    this.dateShipped = dateShipped;
    this.location = location;
    

    }
    
    public Order()
    {
        
         try
        {
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            s = connect.createStatement();
            
            System.out.println("DB Connected sucessfully!");
        } 
        catch(SQLException e)
         {
            System.out.println(e.getMessage());
          }
    }
    
    public void removeOrder(int id)
    {
        try
        {
            String sql = "DELETE FROM Order WHERE ID = " + id;
            s = connect.createStatement();
            s.executeUpdate(sql);
            connect.close();
            s.close();
            System.out.println("Order has been removed");
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCustomer_fk(int pk) {
        customer_fk = pk;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateShipped(String dateShipped) {
        this.dateShipped = dateShipped;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOrder_id() {
        return order_id;
    }

    public boolean isStatus() {
        return status;
    }

    public int getCustomer_fk() {
        return customer_fk;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateShipped() {
        return dateShipped;
    }

    public String getLocation() {
        return location;
    }

    
   
    java.util.Date dCreated , dShipped;
    java.sql.Date sCreated,sShipped;
    
    
    public void makeOrder(int order_id, boolean status, int pk , String dateCreated, String dateShipped, String location) {
       try
        {
     
        this.setOrder_id(order_id);
        this.setStatus(status);
        this.setCustomer_fk(pk);
        this.setDateCreated(dateCreated);
        this.setDateShipped(dateShipped);
        this.setLocation(location);
        
       
        
        PreparedStatement add = connect.prepareStatement("INSERT INTO ORDER VALUES (?,?,?,?,?,?");
        add.setInt(1, getOrder_id());
        add.setBoolean(2,isStatus());
        add.setInt(3,getCustomer_fk());
        add.setString(4,getDateCreated());
        add.setString(5,getDateShipped());
        add.setString(6, getLocation());
     
        System.out.println("Product has been added!");
        s.close();
        connect.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
   
}

