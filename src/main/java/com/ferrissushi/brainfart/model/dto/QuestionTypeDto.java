package com.ferrissushi.brainfart.model.dto;

import com.ferrissushi.brainfart.model.QuestionType;
import java.util.UUID;

public record QuestionTypeDto(String name) {
  public QuestionType toQuestionType() {
    return QuestionType.builder().id(UUID.randomUUID().toString()).name(this.name).build();
  }
}
