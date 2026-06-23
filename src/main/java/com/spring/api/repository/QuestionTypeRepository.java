package com.spring.api.repository;

import com.spring.api.model.QuestionType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, String> {
  Optional<QuestionType> findByName(String name);
}
