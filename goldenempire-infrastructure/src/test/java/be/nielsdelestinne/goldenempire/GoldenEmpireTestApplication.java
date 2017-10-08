package be.nielsdelestinne.goldenempire;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@SpringBootApplication
public class GoldenEmpireTestApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GoldenEmpireTestApplication.class)
                .profiles("test")
                .run(args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
