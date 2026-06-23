package com.spring.api.service;

import com.spring.api.exception.ResourceNotFoundException;
import com.spring.api.model.Room;
import com.spring.api.model.User;
import com.spring.api.model.dto.CreateRoomDto;
import com.spring.api.model.dto.RoomDto;
import com.spring.api.repository.QuestionTypeRepository;
import com.spring.api.repository.RoomRepository;
import com.spring.api.repository.UserRepository;
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
  private final QuestionTypeRepository questionTypeRepository;

  public List<RoomDto> findAll() {
    return roomRepository.findAll().stream().map(RoomDto::from).toList();
  }

  public Room save(CreateRoomDto request) {
    var questionType =
        questionTypeRepository
            .findByName(request.questionTypeName())
            .orElseThrow(() -> new ResourceNotFoundException("Type not found"));
    var user = userRepository.findByUsername("ferrissushi").orElse(User.builder().build());
    var room = request.toRoom(user, questionType);
    return roomRepository.save(room);
  }
}
