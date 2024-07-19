package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.model.Chain;
import org.georgievbozhidar.softunifinal2.entity.model.User;
import org.georgievbozhidar.softunifinal2.repository.ChainRepository;
import org.georgievbozhidar.softunifinal2.repository.UserRepository;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ChainRepository chainRepository;

    public UserServiceImpl(UserRepository userRepository, ChainRepository chainRepository) {
        this.userRepository = userRepository;
        this.chainRepository = chainRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void createChain(Chain chain) {
        chainRepository.save(chain);
    }

    @Override
    public void order() {

    }

    @Override
    public void checkout() {

    }
}
