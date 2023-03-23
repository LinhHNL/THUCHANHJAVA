import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TextEditor textEditor= (TextEditor) context.getBean(TextEditor.class);
        textEditor.input("Huỳnh nhật Linh");
        textEditor.save("temp.txt");

    }
}
