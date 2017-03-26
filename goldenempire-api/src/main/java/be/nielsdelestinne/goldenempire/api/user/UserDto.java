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

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
