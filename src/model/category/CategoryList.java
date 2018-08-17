package model.category;

import model.DomainException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class CategoryList {
    private ArrayList<CategoryType> catlist;

    public CategoryList() {
        this.catlist = new ArrayList<>();
        CategoryType cat1 = new MainCategory("cat1", "this is cat 1");
        System.out.println( "created cat list");
        catlist.add(cat1);
    }

    public ArrayList<CategoryType> getCatlist() {
        return catlist;
    }

    public void setCatlist(ArrayList<CategoryType> catlist) {
        this.catlist = catlist;
    }

    public void add(CategoryType cat){
        if (cat == null)
            throw new DomainException("category is non existant");
        else if (catlist.indexOf(cat) >0)
            throw new DomainException("category allready exsists");
        this.catlist.add(cat);
    }

    public CategoryType getCategory(String catnaam){
        for (CategoryType cat:catlist) {
            if (cat.getNaam().trim().toLowerCase() == catnaam.trim().toLowerCase())
                return cat;
        }
            throw new DomainException("there is no category by that name");
    }

    public void remove(String cat) {
        catlist.remove(cat);
    }
}
