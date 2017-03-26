package be.nielsdelestinne.goldenempire.service.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import be.nielsdelestinne.goldenempire.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getUser() {
        when(userRepository.findById(1)).thenReturn(User.UserBuilder.user().withUsername("U$3r").build());

        User user = userService.getUser(1);

        assertThat(user.getUsername()).isEqualTo("U$3r");
    }

}