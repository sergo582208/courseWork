package ru.skypro.examiner.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.examiner.exception.notEnoughQuestionsInStorage;
import ru.skypro.examiner.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowExceptionsWhenAmountMoreThenAvailableQuestions(){
//given
        int amount = 5;
        when(questionService.getAll()).thenReturn(Collections.emptyList());

        //then
        notEnoughQuestionsInStorage t = Assertions.assertThrows(notEnoughQuestionsInStorage.class, () -> {
            examinerService.getQuestion(amount);
        });
    }
    @Test
    public void shouldSuccessfulGenerateRandomQuestion(){
        //given
        List<Question>questions = new ArrayList<>();
        questions.add(new Question("сколько будет 2+2?", "4"));
        questions.add(new Question("какие основные реализации интерфейса List ?", "ArrayList/LinkedList"));
        questions.add(new Question("В чем сила, брат?", "в кашке"));
        questions.add(new Question("сколько людей живет в Пензе ?", "492 376"));
        int amount = 3;
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(1),
                questions.get(2)
        );
        //when
        Collection<Question> questions1 = examinerService.getQuestions(amount);
        //then
        Assertions.assertEquals(amount, questions1.size());
        Assertions.assertTrue(questions1.contains(questions.get(0)));
        Assertions.assertTrue(questions1.contains(questions.get(1)));
        Assertions.assertTrue(questions1.contains(questions.get(2)));
        verify(questionService, times(4)).getRandomQuestion();
    }
}
