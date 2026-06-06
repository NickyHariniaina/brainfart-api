package com.ferrissushi.brainfart.service;

import com.ferrissushi.brainfart.model.Room;
import com.ferrissushi.brainfart.model.User;
import com.ferrissushi.brainfart.model.dto.CreateRoomDto;
import com.ferrissushi.brainfart.model.dto.RoomDto;
import com.ferrissushi.brainfart.repository.RoomRepository;
import com.ferrissushi.brainfart.repository.UserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RoomService {
  private final RoomRepository roomRepository;
  private final UserRepository userRepository;

  public List<RoomDto> findAll() {
    return roomRepository.findAll().stream().map(RoomDto::from).toList();
  }

  public Room Save(CreateRoomDto request) {
    var user = userRepository.findByUsername("ferrissushi").orElse(User.builder().build());
    var room = request.toRoom(user);
    return roomRepository.save(room);
  }
}
