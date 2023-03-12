package POJO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private  int ma;
    private String ten;
    private double gia;
    public Product(){

    }
    public Product(String ten,double gia){
        this.ten = ten ;
        this.gia = gia;
    }
    public Product(int  ma,String ten,double gia){
        this.ma  = ma;
        this.ten = ten  ;
        this.gia = gia;
    }

    public double getGia() {
        return gia;
    }

    public int getMa() {
        return ma;
    }
    public String getTen() {
        return ten;
    }
    public void setMa(int ma){
        this.ma = ma;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
