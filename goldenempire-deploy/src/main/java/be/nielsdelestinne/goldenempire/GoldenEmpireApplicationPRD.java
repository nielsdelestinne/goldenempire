package be.nielsdelestinne.goldenempire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@SpringBootApplication
public class GoldenEmpireApplicationPRD {

    /**
     * Runs on the PRD Environment!
     */
    public static void main(String[] args) {
        SpringApplication.run(GoldenEmpireApplicationPRD.class, args);
    }

}
