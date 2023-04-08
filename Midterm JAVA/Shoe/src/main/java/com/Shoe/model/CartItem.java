package com.Shoe.model;

public class CartItem {
    private int cartid;
    private Product product;
    private double price;
    private int quantity;
    private Color color;
    private Size size;
    public CartItem(int cartid, Product product,double price,int quantity,Color color,Size sizeid){
       this.cartid = cartid;
        this.product =  product;
        this.price =  price;

        this.quantity =  quantity;

        this.color =  color;

        this.size =  sizeid;


    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public CartItem(){}

    public double getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public void setColor(Color color) {
        this.color = color;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
