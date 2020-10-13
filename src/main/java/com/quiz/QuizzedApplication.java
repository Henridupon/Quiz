package com.quiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import com.quiz.bean.question.Answer;
import com.quiz.bean.question.Question;
import com.quiz.bean.question.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.quiz.bean.user.User;
import com.quiz.bean.user.UserRepository;

@SpringBootApplication
public class QuizzedApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizzedApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    Question init2(QuestionRepository questionRepository) {

        Question question1 = new Question("what was the name of the first American president?",
                new Answer("George Washington"),
                Arrays.asList(new Answer("Abraham Lincon"), new Answer("Adam Smith")),
                Question.Category.HISTORY,
                Question.Language.EN
        );

        Question question2 = new Question("How long did the Vietnam war last?",
                new Answer("20 years"),
                Arrays.asList(new Answer("10 years"), new Answer("30 years")),
                Question.Category.HISTORY,
                Question.Language.EN
        );

        Question question3 = new Question("Wat is 'leeg blad' in het Latijn?",
                new Answer("Tabula Rasa"),
                Arrays.asList( new Answer("Blanco"),new Answer("White rasa")),
                Question.Category.HISTORY,
                Question.Language.NL
        );

        questionRepository.save(question1);
        questionRepository.save(question2);

        return question1;
    }

}