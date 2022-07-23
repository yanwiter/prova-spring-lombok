package com.ucsbr.com.prova.service;

import com.ucsbr.com.prova.data.DetalheUserData;
import com.ucsbr.com.prova.entity.User;
import com.ucsbr.com.prova.repository.UserRepository;
import com.ucsbr.com.prova.service.dto.UserDTO;
import com.ucsbr.com.prova.service.mapper.UserMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@ComponentScan
@Service
public class UserService implements UserDetailsService {
	private final UserRepository userRepository;

	UserService(UserRepository userRepository) { // , UserMapper userMapper
		this.userRepository = userRepository;
		// this.userMapper = userMapper;
	}

	public Optional<User> findByEmail(String email) {
		return this.userRepository.findByEmailEquals(email);
	}

	public UserDTO save(UserDTO userDto) {
		User user = UserMapper.INSTANCE.toEntity(userDto);
		return UserMapper.INSTANCE.toDto(this.userRepository.save(user));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> usuario = userRepository.findByLogin(username);
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
		}
		return new DetalheUserData(usuario);
	}
}
