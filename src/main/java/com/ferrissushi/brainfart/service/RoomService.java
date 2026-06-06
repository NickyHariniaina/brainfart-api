package com.ferrissushi.brainfart.service;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ferrissushi.brainfart.model.Room;
import com.ferrissushi.brainfart.repository.RoomRepository;

@Service
@AllArgsConstructor
@Slf4j
public class RoomService {
  private final RoomRepository roomRepository;
}
