package com.quiz.controller;

import com.quiz.bean.question.Question;
import com.quiz.bean.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    @PostMapping("/questions")
    void addQuestion(@RequestBody Question question) {
        questionRepository.save(question);
    }
}
