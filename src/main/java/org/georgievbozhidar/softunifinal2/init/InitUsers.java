package org.georgievbozhidar.softunifinal2.init;

import org.georgievbozhidar.softunifinal2.entity.model.User;
import org.georgievbozhidar.softunifinal2.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class InitUsers implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public InitUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() > 0){
            return;
        }

        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        adminUser.setEmail("admin@admin.com");
        adminUser.setBirthday(LocalDate.of(2001, 1, 1));
        userRepository.save(adminUser);
    }
}
