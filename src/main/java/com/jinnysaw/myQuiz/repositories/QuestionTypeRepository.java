package com.jinnysaw.myQuiz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.models.QuestionType;

@Repository
public interface QuestionTypeRepository extends CrudRepository<QuestionType,Long>{

}
