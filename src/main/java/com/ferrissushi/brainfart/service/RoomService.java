package com.ferrissushi.brainfart.service;

import com.ferrissushi.brainfart.model.dto.RoomDto;
import com.ferrissushi.brainfart.repository.RoomRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RoomService {
  private final RoomRepository roomRepository;

  public List<RoomDto> findAll() {
    return roomRepository.findAll().stream().map(RoomDto::from).toList();
  }
}
