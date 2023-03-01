


public class Product {
    private  int Id;
    private String Name;
    private  double Price;

    public Product(){}
    public Product (int id,String name,double price ){
        this.Id = id;
        this.Name = name;
        this.Price = price;
    }

    public double getPrice() {
        return Price;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + Id +
                ", name:" + Name + '\'' +
                ", price:" + Price +

    "}";
    }
}
