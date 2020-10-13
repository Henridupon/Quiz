package com.quiz.controller;

import com.quiz.bean.question.Question;
import com.quiz.bean.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/quiz")
    Question getQuizQuestion(@RequestBody Question question) {
        List<Question> questionList = questionRepository.findByLanguageAndCategory(question.getLanguage(), question.getCategory());
        return questionList
                .get(new Random().nextInt(questionList.size()));

    }

}
