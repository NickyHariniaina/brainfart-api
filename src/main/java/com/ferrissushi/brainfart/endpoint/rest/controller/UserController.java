package com.ferrissushi.brainfart.endpoint.rest.controller;

import com.ferrissushi.brainfart.model.User;
import com.ferrissushi.brainfart.model.dto.CreateUserDto;
import com.ferrissushi.brainfart.model.dto.UserDto;
import com.ferrissushi.brainfart.service.UserService;
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
