import Model.ProductModel;
import POJO.Product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        int ma  = Integer.parseInt(request.getParameter("id"));
        if(ProductModel.getInstance().check_delete(ma)){request.getRequestDispatcher("index.jsp").include(request, response);}else {
            out.print("SAi");
        }



    }
}