package com.spring.api.model.dto;

import com.spring.api.model.QuestionType;
import com.spring.api.model.Room;
import com.spring.api.model.User;
import java.time.Instant;
import java.util.UUID;

public record CreateRoomDto(
    String title,
    Instant startDate,
    Integer chronoTiming,
    String questionTypeName,
    Integer questionCount) {
  public Room toRoom(User creator, QuestionType questionType) {
    return Room.builder()
        .title(this.title)
        .startDate(this.startDate)
        .chronoTiming(this.chronoTiming)
        .questionType(questionType)
        .questionCount(this.questionCount)
        .openedBy(creator)
        .id(UUID.randomUUID().toString())
        .closed(false)
        .build();
  }
}
