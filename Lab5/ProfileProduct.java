import Model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ProfileProduct")
public class ProfileProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");



        Cookie ck[] = req.getCookies();
        if(ck!=null){
            String name=ck[0].getValue();
            if( !name.equals("") || name!=null){

                req.setAttribute("name", name);
                req.setAttribute("list", ProductModel.getInstance().getALL());
                req.getRequestDispatcher("index.jsp").forward(req, resp);


            }else {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
