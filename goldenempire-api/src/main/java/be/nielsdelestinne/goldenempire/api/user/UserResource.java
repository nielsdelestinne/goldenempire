package be.nielsdelestinne.goldenempire.api.user;

import be.nielsdelestinne.goldenempire.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@RestController
@RequestMapping(value = UserResource.USER_BASE_URL)
public class UserResource {

    static final String USER_BASE_URL = "/api/users";

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserResource(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDto create(@RequestBody UserDto userDto) {
        return userMapper.map(
                userService.create(userMapper.map(userDto)));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDto get(@PathVariable long id) {
        return userMapper.map(userService.get(id));
    }

}
