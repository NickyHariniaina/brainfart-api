package com.spring.api.endpoint.rest.controller;

import com.spring.api.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
    Authentication auth = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(username, password)
      );
    var token = jwtService.generateToken((UserDetails) auth.getPrincipal());
    response.addHeader("Set-Cookie", "JWT-TOKEN=" + token + "; HttpOnly; PATH=/");
    return "redirect:/dashboard";
  }

  @GetMapping("/dashboard")
  public String dashboard(Authentication authentication, Map<String, Object> model) {
    model.put("username", authentication.getName());
    return "dashboard";
  }

  @PostMapping("/logout")
  public String logout(HttpServletResponse response) {
    response.addHeader("Set-Cookie", "JWT-TOKEN=; HttpOnly; Path=/; Max-Age=0");
    return "redirect:/login";
  }
}
