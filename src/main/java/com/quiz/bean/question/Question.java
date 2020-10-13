package com.quiz.bean.question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String question;

    @OneToOne(cascade = CascadeType.ALL)
    private Answer rightAnswer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> wrongAnswer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();

    private Category category;
    private Language language;

    public enum Language {EN, NL}
    public enum Category {HISTORY}

    public Question() {}

    public Question(String question, Answer rightAnswer, List<Answer> wrongAnswer, Category category, Language language) {
        this.question = question;

        this.rightAnswer = rightAnswer;
        this.wrongAnswer = wrongAnswer;

        this.answers.add(rightAnswer);
        this.answers.addAll(wrongAnswer);
        // shuffle the list with answers
        Collections.shuffle(this.answers);

        this.category = category;
        this.language = language;
    }

    public Question(Category category, Language language) {
        this.category = category;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Answer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<Answer> getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(List<Answer> wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", rightAnswer=" + rightAnswer +
                ", category=" + category +
                ", language=" + language +
                '}';
    }
}
