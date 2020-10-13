package com.quiz.bean.question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findByLanguageAndCategory(Question.Language language, Question.Category category);
    List<Question> findByLanguage(Question.Language language);
    List<Question> findByCategory(Question.Category category);
}
