package model.vraag;

import model.DomainException;
import model.category.CategoryType;

public class JaNee implements VraagType{
    String naam , description;
    CategoryType category;

    String question, correctAnswer, feedback,otherAnswer;

    public JaNee() {
    }

    public JaNee(String question, String correctAnswer, String otherAnswer, String feedback) {
        setQuestion(question);
        setCorrectAnswer(correctAnswer);
        setOtherAnswer(otherAnswer);
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

    public String getOtherAnswer() {
        return otherAnswer;
    }

    public void setOtherAnswer(String otherAnswer) {
        this.otherAnswer = otherAnswer;
    }
}
