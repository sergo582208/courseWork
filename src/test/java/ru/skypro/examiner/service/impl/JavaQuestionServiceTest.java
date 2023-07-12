package ru.skypro.examiner.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.skypro.examiner.model.Question;

public class JavaQuestionServiceTest {
    private final QuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void shouldRemoveExistedQuestionAndReturnIt(){
//given
        Question question = new Question("text", "answer");
        javaQuestionService.add(question);
        //when
        Question removedQuestions = javaQuestionService.remove(question);
        //then
        Assertions.assertEquals(question, removedQuestions);
    }
    @Test
    public void shouldRemoveNonExistedQuestionAndReturnNull(){
//given
        Question question = new Question("text", "answer");
        javaQuestionService.add(question);
        //when
        Question removedQuestions = javaQuestionService.remove(question);
        //then
        Assertions.assertNull(removedQuestions);
    }
}
