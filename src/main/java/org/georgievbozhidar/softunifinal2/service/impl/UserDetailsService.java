package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.model.User;
import org.georgievbozhidar.softunifinal2.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(UserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with that username not found."));
    }

    public static org.georgievbozhidar.softunifinal2.entity.model.UserDetails map(User user){
        return new org.georgievbozhidar.softunifinal2.entity.model.UserDetails(
                user.getUsername(),
                user.getPassword(),
                List.of()); // TODO
    }
}
