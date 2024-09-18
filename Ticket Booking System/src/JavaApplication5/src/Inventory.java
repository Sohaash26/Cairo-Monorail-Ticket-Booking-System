
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Inventory {
    private int inv_id; // pk of inventory
    private int qty;
    private String product_name;
    private float totalPrice;
    
    Connection connect = null;
    Statement s = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
    
    
    public Inventory()
    {
        inv_id = qty = 0;
        product_name = null;
        totalPrice = 0.0f;
    }
    
    public Inventory(int fk)
    {
        inv_id = fk;
    }
    
    public int getInv_id() {
        return inv_id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setInv_id(int fk) {
       inv_id = fk;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

   
    
    public void storeProduct(int fk , String product_name, int qty)
    {
        try
        {
           
            
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            this.setInv_id(fk);
            this.setProduct_name(product_name);
            this.setQty(qty);
        
       
        
        PreparedStatement add = connect.prepareStatement("INSERT INTO Inventory VALUES (?,?,?)");
        add.setInt(1, this.getInv_id());
        add.setString(3,this.getProduct_name());
        add.setInt(2,this.qty);
        add.executeUpdate();
        int row = add.executeUpdate();
     
        System.out.println("Product has been added into inventory!");
        connect.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
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
    
    public void calcTotalPrice()
    {
        try{
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            s = connect.createStatement();
            rs = s.executeQuery("SELECT QUANTITY FROM Inventory");
            int count = 0;
            while(rs.next())
            {
                count = rs.getInt("Quantity");
            }
            totalPrice*=count;
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void editQty(int id , int q)
    {
        try{
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            ps = connect.prepareStatement("SELECT QUANTITY FROM Inventory WHERE ID=?");
            ResultSet rs1 = ps.executeQuery();
            ps.setInt(1,id);
            while(rs1.next())
            {
                if(id == rs1.getInt("Inv_ID"))
                {
                    s = connect.createStatement();
                    
                    s.executeUpdate("UPDATE QUANTITY= '" + q);
                    
                }
            }
        
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
