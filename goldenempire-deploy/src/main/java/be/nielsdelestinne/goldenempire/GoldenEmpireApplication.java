package be.nielsdelestinne.goldenempire;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@SpringBootApplication
public class GoldenEmpireApplication {

    public static void main(String[] args) {
        if(args.length == 1) {
            new SpringApplicationBuilder(GoldenEmpireApplication.class)
                    .profiles(Environment.valueOf(args[0]).getEnvironmentLabel())
                    .run(args);
        } else {
            new SpringApplicationBuilder(GoldenEmpireApplication.class)
                    .profiles("dev")
                    .run(args);
        }
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
