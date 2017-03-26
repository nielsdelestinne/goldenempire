package be.nielsdelestinne.goldenempire.service.user;

import be.nielsdelestinne.goldenempire.domain.user.User;
import be.nielsdelestinne.goldenempire.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@Service
public class UserService {

//    @Transactional op alle db manipulaties!

    @Autowired
    private UserRepository userRepository;

    public User getUser(long userId){
        return userRepository.findById(userId);
    }

}
