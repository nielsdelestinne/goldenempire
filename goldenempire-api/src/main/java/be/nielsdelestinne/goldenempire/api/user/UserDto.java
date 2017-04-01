package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.domain.user.User;

import java.io.Serializable;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
public class UserDto implements Serializable{

    public long id;
    public String username;
    public String email;
    public String password;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.password;
    }

    private UserDto() {
    }

    public static UserDto userDto() {
        return new UserDto();
    }

    public UserDto withId(long id) {
        this.id = id;
        return this;
    }

    public UserDto withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDto withPassword(String password) {
        this.password = password;
        return this;
    }
}
