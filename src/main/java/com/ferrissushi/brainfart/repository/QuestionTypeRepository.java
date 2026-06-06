package com.ferrissushi.brainfart.repository;

import com.ferrissushi.brainfart.model.QuestionType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, String> {
  Optional<QuestionType> findByName(String name);
}
