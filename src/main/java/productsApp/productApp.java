package productsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Application that perform following actions:  <br>
 * -CRUD <br>
 * -CRUD ErrorHandler<br>
 * -BAD_REQUEST Handler<br>
 * -correct Angular redirect
 *
 * @author Ekaterina
 * @version 1.0
 */
@SpringBootApplication
//@ComponentScan
//@EnableJpaRepositories(basePackages = {"productApp.repositories"})
public class productApp {


    public static void main(String[] args) {
        SpringApplication.run(productApp.class, args);
    }


    @Bean
    public UrlBasedViewResolver resolver() {

        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/static/");
        resolver.setSuffix(".html");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
