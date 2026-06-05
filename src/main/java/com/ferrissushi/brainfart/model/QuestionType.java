package com.ferrissushi.brainfart.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "\"question_type\"")
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class QuestionType {
  @Id private String id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "questionType")
  private List<Room> rooms;
}
