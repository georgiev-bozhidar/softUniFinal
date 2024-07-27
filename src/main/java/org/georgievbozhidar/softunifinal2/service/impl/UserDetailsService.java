package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.model.User;
import org.georgievbozhidar.softunifinal2.exception.UserNotFoundException;
import org.georgievbozhidar.softunifinal2.repository.UserRepository;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserService userService;

    public UserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        return map(userService.findByUsername(username));
    }

    public static org.georgievbozhidar.softunifinal2.entity.model.UserDetails map(User user){
        return new org.georgievbozhidar.softunifinal2.entity.model.UserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getRoles());
    }
}
