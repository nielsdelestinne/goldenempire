package be.nielsdelestinne.goldenempire.service.user;

import be.nielsdelestinne.goldenempire.UnitTest;
import be.nielsdelestinne.goldenempire.domain.user.User;
import be.nielsdelestinne.goldenempire.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static be.nielsdelestinne.goldenempire.domain.user.User.UserBuilder.user;
import static be.nielsdelestinne.goldenempire.domain.user.UserTestBuilder.aUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends UnitTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void get_whenGivenId_thenGetUserFromRepository() {
        when(userRepository.findById(1)).thenReturn(user().withUsername("U$3r").build());

        User user = userService.get(1);

        assertThat(user.getUsername()).isEqualTo("U$3r");
    }

    @Test
    public void create_givenUserWithId_thenThrowException() {
        User userWithId = aUser()
                .withId(2L)
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("When creating a new user, there can not be assigned an ID beforehand.");

        userService.create(userWithId);
    }

}