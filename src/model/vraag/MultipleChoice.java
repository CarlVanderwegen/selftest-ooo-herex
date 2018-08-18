package model.vraag;

import model.DomainException;

import java.util.ArrayList;

public class MultipleChoice implements VraagType {
    private String question, correctAnswer, feedback;
    private ArrayList<String> otherAnswers;

    public MultipleChoice() {
    }

    public MultipleChoice(String question, String correctAnswer, ArrayList<String> otherAnswers, String feedback) {
        setQuestion(question);
        setCorrectAnswer(correctAnswer);
        setOtherAnswers(otherAnswers);
        setFeedback(feedback);
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String getFeedback() {
        return feedback;
    }

    @Override
    public void setQuestion(String question) {
        if (question.trim().isEmpty())
            throw new DomainException("question can't be empty");
        this.question = question;
    }

    @Override
    public void setCorrectAnswer(String correctAnswer) {
        if (correctAnswer.trim().isEmpty())
            throw new DomainException("correct answer can't be empty");
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void setFeedback(String feedback) {
        if (feedback.trim().isEmpty())
            throw new DomainException("feedback can't be empty");
        this.feedback = feedback;
    }

    public ArrayList<String> getOtherAnswers() {
        return otherAnswers;
    }

    public void setOtherAnswers(ArrayList<String> otherAnswers) {
        this.otherAnswers = otherAnswers;
    }
}
