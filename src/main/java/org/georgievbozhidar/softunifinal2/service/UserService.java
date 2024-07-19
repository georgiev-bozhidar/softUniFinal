package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.model.Chain;
import org.georgievbozhidar.softunifinal2.entity.model.User;

import java.util.Optional;

public interface UserService {
    public User findByUsername(String username);
    public User findByEmail(String email);
    public void createChain(Chain chain);
    public void order();
    public void checkout();
}
