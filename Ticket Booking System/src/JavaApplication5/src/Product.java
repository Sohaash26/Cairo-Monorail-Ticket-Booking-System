
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;


public class Product {
    
    Connection connect = null;
    Statement s = null;
    ResultSet rs;
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
    
    private int product_id; // product pk
    private String product_name;
  
    private float price;
    private String type;
    private int inv_fk; // inventory fk

    public Product()
    {
       
        product_name = null;
     
        price = 0.0f;
        type = null;
        inv_fk = product_id;
    }

    public int getInv_fk() {
        return inv_fk;
    }

    public void setInv_fk(int pk) {
        inv_fk = pk;
    }
    
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

  

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    public boolean checkProduct(String productName)
    {       try
            {
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            PreparedStatement ps = connect.prepareStatement("SELECT PROD_NAME FROM Product WHERE PROD_NAME=" + productName);
            ps.setString(1,productName);
            rs = ps.executeQuery();
            while(rs.next())
            {
                if(productName.equals(rs.getString("PROD_NAME")))
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
    
    public void removeProduct(int id)
    {
         try
        {
            
        connect = DriverManager.getConnection(url , "Pharmacy" , "123");
        s=connect.createStatement();
        this.setProduct_id(id);
        String sql = "DELETE FROM MANAGER WHERE PROD_ID=" + getProduct_id();
        s.executeUpdate(sql);
        s.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
   
    
    }
}
