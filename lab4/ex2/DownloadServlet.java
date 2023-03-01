import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("File Not Found");
        String filename = req.getParameter("file");

        if (filename!=null) {
            PrintWriter out = resp.getWriter();
            String filepath = "C:\\Users\\lep61\\IdeaProjects\\lab4\\ImageProject\\src\\main\\Image\\";
            File downloadFile = new File(filepath+filename);
            FileInputStream fileInputStream = new FileInputStream(downloadFile);
            resp.setContentType("application/octet-stream");
            resp.setContentLength((int) downloadFile.length());
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            resp.setHeader("Content-Disposition", headerValue);

            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            out.close();
        }
    }
        /*String filePath = getServletContext().getRealPath("/" + "Image" + File.separator + filename);*/
}




