package com.ferrissushi.brainfart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ferrissushi.brainfart.model.QuestionType;
import com.ferrissushi.brainfart.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    Optional<Room> findById(Integer id);

    long countByQuestionType(QuestionType questionType);
}
