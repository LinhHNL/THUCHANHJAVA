import Model.LoginModel;
import Model.ProductModel;
import implement.LoginImplement;

import javax.security.auth.spi.LoginModule;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if (LoginModel.getInstance().check_login(name,password)){

            Cookie ck=new Cookie("name",name);
            response.addCookie(ck);
            ck.setMaxAge(60*60*30);

            request.setAttribute("name", name);
            request.setAttribute("list", ProductModel.getInstance().getALL());

            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);



        }




    }
}
