package model.category;

import model.DomainException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class CategoryList {
    private static final ArrayList<CategoryType> catlist = new ArrayList<>();

    private CategoryList() {
    }

    public static ArrayList<CategoryType> getCatlist() {
        return catlist;
    }

    public void add(CategoryType cat){
        if (cat == null)
            throw new DomainException("category is non existant");
        else if (catlist.indexOf(cat) >0)
            throw new DomainException("category allready exsists");
        this.catlist.add(cat);
    }

    public static CategoryType getCategory(String catnaam){
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
