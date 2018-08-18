package model;

import model.category.CategoryList;
import model.category.CategoryType;
import model.category.MainCategory;
import model.category.SubCategory;
import model.vraag.JaNee;
import model.vraag.VraagFactory;
import model.vraag.VraagType;
import model.vraag.VragenLijst;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
        VraagType vraag = VraagFactory.createVraagType("multiplechoice");
        vraag.setCorrectAnswer(correctAnswer);
        vraag.setFeedback(feedback);
        this.getCategory(category).addVraag(vraag);
    }




    private void readPropertysFile(){
        try {
            Properties properties = new Properties();
            InputStream is = new FileInputStream("evaluation.properties");
            properties.load(is);
            this.evalMode = properties.getProperty("evaluaiton.score");
            is.close();
        }catch (Exception e){
            System.out.println("couldn't load the properties buddy");
        }


    }

}
