package com.lab3;
import com.lab3.Dao.ManufactureDao;
import com.lab3.POJO.Manufacture;
import com.lab3.POJO.Phone;
import com.lab3.implement.*;
import org.hibernate.engine.jdbc.spi.SchemaNameResolver;

import javax.persistence.Id;
import javax.persistence.Subgraph;
import java.util.List;
import java.util.Scanner;

public class App{
        public static void addPhone(){
            Scanner sc = new Scanner(System.in);
            PhoneDaoImpl p = PhoneDaoImpl.getInstance();

            System.out.print("Enter id");
            String ID = sc.next();
            System.out.print("Enter name");
            String Name = sc.next();
            System.out.print("Enter Price");
            int Price = sc.nextInt();
            System.out.print("Enter color");
            String color = sc.next();
            System.out.print("Enter Country");
            String Country= sc.next();
            System.out.print("Enter Quantity");
            int Quantity = sc.nextInt();
            System.out.print("Enter Manufacture");
            String manufacture = sc.next();
            ManufactureDaoImpl m = ManufactureDaoImpl.getInstance();

           if( p.add(new Phone(ID,Name,Price,color,Country,Quantity,m.get(manufacture)))){
               System.out.println("Thanh cong");
           }else {
               System.out.println("Thai bai");

            }
        }
        public  static  void removePhone(){

            ManufactureDaoImpl m = ManufactureDaoImpl.getInstance();
            PhoneDaoImpl p = PhoneDaoImpl.getInstance();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id");
            String ID = sc.next();
            System.out.print("Enter name");
            String Name = sc.next();
            System.out.print("Enter Price");
            int Price = sc.nextInt();
            System.out.print("Enter color");
            String color = sc.next();
            System.out.print("Enter Country");
            String Country= sc.next();
            System.out.print("Enter Quantity");
            int Quantity = sc.nextInt();
            System.out.print("Enter Manufacture");
            String manufacture = sc.next();
            if(p.remove(new Phone(ID,Name,Price,color,Country,Quantity,m.get(manufacture)))){
                System.out.println("Thanh cong");

            } else {
                System.out.println("That bai");
            }
        }
        public static  void updatePhone(){

            ManufactureDaoImpl m = ManufactureDaoImpl.getInstance();
            PhoneDaoImpl p = PhoneDaoImpl.getInstance();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id");
            String ID = sc.next();
            System.out.print("Enter name");
            String Name = sc.next();
            System.out.print("Enter Price");
            int Price = sc.nextInt();
            System.out.print("Enter color");
            String color = sc.next();
            System.out.print("Enter Country");
            String Country= sc.next();
            System.out.print("Enter Quantity");
            int Quantity = sc.nextInt();
            System.out.print("Enter Manufacture");
            String manufacture = sc.next();
            if(p.update(new Phone(ID,Name,Price,color,Country,Quantity,m.get(manufacture)))){
                System.out.println("Thanh cong");

            } else {
                System.out.println("That bai");
            }
        }
        public static  void addManufacture(){
            ManufactureDaoImpl m = ManufactureDaoImpl.getInstance();
            Scanner sc = new Scanner(System.in);
             String Id;
             String Name;
             String Location;
              int Employee;
            System.out.println("Enter id");
            Id = sc.next();
            System.out.println("Enter Name");
            Name = sc.next();
            System.out.println("Enter Location");
            Location = sc.next();
            System.out.println("Enter Employee");
            Employee = sc.nextInt();
            if(m.add(new Manufacture(Id,Name,Location,Employee))){
                System.out.println("Thanh cong");

            } else {
                System.out.println("That bai");
            }
        }
    public  static void  removeM(){
        ManufactureDaoImpl m = ManufactureDaoImpl.getInstance();
        Scanner sc = new Scanner(System.in);
        String Id;
        String Name;
        String Location;
        int Employee;
        System.out.println("Enter id");
        Id = sc.next();
        System.out.println("Enter Name");
        Name = sc.next();
        System.out.println("Enter Location");
        Location = sc.next();
        System.out.println("Enter Employee");
        Employee = sc.nextInt();
        if(m.remove(new Manufacture(Id,Name,Location,Employee))){
            System.out.println("Thanh cong");

        } else {
            System.out.println("That bai");
        }
    }
    public  static void  updateM(){
        ManufactureDaoImpl m = ManufactureDaoImpl.getInstance();
        Scanner sc = new Scanner(System.in);
        String Id;
        String Name;
        String Location;
        int Employee;
        System.out.println("Enter id");
        Id = sc.next();
        System.out.println("Enter Name");
        Name = sc.next();
        System.out.println("Enter Location");
        Location = sc.next();
        System.out.println("Enter Employee");
        Employee = sc.nextInt();
        if(m.update(new Manufacture(Id,Name,Location,Employee))){
            System.out.println("Thanh cong");

        } else {
            System.out.println("That bai");
        }
    }
   public static int view(){
    do {
        ManufactureDaoImpl m = ManufactureDaoImpl.getInstance();
        PhoneDaoImpl p = PhoneDaoImpl.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------MENU---------------n");

        System.out.println("------Phone------");
        System.out.println("1. add");
        System.out.println("2. get by id");
        System.out.println("3. get all");
        System.out.println("4. remove by id");
        System.out.println("5. remove");
        System.out.println("6. update");
        System.out.println("7. Top selling");
        System.out.println("8. Sort ");
        System.out.println("9. check if there is a phone priced above 50 million VND.");
        System.out.println("10. the first phone in the list that meets the criteria: has the color 'Pink' and costs over 15 million");
        System.out.println("------Manufacture------");
        System.out.println("11. add");
        System.out.println("12. get by id");
        System.out.println("13. get all");
        System.out.println("14. remove by id");
        System.out.println("15. remove");
        System.out.println("16. update");

        System.out.println("17. check whether all manufacturers have more than 100 employees.");
        System.out.println("18. sum of all employees of the manufactures.");
        System.out.println("19. the last manufacturer in the list of manufacturers that meet the criteria: based in the US");
        System.out.println("0. exit");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                addPhone();
                break;
            case 2:
                System.out.print("Enter id");
                String id = sc.next();
               System.out.println(p.get(id));
                break;
            case 3:
                for (Phone phone:
                     p.getAll()) {
                    System.out.println(phone.toString());
                }
                break;
            case 4:
                System.out.print("Enter id");
                String idremove = sc.next();
                if(p.remove(idremove)){
                    System.out.println("Thanh cong");

                } else {
                    System.out.println("That bai");
                }
                break;
                case 5:
                    removePhone();
                    break;
            case 6:
                updatePhone();
                break;
            case 7:
                for (Phone phone:
                        p.HighestSellingPrice()) {
                    System.out.println(phone.toString());
                }
                break;
            case 8:
                for (Phone phone:
                        p.OrderPhone()) {
                    System.out.println(phone.toString());
                }
                break;
            case 9:
                if(p.FindPhoneOver50M()!=null){
                    System.out.println(p.FindPhoneOver50M().toString());

                }else {
                    System.out.println("Khong ton tai");
                }
                break;
            case 10:
                if(p.FindPhone()!=null){
                    System.out.println(p.FindPhone().toString());


                }else {
                    System.out.println("Khong ton tai");
                }
                break;

            case 11:
                addManufacture();
                break;
            case 12:
                System.out.print("Enter id");
                String idm = sc.next();
                System.out.println(m.get(idm));
                break;
            case 13:
                for (Manufacture manufacture:
                        m.getAll()) {
                    System.out.println(manufacture.toString());
                }
                break;
            case 14:
                System.out.print("Enter id");
                String idremovem = sc.next();
                if(m.remove(idremovem)){
                    System.out.println("Thanh cong");

                } else {
                    System.out.println("That bai");
                }
                break;
            case 17:
                for (Manufacture manufacture:
                        m.getManufactureEmployee()) {
                    System.out.println(manufacture.toString());
                }
                break;
            case 18:
                String name;
                System.out.print("Enter name Manufacture ");
                name = sc.next();
                System.out.println("Number Employee of Manufacture: " + m.getNumberEmpoloyee(name));

                break;
            case 15:
                removeM();
                break;
            case 16:
                updateM();

            break;
            case 19:
                if(m.getManufacturewithcondition()!=null){
                    System.out.println(p.FindPhone().toString());


                }else {
                    System.out.println("Khong ton tai");
                }
                break;
                case 0:
    return 0;

        }
    }while (true);
}

    public static void main(String[] args) {
view();
    }

}
