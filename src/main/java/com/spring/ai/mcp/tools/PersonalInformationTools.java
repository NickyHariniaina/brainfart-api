package com.spring.ai.mcp.tools;

import org.springframework.stereotype.Service;
import org.springaicommunity.mcp.annotation.McpTool;

import com.spring.ai.mcp.service.MyInformationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonalInformationTools {

  private final MyInformationService myInformationService;

  @McpTool(description = "Returns personal information about myself")
  public String getUserInfo() {
    return buildUserInfo(myInformationService);
  }

  private String buildUserInfo(MyInformationService myInformationService) {
    return "Name: " + myInformationService.getFullName() + "\n" +
        "Username: " + myInformationService.getUsername() + "\n" +
        "Email: " + myInformationService.getEmail() + "\n" +
        "Phone Number: " + myInformationService.getPhoneNumber() + "\n" +
        "Age: " + myInformationService.getAge() + "\n" +
        "Gender: " + myInformationService.getGender() + "\n" +
        "Location: " + myInformationService.getLocation() + "\n" +
        "University: " + myInformationService.getUniversity() + "\n" +
        "Major: " + myInformationService.getMajor() + "\n" +
        "Interests: " + String.join(", ", myInformationService.getInterests());
  }

}
