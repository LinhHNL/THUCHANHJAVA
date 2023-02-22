package com.lab3.Dao;

import com.lab3.POJO.Manufacture;

import java.util.List;

public interface ManufactureDao {
    public boolean add(Manufacture p);
    public Manufacture get(String  id);
    public List<Manufacture> getAll();
    public boolean remove(Manufacture p);
    public boolean remove(String  id);
    public  boolean update(Manufacture p);


}
