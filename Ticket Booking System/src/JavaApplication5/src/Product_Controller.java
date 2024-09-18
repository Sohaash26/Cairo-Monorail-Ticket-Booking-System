import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Product_Controller {
    
    Connection connect = null;
    Statement s = null;
  
    String url = "jdbc:derby://localhost:1527/Pharmacy Delivery System";
   
    public Product_Controller(){
       try
        {
            connect = DriverManager.getConnection(url , "Pharmacy" , "123");
            System.out.println("DB Connected sucessfully!");
        } 
        catch(SQLException e)
         {
            System.out.println("DB Failed!");
          }
    }
    
    
    private Product product;
    private Manager manager;
    private Inventory inv;
    
    
    public Product_Controller(Product product)
    {
        this.product = product;
    }
    
    public Product_Controller(Inventory inv)
    {
        this.inv = inv;
    }
    
    public Product_Controller(Manager manager)
    {
        this.manager= manager;
    }
   
    public void addProduct(int product_id,String product_name,String description,float price,String type) // manager adds product
    {
        manager.addProduct(product_id,product_name,description,price,type);
    }
    
    public void addProduct(int fk , String product_name , int qty) // add product to inventory
    {
        inv.storeProduct(fk , product_name , qty);
    }
    
    public void addQty (int quantity , int inv_id){
        try
        {
       
            String sql="UPDATE INVENTORY SET Quantity ="+quantity+"WHERE Inv_ID ="  + inv_id;
            s = connect.createStatement();
            s.executeUpdate(sql);
            connect.close();
            s.close();
        }
        catch(SQLException e)
        {
            System.out.println("Failed to update quantity");
        }
    }
    
    public void removeProduct(int id)
    {
        product.removeProduct(id);
    }
    public void Manager_deleteProduct(int id)
    {
        manager.deleteProduct(id);
    }
   
    public void Inv_deleteProduct(int id)
    {
        inv.removeProduct(id);
    }
    
    public void calcTotalPrice()
    {
        inv.calcTotalPrice();
    }
    
    public void checkProduct(String name)
    {
        product.checkProduct(name);
    }
    
    public void editQty(int id)
    {
       // inv.editQty(q);
    }
}
