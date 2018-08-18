package model;

import model.category.CategoryList;
import model.category.CategoryType;
import model.category.MainCategory;
import model.category.SubCategory;
import model.vraag.JaNee;
import model.vraag.VraagType;
import model.vraag.VragenLijst;

import java.util.ArrayList;

public class SelftestFacade {

    private static final CategoryList catlist = new CategoryList();
    //private CategoryList catlist;


    public SelftestFacade() {
        CategoryType bla = new MainCategory("test 1", "the first one");
        bla.addVraag(new JaNee("monty", "change after you chose?"));
        catlist.add(bla);

    }


    public static CategoryList getCatlist() {
        return catlist;
    }

    public void addCategory (CategoryType cat){
        this.catlist.add(cat);
    }

    public void addCategory (String naam, String description, String maincat){
        if (maincat.trim().length() == 0)
            catlist.add(new MainCategory(naam, description));
        else
        this.catlist.add(new SubCategory(naam, description, catlist.getCategory(maincat)));
    }

    public  void removeCategory(String cat) {
        this.catlist.remove(cat);
    }

    public ArrayList<VraagType> getVragen(){
        ArrayList<VraagType> vl = new ArrayList<>();
        for (CategoryType ct: catlist.getCatlist()) {
            vl.addAll(ct.getVragen().getVraaagLijst());
        }
        return vl;
    }




}
