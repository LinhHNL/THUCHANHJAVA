package com.lab3.Dao;

import com.lab3.POJO.Phone;

import java.util.List;

public interface PhoneDao {
    public boolean add(Phone p);
    public Phone get(String id);
    public List<Phone> getAll();
    public boolean remove(Phone p);
    public boolean remove(String id);
    public boolean update(Phone p);

}
