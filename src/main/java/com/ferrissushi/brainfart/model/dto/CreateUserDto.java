package com.ferrissushi.brainfart.model.dto;

import java.io.Serializable;

import com.ferrissushi.brainfart.model.User.Role;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class CreateUserDto implements Serializable {
    private String name;
    private String username;
    private String email;
    private String image;
    private Role role;
}
