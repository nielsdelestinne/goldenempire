package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.GoldenEmpireTestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@SpringBootTest(
        classes = GoldenEmpireTestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application-test.properties")
public abstract class ApiIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @LocalServerPort
    int port;

}
