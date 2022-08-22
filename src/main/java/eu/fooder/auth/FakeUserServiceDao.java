package eu.fooder.auth;

import com.google.common.collect.Lists;
import eu.fooder.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeUserServiceDao implements UserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeUserServiceDao(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return getAppUsers().stream().filter(u -> username.equals(u.getUsername())).findFirst();
    }

    private List<User> getAppUsers() {
        return Lists.newArrayList();
    }

}