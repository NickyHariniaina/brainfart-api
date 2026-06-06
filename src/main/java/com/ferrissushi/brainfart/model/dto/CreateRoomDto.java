package com.ferrissushi.brainfart.model.dto;

import com.ferrissushi.brainfart.model.QuestionType;
import com.ferrissushi.brainfart.model.Room;
import com.ferrissushi.brainfart.model.User;

import java.time.Instant;
import java.util.UUID;

public record CreateRoomDto(
    String title,
    Instant startDate,
    Integer chronoTiming,
    QuestionType questionType,
    Integer questionCount) {
  public Room toRoom(User creator) {
    return Room.builder()
        .title(this.title)
        .startDate(this.startDate)
        .chronoTiming(this.chronoTiming)
        .questionType(this.questionType)
        .questionCount(this.questionCount)
        .openedBy(creator)
        .id(UUID.randomUUID().toString())
        .closed(false)
        .build();
  }
}
