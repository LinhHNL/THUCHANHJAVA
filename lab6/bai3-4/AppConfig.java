import Model.PdfTextWrite;
import Model.PlainTextWrite;
import Repository.TextWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "Model")

public class AppConfig {

    @Bean
    public TextEditor textEditor(@Qualifier("plain") @Autowired TextWrite textWrite) {
        TextEditor p = new TextEditor();
       return  p;
    }
    @Bean
    @Qualifier("plain")
    public PlainTextWrite PlainTextWrite() {
        return  new PlainTextWrite();
    }
    @Bean
    @Qualifier("pdfWrite")
    public PdfTextWrite PdfTextWriter() {
        return  new PdfTextWrite();
    }

}