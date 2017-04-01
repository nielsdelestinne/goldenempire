package be.nielsdelestinne.goldenempire.domain.user;

import javax.persistence.*;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = User.USER_TABLE_NAME)
public class User {

    public static final String USER_TABLE_NAME = "USER_APP";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String email;
    public String password;

    private User() {
    }

    private User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public static class UserBuilder {

        private String username;
        private String email;
        private String password;
        private long id;

        public static UserBuilder user() {
            return new UserBuilder();
        }

        public User build() {
            return new User(id, username, email, password);
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withId(long id) {
            this.id = id;
            return this;
        }
    }
}
