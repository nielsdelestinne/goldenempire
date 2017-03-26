package be.nielsdelestinne.goldenempire;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@SpringBootApplication
public class GoldenEmpireApplication {

    /**
     * Runs on the Local development Environment
     */

    public static void main(String[] args) {
        new SpringApplicationBuilder(GoldenEmpireApplication.class)
                .profiles("dev")
                .run(args);
    }

}
