package com.ferrissushi.brainfart.model.dto;

import com.ferrissushi.brainfart.model.QuestionType;
import java.time.Instant;

public record CreateRoomDto(
    String title,
    Instant startDate,
    Integer chronoTiming,
    QuestionType questionType,
    Integer questionCount) {}
