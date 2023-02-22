package com.lab3.POJO;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Manufacture")
public class Manufacture {
    @Id
    private String Id;
    private String Name;
    private String Location;
    private  int Employee;

    @OneToMany(mappedBy = "manufacture")
    private   List<Phone> phoneList ;
    public Manufacture(){


    }
    public  Manufacture(String Id,String Name ,String Location,int Employee){
        this.Id = Id;
        this.Name = Name;
        this.Location = Location;
        this.Employee = Employee;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmployee(int employee) {
        Employee = employee;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setLocation(String location) {
        Location = location;
    }

//    public void setPhoneList(List<Phone> phoneList) {
//        this.phoneList = phoneList;
//    }

    public String getName() {
        return Name;
    }

    public String getId() {
        return Id;
    }

    public int getEmployee() {
        return Employee;
    }

//    public List<Phone> getPhoneList() {
//        return phoneList;
//    }

    public String getLocation() {
        return Location;
    }

    @Override
    public String toString() {
        return Id+"-"+Name+"-"+Location+"-"+Employee;
    }
}
