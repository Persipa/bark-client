package site.persipa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class BarkClientApplication {
    public static void main(String[] args) {

        SpringApplication.run(BarkClientApplication.class, args);

        System.out.printf("\033[32m%s Started.\n\033[0m", Thread.currentThread().getStackTrace()[1].getClassName());

    }
}
