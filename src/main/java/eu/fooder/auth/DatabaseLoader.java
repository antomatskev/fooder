package eu.fooder.auth;

import eu.fooder.models.User;
import eu.fooder.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static eu.fooder.security.UserRole.ADMIN;
import static eu.fooder.security.UserRole.ALL;
import static eu.fooder.security.UserRole.CUSTOMER;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepo repo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseLoader(UserRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<String> usernames = ((List<User>) repo.findAll()).stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
        if (!usernames.contains("admin")) {
            repo.save(new User(
                    1721L,
                    "admin",
                    passwordEncoder.encode("password321"),
                    ADMIN,
                    true,
                    true,
                    true,
                    true
            ));
        }
        if (!usernames.contains("customer")) {
            repo.save(new User(
                    1721L,
                    "customer",
                    passwordEncoder.encode("password123"),
                    CUSTOMER,
                    true,
                    true,
                    true,
                    true
            ));
        }
        if (!usernames.contains("uberAdmin")) {
            repo.save(new User(
                    1721L,
                    "customer",
                    passwordEncoder.encode("password1234"),
                    ALL,
                    true,
                    true,
                    true,
                    true
            ));
        }
        SecurityContextHolder.clearContext();
    }

}