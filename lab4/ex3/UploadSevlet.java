import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;



@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig
public class UploadSevlet extends HttpServlet {
    public  static  String UPLOAD_DIRECTORY = "uploads";

    protected static boolean checkStyle(String filename){
        String fileSupport = "txt, doc, docx, img, pdf, rar, zip";
        System.out.println(filename);
        return  fileSupport.contains(filename) ? true : false;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("upload.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            File uploadDir = new File(getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
             String filename = req.getParameter("filename");
             Part partFile = req.getPart("file");
             System.out.println(filename);
             String styleFile = partFile.getSubmittedFileName().split("\\.")[1];
             if (filename.strip() == "" || filename == null){
                 filename = partFile.getSubmittedFileName();
             }else {
                filename = filename +"."+ styleFile;
             }
             String filePath = uploadDir + File.separator + filename;
             File file = new File(filePath);
             if(file.exists()){
                 JsonObject errorResponse = new JsonObject();
                 errorResponse.addProperty("error", "File already exists");
                 resp.getWriter().print(errorResponse);
                 resp.getWriter().flush();
                 return;
             }
            System.out.println(checkStyle(styleFile));
             if (!checkStyle(styleFile)){
                 JsonObject errorResponse = new JsonObject();
                 errorResponse.addProperty("error", "Unsupported file extension:" + styleFile);
                 resp.getWriter().print("ok");
                 resp.getWriter().flush();
                 return;
             }
             partFile.write(filePath);
             resp.setContentType("text/html");
            String downloadLink = req.getContextPath() + "/" + UPLOAD_DIRECTORY + "/" + filename;
            resp.getWriter().write("<html><body><h3>File uploaded. \n" +
                    "Click here to visite file. Click <a href=\"" + downloadLink + "\">here</a> to download file.</h3></body></html>");
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
