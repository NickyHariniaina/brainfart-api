package com.spring.api.service;

import com.spring.api.model.User;
import com.spring.api.model.dto.CreateUserDto;
import com.spring.api.model.dto.UserDto;
import com.spring.api.repository.UserRepository;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public List<UserDto> getAll() {
    return userRepository.findAll().stream().map(UserDto::from).toList();
  }

  public User save(CreateUserDto request) {
    var user = User.builder()
        .id(UUID.randomUUID().toString())
        .name(request.name())
        .username(request.username())
        .email(request.email())
        .password(passwordEncoder.encode(request.password()))
        .image(request.image())
        .rank(0)
        .banned(false)
        .role(User.Role.USER)
        .banReason(null)
        .emailVerified(false)
        .displayUsername(request.username())
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .currentScore(0)
        .banExpires(null)
        .build();
    return userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));
    return user;
  }
}
