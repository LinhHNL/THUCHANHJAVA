import Repository.TextWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor  {
    @Qualifier("plain")
    @Autowired
   private TextWrite textWrite;
   private  String text;
public void save(String str){
    textWrite.write(str,this.text);
}
public void input(String str){
    this.text = str;
}
    }

