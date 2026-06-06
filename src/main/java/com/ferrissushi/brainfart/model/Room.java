package com.ferrissushi.brainfart.model;

import jakarta.persistence.*;
import java.time.Instant;
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
  @Id private String id;

  @Column(unique = true)
  private String title;

  @Column(name = "start_date")
  @Builder.Default
  private Instant startDate = Instant.now();

  @Column(name = "chrono_timing", nullable = false)
  @Builder.Default
  private Integer chronoTiming = 10;

  @ManyToOne
  @JoinColumn(name = "question_type_id")
  private QuestionType questionType;

  @Column(nullable = false)
  @Builder.Default
  private Boolean closed = false;

  @Column(name = "question_count", nullable = false)
  @Builder.Default
  private Integer questionCount = 10;

  @ManyToOne
  @JoinColumn(name = "opened_by_id")
  private User openedBy;

  @ManyToOne
  @JoinColumn(name = "winner_id")
  private User winner;
}
