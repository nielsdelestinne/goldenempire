package be.nielsdelestinne.goldenempire.domain.user;

import static be.nielsdelestinne.goldenempire.domain.user.User.UserBuilder.user;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
public class UserTestBuilder {

    private long id;
    private String username = "Niels007";
    private String email = "niels@mail.be";
    private String password = "xs4qsd3qsdq13wxc";

    public static UserTestBuilder aUser() {
        return new UserTestBuilder();
    }

    public User build() {
        return user()
                .withId(id)
                .withUsername(username)
                .withEmail(email)
                .withPassword(password)
                .build();
    }

    public UserTestBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public UserTestBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserTestBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserTestBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

}
