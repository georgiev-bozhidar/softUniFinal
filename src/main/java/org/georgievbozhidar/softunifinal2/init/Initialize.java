package org.georgievbozhidar.softunifinal2.init;

import org.georgievbozhidar.softunifinal2.entity.enums.Roles;
import org.georgievbozhidar.softunifinal2.entity.model.Role;
import org.georgievbozhidar.softunifinal2.repository.RoleRepository;
import org.georgievbozhidar.softunifinal2.repository.UserRepository;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Initialize implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Initialize(RoleRepository roleRepository, UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
    }

    public void initRoles(){
        if (roleRepository.count() > 0) {
            return;
        }

        Roles[] rolesArray = Roles.values();

        for (Roles roles : rolesArray) {
            Role role = new Role();
            role.setRoles(roles);
            roleRepository.save(role);
        }
    }
}
