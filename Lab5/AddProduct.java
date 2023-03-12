import Model.ProductModel;
import POJO.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        PrintWriter printWriter = resp.getWriter();

        double price = Double.parseDouble(req.getParameter("price"));
        if(ProductModel.getInstance().check_add(new Product(name,price))){
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else{
            printWriter.print("Add Failed");
        }
    }
}
