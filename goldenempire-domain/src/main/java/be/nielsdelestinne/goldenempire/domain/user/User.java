package be.nielsdelestinne.goldenempire.domain.user;

import javax.persistence.*;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@Entity
@Access(AccessType.FIELD)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String email;

    private User() {
    }

    private User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public static class UserBuilder {

        private String username;
        private String email;

        public static UserBuilder user() {
            return new UserBuilder();
        }

        public User build() {
            return new User(username, email);
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }
    }
}
