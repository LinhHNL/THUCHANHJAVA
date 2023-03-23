package Model;

import Repository.TextWrite;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
@Component
public class PdfTextWrite implements TextWrite {
    @Override
    public void write(String filename, String text)  {

        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
