package model;

import model.category.CategoryList;
import model.category.CategoryType;
import model.category.MainCategory;
import model.category.SubCategory;

public class SelftestFacade {

    private static final CategoryList catlist = new CategoryList();
    //private CategoryList catlist;


    public SelftestFacade() {
        catlist.add(new MainCategory("test 1", "the first one"));
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




}
