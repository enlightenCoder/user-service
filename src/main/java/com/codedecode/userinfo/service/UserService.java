package com.codedecode.userinfo.service;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO) {
        User saveUser = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));

        return UserMapper.INSTANCE.mapUserToUserDTO(saveUser);
    }

    public UserDTO getUserById(Integer id) {

        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User id : " + id + " does not exist."));

        return UserMapper.INSTANCE.mapUserToUserDTO(user);
    }

}
