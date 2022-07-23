package com.ucsbr.com.prova.service;

import com.ucsbr.com.prova.entity.User;
import com.ucsbr.com.prova.repository.UserRepository;
import com.ucsbr.com.prova.service.dto.UserDTO;
import com.ucsbr.com.prova.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  UserService(UserRepository userRepository, UserMapper userMapper){
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public Optional<User> findByEmail(String email){
    return userRepository.findByEmailEquals(email);
  }

  public UserDTO save(UserDTO userDto){
    User user = userMapper.toEntity(userDto);
    return userMapper.toDto(userRepository.save(user));
  }
}
