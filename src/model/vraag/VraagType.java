package model.vraag;



public interface VraagType {

    String getQuestion();
    String getCorrectAnswer();
    String getFeedback();

    void setQuestion(String question);
    void setCorrectAnswer(String correctAnswer);
    void setFeedback(String feedback);



}