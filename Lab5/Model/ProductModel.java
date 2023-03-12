package Model;

import POJO.Product;
import implement.LoginImplement;
import implement.ProductImplement;

import java.util.List;

public class ProductModel {
    public static ProductModel getInstance() {
        return new ProductModel();
    }
    public boolean check_add(Product product){
        if(ProductImplement.getInstance().add(product)){
            return true;
        }
        return false;
    }
public List<Product> getALL(){
        return ProductImplement.getInstance().getAll();
}
public boolean check_delete(int ma){if(ProductImplement.getInstance().delete(ma)){
    return true;
}
    return false;
}}


