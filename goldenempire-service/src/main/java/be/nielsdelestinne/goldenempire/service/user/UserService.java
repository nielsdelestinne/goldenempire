package be.nielsdelestinne.goldenempire.service.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import be.nielsdelestinne.goldenempire.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import static be.nielsdelestinne.goldenempire.utils.precondition.PreconditionChecker.checkPrecondition;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@Service
@Validated
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(long id){
        return userRepository.findById(id);
    }

    @Transactional
    public User create(@Valid User user) {
        checkPrecondition(user.getId() == 0, "When creating a new user, there can not be assigned an ID beforehand.");
        return userRepository.save(user);
    }
}
