package ru.skypro.examiner.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.examiner.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @PostConstruct
    public void setup() {
        questions.add(new Question("сколько будет 2+2?", "4"));
        questions.add(new Question("какие основные реализации интерфейса List ?", "ArrayList/LinkedList"));
        questions.add(new Question("В чем сила, брат?", "в кашке"));
        questions.add(new Question("сколько людей живет в Пензе ?", "492 376"));
    }

    @Override
    public Question add(String text, String answer) {
        return add (new Question(text, answer));
    }


    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        boolean isRemoved = questions.remove(question);
        return isRemoved ? question : null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }
}
