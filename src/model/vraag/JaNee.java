package model.vraag;

import model.DomainException;

public class JaNee implements VraagType{
    String question, correctAnswer, feedback,otherAnswer;
    int score;


    public JaNee() {
    }

    public JaNee(String question, String correctAnswer, String otherAnswer, String feedback) {
        setQuestion(question);
        setCorrectAnswer(correctAnswer);
        setOtherAnswer(otherAnswer);
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

    public String getOtherAnswer() {
        return otherAnswer;
    }

    public void setOtherAnswer(String otherAnswer) {
        this.otherAnswer = otherAnswer;
    }
}
