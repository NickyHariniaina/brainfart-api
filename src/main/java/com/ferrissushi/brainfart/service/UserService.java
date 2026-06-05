package com.ferrissushi.brainfart.service;

import com.ferrissushi.brainfart.model.User;
import com.ferrissushi.brainfart.model.dto.CreateUserDto;
import com.ferrissushi.brainfart.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User save(CreateUserDto request) {
    var user =
        User.builder()
            .id(UUID.randomUUID().toString())
            .name(request.name())
            .username(request.username())
            .email(request.email())
            .image(request.image())
            .rank(0)
            .banned(false)
            .role(User.Role.USER)
            .banReason(null)
            .emailVerified(false)
            .displayUsername(request.username())
            .createdAt(Instant.now())
            .updatedAt(Instant.now())
            .highestScore(0)
            .banExpires(null)
            .build();
    return userRepository.save(user);
  }
}
