import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import  java.io.File;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/image2")
public class ImageServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String filePath = "C:\\Users\\lep61\\IdeaProjects\\lab4\\ImageProject\\src\\main\\Image\\cat2.png";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);

        response.setContentType("application/octet-stream");
        response.setContentLength((int) downloadFile.length());
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader("Content-Disposition", headerValue);

        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
    }
}
