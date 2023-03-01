import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


@WebServlet(urlPatterns = "/image1")
public class ImageServlet1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        File f = new File("C:\\Users\\lep61\\IdeaProjects\\lab4\\ImageProject\\src\\main\\Image\\cat1.png");
        BufferedImage bi = ImageIO.read(f);
        ImageIO.write(bi, "png", resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
