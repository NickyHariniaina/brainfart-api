package com.ferrissushi.brainfart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "\"user\"")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(generator = "uuid2")
  private String id;

  @Column(nullable = false)
  private String name;

  @NotBlank private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  @Builder.Default
  private Boolean emailVerified = false;

  private String image;

  private Boolean banned;

  @Column(name = "ban_reason")
  private String banReason;

  @Column(name = "ban_expires")
  private String banExpires;

  private Integer rank;

  @Builder.Default
  @Column(nullable = false, name = "current_score")
  private Integer currentScore = 0;

  @Column(name = "display_username")
  private String displayUsername;

  @CreationTimestamp
  @Column(nullable = false, updatable = false, name = "created_at")
  private Instant createdAt;

  @UpdateTimestamp
  @Column(nullable = false, name = "updated_at")
  private Instant updatedAt;

  @Enumerated(EnumType.STRING)
  @JdbcTypeCode(SqlTypes.NAMED_ENUM)
  private Role role;

  public enum Role {
    ADMIN,
    USER
  }
}
