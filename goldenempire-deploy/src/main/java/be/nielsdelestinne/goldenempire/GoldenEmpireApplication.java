package be.nielsdelestinne.goldenempire;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static java.lang.Boolean.parseBoolean;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@SpringBootApplication
public class GoldenEmpireApplication {

    public static void main(String[] args) {
        if(parseBoolean(System.getProperty("profile"))) {
            new SpringApplicationBuilder(GoldenEmpireApplication.class)
                    .profiles(System.getProperty("profile"))
                    .run(args);
        } else {
            new SpringApplicationBuilder(GoldenEmpireApplication.class)
                    .profiles("dev")
                    .run(args);
        }
    }

}
