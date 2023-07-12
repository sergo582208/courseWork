package ru.skypro.examiner.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.examiner.exception.notEnoughQuestionsInStorage;
import ru.skypro.examiner.model.Question;
import ru.skypro.examiner.service.ExaminerService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public abstract class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        if(amount>questionService.getAll().size()){
throw new notEnoughQuestionsInStorage();
        }

        Set<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
