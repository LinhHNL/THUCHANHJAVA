package DAO;

import POJO.Product;

import java.util.List;

public interface ProductDAO
{   public List<Product> getAll();
    public boolean add(Product temp);

}
