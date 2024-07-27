package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.UserDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.UserLoginDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.UserRegisterDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateUserDTO;
import org.georgievbozhidar.softunifinal2.entity.model.*;

import java.time.LocalDate;
import java.util.Collection;

public interface UserService {
    public User findByUsername(String username);
    public User findByEmail(String email);
    public UserDTO getByUsername(String username);
    public UserDTO getByEmail(String email);
    public UserDTO getById(Long id);

    public UserDTO createUser(UserRegisterDTO userRegisterDTO);
    public UserDTO createUser(String username, String password, String email, LocalDate birthday, Collection<Role> roles);

    public void loginUser(UserLoginDTO userLoginDTO);

    public UserDTO updateUser(Long id, UpdateUserDTO updateUserDTO);

    public void deleteUser(Long id);

//    public void order();
//    public void checkout();

}
