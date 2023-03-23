import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public Product product1() {
        Product p = new Product();
        p.setId(1);
        p.setName("Product 1");
        p.setPrice(10.5);
        p.setDescription("This is product 1");
        return p;
    }

    @Bean
    @Scope("prototype")
    public Product product2() {
        Product p = new Product();
        p.setId(2);
        p.setName("Product 2");
        p.setPrice(15.0);
        p.setDescription("This is product 2");
        return p;
    }

    @Bean
    @Scope("singleton")
    public Product product3() {
        Product p = new Product();
        p.setId(3);
        p.setName("Product 3");
        p.setPrice(20.0);
        p.setDescription("This is product 3");
        return p;
    }
}
