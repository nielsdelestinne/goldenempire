package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static be.nielsdelestinne.goldenempire.api.user.UserDto.userDto;
import static be.nielsdelestinne.goldenempire.domain.user.User.UserBuilder.user;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@Component
public class UserMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserMapper(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User map(UserDto userDto) {
        return user()
                .withUsername(userDto.username)
                .withEmail(userDto.email)
                .withPassword(bCryptPasswordEncoder.encode(userDto.password))
                .build();
    }

    public UserDto map(User user) {
        return userDto()
                .withId(user.getId())
                .withUsername(user.getUsername())
                .withEmail(user.getEmail());
    }
}
