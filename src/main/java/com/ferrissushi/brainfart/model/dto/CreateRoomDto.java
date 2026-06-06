package com.ferrissushi.brainfart.model.dto;

import com.ferrissushi.brainfart.model.QuestionType;
import com.ferrissushi.brainfart.model.Room;
import java.time.Instant;

public record CreateRoomDto(
    String title,
    Instant startDate,
    Integer chronoTiming,
    QuestionType questionType,
    Integer questionCount) {
  public Room to() {
    return Room.builder()
        .title(this.title)
        .startDate(this.startDate)
        .chronoTiming(this.chronoTiming)
        .questionType(this.questionType)
        .questionCount(this.questionCount)
        .build();
  }
}
