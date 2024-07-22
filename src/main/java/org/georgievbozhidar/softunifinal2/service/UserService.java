package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.UserRegisterDTO;
import org.georgievbozhidar.softunifinal2.entity.model.*;

import java.util.Optional;

public interface UserService {
    public User findByUsername(String username);
    public User findByEmail(String email);

    public void order();
    public void checkout();
}
