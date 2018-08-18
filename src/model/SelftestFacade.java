package model;

import model.category.CategoryList;
import model.category.CategoryType;
import model.category.MainCategory;
import model.category.SubCategory;
import model.vraag.JaNee;
import model.vraag.MultipleChoice;
import model.vraag.VraagFactory;
import model.vraag.VraagType;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class SelftestFacade {

    private String evalMode;
    //private CategoryList catlist;


    public SelftestFacade() {
        CategoryType bla = new MainCategory("test 1", "the first one");
        bla.addVraag(new JaNee("in the monty hall problem, should you change after you chose?", "yes","no", "it's 66% chance that it's correct, not 50% "));
        getCatlist().add(bla);
        CategoryType cat1 = new MainCategory("cat1", "this is cat 1");
        System.out.println( "created cat list");
        getCatlist().add(cat1);

        readPropertysFile();
    }


    public ArrayList<CategoryType> getCatlist() {
        return CategoryList.getCatlist();
    }

    public CategoryType getCategory(String naam){
        return CategoryList.getCategory(naam);
    }

    public void addCategory (CategoryType cat){
        getCatlist().add(cat);
    }

    public void addCategory (String naam, String description, String maincat){
        if (maincat.trim().length() == 0)
            getCatlist().add(new MainCategory(naam, description));
        else
        getCatlist().add(new SubCategory(naam, description, getCategory(maincat)));
    }

    public  void removeCategory(String cat) {
        getCatlist().remove(cat);
    }

    public ArrayList<VraagType> getVragen(){
        ArrayList<VraagType> vl = new ArrayList<>();
        for (CategoryType ct: getCatlist()) {
            vl.addAll(ct.getVragen().getVraaagLijst());
        }
        return vl;
    }

    public void addVraag(String category, String question, String correctAnswer, String wrongAnswers, String feedback ){
        if (wrongAnswers.trim().length()>0){
            ArrayList<String> other = new ArrayList( Arrays.asList(wrongAnswers.split("\\r?\\n") ) );
            if (other.size()==1){
                VraagType vraag = VraagFactory.createVraagType("janee");
                vraag.setQuestion(question);
                vraag.setFeedback(feedback);
                vraag.setCorrectAnswer(correctAnswer);
                JaNee jnvraag = (JaNee) vraag;
                jnvraag.setOtherAnswer(wrongAnswers);
                this.getCategory(category).addVraag(jnvraag);
            }else {
                VraagType vraag = VraagFactory.createVraagType("multiplechoice");
                MultipleChoice mVraag = (MultipleChoice)vraag;
                mVraag.setQuestion(question);
                mVraag.setCorrectAnswer(correctAnswer);
                mVraag.setOtherAnswers(other);
                mVraag.setFeedback(feedback);
                this.getCategory(category).addVraag(mVraag);
            }
        }else {
            throw new DomainException("other answers were empty");
        }
    }




    private void readPropertysFile(){
        try {
            Properties properties = new Properties();
            InputStream is = new FileInputStream("src\\app\\evaluation.properties");
            properties.load(is);
            this.evalMode = properties.getProperty("evaluaiton.score");
            System.out.println(evalMode);
            is.close();
        }catch (Exception e){
            System.out.println("couldn't load the properties buddy cause: " + e.getMessage());
        }


    }

}
