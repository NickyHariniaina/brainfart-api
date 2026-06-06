package com.ferrissushi.brainfart.model.dto;

import com.ferrissushi.brainfart.model.QuestionType;
import com.ferrissushi.brainfart.model.User;
import java.time.Instant;

public record RoomDto(
    String title,
    Instant startDate,
    QuestionType questionType,
    Integer questionCount,
    Boolean closed,
    User openedBy,
    User winner) {}
