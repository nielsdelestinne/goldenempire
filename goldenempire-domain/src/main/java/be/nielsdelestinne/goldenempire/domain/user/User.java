package be.nielsdelestinne.goldenempire.domain.user;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = User.USER_TABLE_NAME)
public class User {

    public static final String USER_TABLE_NAME = "GE_USER";
    public static final String USER_COLUMN_USERNAME = "USERNAME";
    public static final String USER_COLUMN_EMAIL = "EMAIL";
    public static final String USER_COLUMN_PASSWORD = "PASSWORD";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = USER_COLUMN_USERNAME, nullable = false, length = 100, unique = true)
    private String username;

    @NotNull
    @Column(name = USER_COLUMN_EMAIL, nullable = false)
    private String email;

    @NotNull
    @Column(name = USER_COLUMN_PASSWORD, nullable = false)
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
