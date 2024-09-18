

public class Order_Details {
    private int orderDetails_id, product_id, quantity;
    private float subTotal, unitCost;
    private String product_name, product_type;

    public Order_Details(int orderDetails_id, int product_id, int quantity, float subTotal, float unitCost, String product_name, String product_type) {
        this.orderDetails_id = orderDetails_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.unitCost = unitCost;
        this.product_name = product_name;
        this.product_type = product_type;
    }

    public int getOrderDetails_id() {
        return orderDetails_id;
    }

    public void setOrderDetails_id(int orderDetails_id) {
        this.orderDetails_id = orderDetails_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    
    
    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
    
    public void calcPrice(){

    }
    public String displayOrderDetails(){

        return null;
    }

}