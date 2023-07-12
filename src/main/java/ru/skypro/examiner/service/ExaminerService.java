package ru.skypro.examiner.service;

import ru.skypro.examiner.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

    Collection<Question> getQuestion(int amount);
}
