package com.spring.api.endpoint.rest.controller;

import com.spring.api.model.Room;
import com.spring.api.model.dto.CreateRoomDto;
import com.spring.api.model.dto.RoomDto;
import com.spring.api.service.RoomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "Room")
public class RoomController {
  private final RoomService roomService;

  @GetMapping("/rooms")
  public List<RoomDto> getAll() {
    return roomService.findAll();
  }

  @PostMapping("/rooms")
  public Room save(@RequestBody @Valid CreateRoomDto request) {
    return roomService.save(request);
  }
}
