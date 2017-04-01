package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import be.nielsdelestinne.goldenempire.service.user.UserService;
import com.jayway.restassured.http.ContentType;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TestTransaction;

import static be.nielsdelestinne.goldenempire.api.user.UserResource.USER_BASE_URL;
import static be.nielsdelestinne.goldenempire.domain.user.UserTestBuilder.aUser;
import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
public class UserResourceIntegrationTest extends ApiIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void create_whenCreateUser_thenReturnCreatedUser() {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDto providedUserDto = UserDto.userDto()
                .withUsername("Niels007")
                .withEmail("niels@mail.be")
//                .withPassword(passwordEncoder.encode("Password"));
                .withPassword("Password");

        UserDto persistedUserDto = given()
                .port(port)
                .basePath(USER_BASE_URL)
                .contentType(ContentType.JSON)
                .body(providedUserDto)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserDto.class);

        assertThat(persistedUserDto)
                .isEqualToIgnoringGivenFields(providedUserDto, "id");
        assertThat(persistedUserDto.id)
                .isEqualTo(1L);
    }

    /**
     * TODO
     * 1. TestTransaction issue...
     * 2. id issue: UUID instead of sequence!
     */
    @Test
    @Ignore
    public void get_givenId_whenGetUser_thenReturnUserForId() {
        User persistedUser = userService.create(aUser().build());
        TestTransaction.flagForCommit();
        TestTransaction.end();
        TestTransaction.start();

        UserDto returnedUserDto = given()
                .port(port)
                .basePath(USER_BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/" + persistedUser.getId())
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserDto.class);

        assertThat(returnedUserDto).isNotNull();
        assertThat(returnedUserDto.id).isEqualTo(persistedUser.getId());
        assertThat(returnedUserDto.username).isEqualTo(persistedUser.getUsername());
        assertThat(returnedUserDto.email).isEqualTo(persistedUser.getEmail());
        assertThat(returnedUserDto.password).isEqualTo(persistedUser.getPassword());

    }

}