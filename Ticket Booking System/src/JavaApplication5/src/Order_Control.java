import java.lang.String;

public class Order_Control {
    
    private Order order;
    private Product p;
    private Customer cust;
    public Order_Control(Order order)
    {
       
        this.order = order;
    }
    public Order_Control(Product p)
    {
        this.p = p;
    }
    
    public Order_Control(Customer cust)
    {
        this.cust = cust;
    }
    
    public void makeOrder(int order_id , boolean status , int order_fk , String dateCreated , String dateShipped , String location)
    {
        order.makeOrder(order_id , status , order_fk , dateCreated ,  dateShipped , location);
    }
    public void cancelOrder(int id)
    {
        order.removeOrder(id);
    }
    
    
    
    
    public void makeOrder(String name , int fk) // customer makes order
    {
        cust.order(name , fk);
    }
    public boolean searchProduct(String name)
    {
        return p.checkProduct(name);
    }
}
