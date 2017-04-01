package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static be.nielsdelestinne.goldenempire.api.user.UserDto.userDto;
import static be.nielsdelestinne.goldenempire.domain.user.User.UserBuilder.user;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void map_givenUserDto_thenMapToUser() {
        UserDto userDto = userDto()
                .withUsername("Niels007")
                .withEmail("niels@mail.be")
                .withPassword("Password");

        User user = userMapper.map(userDto);

        assertThat(user.getUsername()).isEqualTo(userDto.username);
        assertThat(user.getEmail()).isEqualTo(userDto.email);
        assertThat(user.getPassword()).isEqualTo(userDto.password);
    }

    @Test
    public void map_givenUser_thenMapToUserDto() {
        User user = user()
                .withUsername("Niels007")
                .withEmail("niels@mail.be")
                .withPassword("Password")
                .build();

        UserDto userDto = userMapper.map(user);

        assertThat(userDto.username).isEqualTo(user.getUsername());
        assertThat(userDto.email).isEqualTo(user.getEmail());
        assertThat(userDto.password).isEqualTo(user.getPassword());
    }

}