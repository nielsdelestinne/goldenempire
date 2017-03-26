package be.nielsdelestinne.goldenempire;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.TestConfiguration;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@SpringBootApplication
@TestConfiguration
public class GoldenEmpireApplicationDEV {

    /**
     * Runs on the Local development Environment
     */

    public static void main(String[] args) {
        new SpringApplicationBuilder(GoldenEmpireApplicationDEV.class)
                .profiles("dev")
                .run(args);
    }

}
