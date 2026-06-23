package com.spring.api.endpoint.rest.controller;

import com.spring.api.model.User;
import com.spring.api.model.dto.CreateUserDto;
import com.spring.api.model.dto.UserDto;
import com.spring.api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "users")
public class UserController {
  private final UserService userService;

  @GetMapping("/users")
  public List<UserDto> getAll() {
    return userService.getAll();
  }

  @PostMapping("/users")
  public User save(@RequestBody @Valid CreateUserDto request) {
    return userService.save(request);
  }
}
