package com.lab3.POJO;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="phone")
public class Phone implements Serializable {
    @Id
    private  String ID;
    private String Name;
    private  int Price;
    private String color;
    private String Country;
    private int Quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manufacture_id")
    private Manufacture manufacture;

    public Phone(){

    }
    public Phone(String ID,String Name,int price, String color,String Country,int Quantity,Manufacture manufacture ){

        this.ID = ID;
        this.Name = Name;
        this.Price = price;
        this.color = color;
        this.Country = Country;
        this.Quantity = Quantity;
        this.manufacture = manufacture;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getColor() {
        return color;
    }

    public String getCountry() {
        return Country;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }
@Override
    public String toString() {
        return ID + "-" + Name + "-" + Price + "-" + color + "-" + Quantity + "-" + Country +"-"+manufacture;
    }
}
