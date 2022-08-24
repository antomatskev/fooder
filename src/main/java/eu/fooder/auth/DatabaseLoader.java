package eu.fooder.auth;

import eu.fooder.models.Order;
import eu.fooder.models.Provider;
import eu.fooder.models.User;
import eu.fooder.repositories.ProviderRepo;
import eu.fooder.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static eu.fooder.security.UserRole.ADMIN;
import static eu.fooder.security.UserRole.ALL;
import static eu.fooder.security.UserRole.CUSTOMER;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepo userRepo;
    private final ProviderRepo providerRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception {
        List<String> usernames = ((List<User>) userRepo.findAll()).stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
        List<String> providers = ((List<Provider>) providerRepo.findAll()).stream()
                .map(Provider::getName)
                .collect(Collectors.toList());
        if (!usernames.contains("admin")) {
            userRepo.save(new User(
                    1721L,
                    ADMIN,
                    passwordEncoder.encode("password321"),
                    "admin",
                    "ad",
                    "min",
                    true,
                    true,
                    true,
                    true
//                    new Order(),
//                    new ArrayList<>()
            ));
        }
        if (!usernames.contains("customer")) {
            userRepo.save(new User(
                    1721L,
                    CUSTOMER,
                    passwordEncoder.encode("password123"),
                    "customer",
                    "cus",
                    "tomer",
                    true,
                    true,
                    true,
                    true
//                    new Order(),
//                    new ArrayList<>()
            ));
        }
        if (!usernames.contains("uberAdmin")) {
            userRepo.save(new User(
                    1721L,
                    ALL,
                    passwordEncoder.encode("password1234"),
                    "uberAdmin",
                    "uberAd",
                    "min",
                    true,
                    true,
                    true,
                    true
//                    new Order(),
//                    new ArrayList<>()
            ));
        }
        if (!providers.contains("testProvider1")) {
            providerRepo.save(new Provider(
                    1700L,
                    "testProvider1",
                    "test@provider1.pro",
                    "test"
            ));
        }
        if (!providers.contains("testProvider2")) {
            providerRepo.save(new Provider(
                    1701L,
                    "testProvider2",
                    "test@provider2.pro",
                    "test"
            ));
        }
        SecurityContextHolder.clearContext();
    }

}