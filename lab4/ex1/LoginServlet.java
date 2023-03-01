import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import static java.io.PrintWriter.*;

@WebServlet("/Login")

public class LoginServlet extends HttpServlet {
    HashMap<String, String> list = new HashMap<String, String>();

    @Override

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        list.put("linh", "12345678");
        list.put("dung", "12345678");
        list.put("duc", "12345678");
        list.put("tinh", "12345678");
        list.put("phuc", "12345678");
        list.put("nhat", "12345678");
        list.put("gam", "12345678");
        list.put("tiennge", "12345678");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            if (list.get(name).equals(password)) {
                printWriter.print(name+"/"+password +"not match");

            } else {
                printWriter.print(name+"/"+password + " not match");


            }
        } catch (NullPointerException e) {
            printWriter.print(name+"/"+password + " not match");



        }
    }
}
