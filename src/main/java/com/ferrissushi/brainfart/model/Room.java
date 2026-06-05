package com.ferrissushi.brainfart.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "\"room\"")
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(unique = true)
  private String title;

  @Column(name = "start_date")
  @Builder.Default
  private Instant startDate = Instant.now();

  @Column(name = "chrono_timing", nullable = false)
  @Builder.Default
  private Integer chronoTiming = 10;

  @Column(name = "question_type")
  @Builder.Default
  private QuestionType questionType = new QuestionType(UUID.randomUUID().toString(), "ALL");


  @Column(name = "question_count", nullable = false)
  @Builder.Default
  private Integer questionCount = 10;

  @Column(name = "opened_by", nullable = false)
  private User openedBy;

  private User winner;
}
