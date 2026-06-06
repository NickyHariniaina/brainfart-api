package com.ferrissushi.brainfart.endpoint.rest.controller;

import com.ferrissushi.brainfart.model.dto.RoomDto;
import com.ferrissushi.brainfart.service.RoomService;

import io.swagger.v3.oas.annotations.tags.Tag;

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
}
