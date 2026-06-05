package com.ferrissushi.brainfart.repository;

import com.ferrissushi.brainfart.model.QuestionType;
import com.ferrissushi.brainfart.model.Room;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
  Optional<Room> findById(String id);

  long countByQuestionType(QuestionType questionType);
}
