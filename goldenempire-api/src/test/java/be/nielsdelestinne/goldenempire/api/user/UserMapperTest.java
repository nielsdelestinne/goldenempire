package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static be.nielsdelestinne.goldenempire.api.user.UserDto.userDto;
import static be.nielsdelestinne.goldenempire.domain.user.User.UserBuilder.user;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void map_givenUserDto_thenMapToUserAndPasswordEncrypted() {
        UserDto userDto = userDto()
                .withUsername("Niels007")
                .withEmail("niels@mail.be")
                .withPassword("Password");
        Mockito.when(bCryptPasswordEncoder.encode("Password")).thenReturn("EncryptedPassword");


        User user = userMapper.map(userDto);

        assertThat(user.getUsername()).isEqualTo(userDto.username);
        assertThat(user.getEmail()).isEqualTo(userDto.email);
        assertThat(user.getPassword()).isEqualTo("EncryptedPassword");
    }

    @Test
    public void map_givenUser_thenMapToUserDtoLeavingPasswordNull() {
        User user = user()
                .withUsername("Niels007")
                .withEmail("niels@mail.be")
                .withPassword("Password")
                .build();

        UserDto userDto = userMapper.map(user);

        assertThat(userDto.username).isEqualTo(user.getUsername());
        assertThat(userDto.email).isEqualTo(user.getEmail());
        assertThat(userDto.password).isNull();
    }

}