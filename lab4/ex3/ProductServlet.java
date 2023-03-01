

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {
    private final Gson gson;
    List<Product> productList = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        productList.add(new Product(0,"sữa",12));
        productList.add(new Product(1,"gạo",1));
        productList.add(new Product(2,"hạt",2));
    }
    public  Product getProduct(int id){
        try {
            return productList.stream().filter(product -> product.getId() == id ).collect(Collectors.toList()).get(0);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    public ProductServlet() {
        gson = new GsonBuilder().create();
    }
    public JsonObject result(String mess, int code, JsonArray jsonArray){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code",code);
        jsonObject.addProperty("message",mess);
        if (jsonArray != null) {
            jsonObject.add("data",jsonArray);
        }
        return  jsonObject;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        try{
                String id = req.getParameter("id");
                if (id != null){
                    Product product = new Product();
                    product = getProduct(Integer.parseInt(id));
                    if (product != null ) {
                        List<Product> list = new ArrayList<>();
                        list.add(product);
                        JsonArray json = gson.toJsonTree(list).getAsJsonArray();
                        String message = "Đọc sản phẩm thành công";
                        pw.write(result(message, 200, json).toString());
                        pw.flush();
                    }
                    else{
                        String mess = "Không tìm thấy sản phẩm nào với Id = " + id;
                        pw.write(result(mess,400,null).toString());
                        pw.flush();
                    }
                }
                else {
                    JsonArray json  = gson.toJsonTree(productList).getAsJsonArray();
                    int code = 0;
                    String message = "Đọc sản phẩm thành công";
                    pw.write(result(message,code,json).toString());
                    pw.flush();
                }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        try {
            if (req.getParameter("add").equals("true")){
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                Double price = Double.parseDouble(req.getParameter("price"));

                if (getProduct(Integer.parseInt(id)) != null){
                    String mess = "sản phẩm đã tồn có trong danh sách";
                    pw.println(result(mess,400,null));
                    pw.flush();
                }
                else {
                    productList.add(new Product(Integer.parseInt(id),name,price));
                    String mess = "Thêm sảm phầm thành công";
                    pw.println(result(mess,200,null));
                }
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        try {
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                Double price = Double.parseDouble(req.getParameter("price"));

                if (id == null || id.isEmpty()){
                    String mess = "ID không thể để trống";
                    pw.println(result(mess,400,null));
                    pw.flush();
                }
                else if (name.isEmpty() || name == null){
                    String mess = "Name không thể để trống";
                    pw.println(result(mess,400,null));
                    pw.flush();
                }
                else if (price.isNaN() || price == null){
                    String mess = "Price không hợp lệ ";
                    pw.println(result(mess,400,null));
                    pw.flush();
                }
                else {
                    Product product = getProduct(Integer.parseInt(id));
                    if (product == null){
                        pw.println(result( "Không tìm thấy sản phẩm nào với Id = " + id,400,null));
                    }
                    else {
                        product.setPrice(price);
                        product.setName(name);
                        pw.println(result( "Cập nhật thành công",200,null));
                    }
                }
            }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        try {
            if (req.getParameter("delete").equals("true")){
                String id = req.getParameter("id");
                if (id == null || id.isEmpty()){
                    String mess = "ID không thể để trống";
                    pw.println(result(mess,400,null));
                    pw.flush();
                }
                else {
                    Product product = getProduct(Integer.parseInt(id));
                    productList.remove(product);
                    pw.println(result("Xóa thành công sản phẩm có id = " +id,200,null));
                    pw.flush();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


