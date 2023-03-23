import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Product product1 = (Product) context.getBean("product1");
        Product product2 = (Product) context.getBean("product2");
        Product product3 = (Product) context.getBean("product3");

        System.out.println("Product 1: " + product1);
        System.out.println("Product 2: " + product2);
        System.out.println("Product 3: " + product3);

        System.out.println("Product 1 is prototype: " + context.isPrototype("product1"));
        System.out.println("Product 2 is prototype: " + context.isPrototype("product2"));
        System.out.println("Product 3 is singleton: " + context.isSingleton("product3"));
    }
}