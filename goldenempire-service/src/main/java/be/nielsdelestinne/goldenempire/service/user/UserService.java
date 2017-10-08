package be.nielsdelestinne.goldenempire.service.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import be.nielsdelestinne.goldenempire.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import static be.nielsdelestinne.goldenempire.utils.precondition.PreconditionChecker.checkPrecondition;
import static java.util.Collections.emptyList;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@Service
@Validated
public class UserService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }
}
