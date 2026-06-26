package com.spring.ai.mcp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Service
@Getter
@Setter
@NoArgsConstructor
public class MyInformationService {
  @Value("${name}")
  private String name;

  @Value("${lastname}")
  private String lastname;

  @Value("${username}")
  private String username;

  @Value("${email}")
  private String email;

  @Value("${phone.number}")
  private String phoneNumber;

  @Value("${age}")
  private int age;

  @Value("${gender}")
  private String gender;

  @Value("${location}")
  private String location;

  @Value("${university}")
  private String university;

  @Value("${major}")
  private String major;

  @Value("${interests}")
  private String interests; // we may need to split this

  public String getFullName() {
    return name + " " + lastname;
  }

  public String[] getInterests() {
    return interests.split(",");
  }
}
