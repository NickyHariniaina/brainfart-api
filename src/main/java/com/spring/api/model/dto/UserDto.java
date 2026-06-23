package com.spring.api.model.dto;

import com.spring.api.model.User;

public record UserDto(
    String name,
    String username,
    String email,
    String image,
    Integer rank,
    String displayUsername) {
  public static UserDto from(User user) {
    return new UserDto(
        user.getName(),
        user.getUsername(),
        user.getEmail(),
        user.getImage(),
        user.getRank(),
        user.getUsername());
  }
}
