package org.georgievbozhidar.softunifinal2.init;

import org.georgievbozhidar.softunifinal2.entity.enums.Roles;
import org.georgievbozhidar.softunifinal2.entity.model.Role;
import org.georgievbozhidar.softunifinal2.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRoles implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public InitRoles(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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
