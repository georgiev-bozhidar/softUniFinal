package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.UserDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.UserLoginDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.UserRegisterDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateUserDTO;
import org.georgievbozhidar.softunifinal2.entity.model.*;
import org.georgievbozhidar.softunifinal2.exception.UserNotFoundException;
import org.georgievbozhidar.softunifinal2.repository.*;
import org.georgievbozhidar.softunifinal2.service.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final RestClient restClient;
    private final UserRepository userRepository;

    public UserServiceImpl(RestClient restClient, UserRepository userRepository) {
        this.restClient = restClient;
        this.userRepository = userRepository;
    }
    @Override
    public UserDTO getById(Long id) {
        return restClient.get().uri("/user/{id}", id).retrieve().body(UserDTO.class);
    }

    @Override public User findByUsername(String username) {
        Optional<User> optUser = userRepository.findByUsername(username);
        if (optUser.isEmpty()){
            throw new UserNotFoundException();
        }

        return optUser.get();
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> optUser = userRepository.findByEmail(email);
        if (optUser.isEmpty()){
            throw new UserNotFoundException();
        }

        return optUser.get();
    }

    @Override
    public UserDTO getByUsername(String username) {
        User user = this.findByUsername(username);
        return restClient.get().uri("/user/{id}", user.getId()).retrieve().body(UserDTO.class);
    }

    @Override
    public UserDTO getByEmail(String email) {
        User user = this.findByEmail(email);
        return restClient.get().uri("/user/{id}", user.getId()).retrieve().body(UserDTO.class);
    }

    @Override
    public UserDTO createUser(UserRegisterDTO userRegisterDTO) {
        return restClient.post().uri("/user")
                .body(userRegisterDTO)
                .retrieve().body(UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserDTO updateUserDTO) {
        return restClient.put().uri("/user/{id}", id).body(updateUserDTO).retrieve().body(UserDTO.class);
    }

    @Override
    public void createUser(String username, String password, String email, LocalDate birthday, Collection<Role> roles) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(username, password, password, email, birthday, roles);
        restClient.post().uri("/user").body(userRegisterDTO);
    }

    @Override
    public void loginUser(UserLoginDTO userLoginDTO){
        restClient.post().uri("/login").body(userLoginDTO);
    }

    @Override
    public void deleteUser(Long id){
        restClient.delete().uri("/user/{id}", id);
    }

//    @Override
//    public void order() {
//
//    }
//
//    @Override
//    public void checkout() {
//
//    }

}
