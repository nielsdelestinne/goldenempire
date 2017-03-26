package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import be.nielsdelestinne.goldenempire.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@RestController
@RequestMapping(value = UserResource.USER_BASE_URL)
public class UserResource {

    static final String USER_BASE_URL = "/api/user";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDto getUser(@PathVariable long userId) {
        User user = userService.getUser(userId);
        return new UserDto(user);
    }

}
