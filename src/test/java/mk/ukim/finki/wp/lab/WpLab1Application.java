package mk.ukim.finki.wp.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WpLab1Application {
    public WpLab1Application() {
    }

    public static void main(String[] args) {
        SpringApplication.run(WpLab1Application.class, args);
    }

}