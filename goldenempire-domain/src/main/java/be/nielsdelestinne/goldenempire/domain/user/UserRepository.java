package be.nielsdelestinne.goldenempire.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long userId);

}
