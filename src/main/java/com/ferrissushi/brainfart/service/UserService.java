package com.ferrissushi.brainfart.service;

import com.ferrissushi.brainfart.model.User;
import com.ferrissushi.brainfart.repository.UserRepository;
import java.util.List;
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

  public User save(User user) {
    return userRepository.save(user);
  }
}
