package com.ferrissushi.brainfart.model.dto;

import com.ferrissushi.brainfart.model.QuestionType;
import com.ferrissushi.brainfart.model.Room;
import com.ferrissushi.brainfart.model.User;
import java.time.Instant;

public record RoomDto(
    String title,
    Instant startDate,
    QuestionType questionType,
    Integer questionCount,
    Boolean closed,
    User openedBy,
    User winner) {
  public static RoomDto from(Room room) {
    return new RoomDto(
        room.getTitle(),
        room.getStartDate(),
        room.getQuestionType(),
        room.getQuestionCount(),
        room.getClosed(),
        room.getOpenedBy(),
        room.getWinner());
  }
}
