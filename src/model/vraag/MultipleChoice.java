package model.vraag;

import model.DomainException;

import java.util.ArrayList;

public class MultipleChoice implements VraagType {
    private String question, correctAnswer, feedback;
    private ArrayList<String> otherAnswers;
    int score;

    public MultipleChoice() {
    }

    public MultipleChoice(String question, String correctAnswer, ArrayList<String> otherAnswers, String feedback) {
        setQuestion(question);
        setCorrectAnswer(correctAnswer);
        setOtherAnswers(otherAnswers);
        setFeedback(feedback);
        score = -1;
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
    public int getScore() {
        return score;
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

    @Override
    public void isCorrect(String answer ) {
        if (this.getCorrectAnswer()==answer)
            score = 1;
        else
            score=0;
    }

    public ArrayList<String> getOtherAnswers() {
        return otherAnswers;
    }

    public void setOtherAnswers(ArrayList<String> otherAnswers) {
        this.otherAnswers = otherAnswers;
    }
}
