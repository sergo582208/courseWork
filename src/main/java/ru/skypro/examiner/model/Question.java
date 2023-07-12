package ru.skypro.examiner.model;

import java.util.Objects;

public class Question {

    public String text;
    public String answer;

    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public Question() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(text, question.text) && Objects.equals(answer, question.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public void add(Question question) {
    }

    public Object remove(Question question) {
        return null;
    }

    public Object size() {
        return null;
    }

    public Question get(int randomIndex) {
        return null;
    }
}
