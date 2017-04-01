package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import org.springframework.stereotype.Component;

import static be.nielsdelestinne.goldenempire.api.user.UserDto.userDto;
import static be.nielsdelestinne.goldenempire.domain.user.User.UserBuilder.user;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@Component
public class UserMapper {

    public User map(UserDto userDto) {
        return user()
                .withUsername(userDto.username)
                .withEmail(userDto.email)
                .withPassword(userDto.password)
                .build();
    }

    public UserDto map(User user) {
        return userDto()
                .withId(user.getId())
                .withUsername(user.getUsername())
                .withEmail(user.getEmail())
                .withPassword(user.getPassword());
    }
}
