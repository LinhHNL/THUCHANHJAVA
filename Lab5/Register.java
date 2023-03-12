import Model.LoginModel;
import POJO.Login;
import implement.LoginImplement;

import javax.security.auth.spi.LoginModule;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Register")
public class Register extends HttpServlet {




    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        String password = request.getParameter("password");
        String confirm_password = request.getParameter("password-confirm");
if(password.equals(confirm_password)){
    if (LoginModel.getInstance().check_register(new Login(name,email,password))){

        Cookie ck=new Cookie("name",name);
        response.addCookie(ck);
        request.setAttribute("name", name);
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }else{
        request.setAttribute("msg", "Account exists");
        request.getRequestDispatcher("register.jsp").forward(request, response);

    }
}else {
    request.setAttribute("msg", "password error");
    request.getRequestDispatcher("register.jsp").forward(request, response);

}





    }
}
