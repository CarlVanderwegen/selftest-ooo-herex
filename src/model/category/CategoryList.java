package model.category;

import model.DomainException;

import java.util.HashMap;

public class CategoryList {
    private HashMap<String, CategoryType> catlist;

    public CategoryList() {
        this.catlist = new HashMap();
    }

    public HashMap<String, CategoryType> getCatlist() {
        return catlist;
    }

    public void setCatlist(HashMap<String, CategoryType> catlist) {
        this.catlist = catlist;
    }

    public void add(CategoryType cat){
        if (cat == null)
            throw new DomainException("category is non existant");
        else if (catlist.get(cat.getNaam())!=null)
            throw new DomainException("category allready exsists");
        this.catlist.put(cat.getNaam(), cat);
    }
    public CategoryType getCategory(String catnaam){
        try{
            return this.catlist.get(catnaam);
        }catch (Error e){
            throw new DomainException("there is no category by that name");
        }
    }

    public void remove(String cat) {
        catlist.remove(cat);
    }
}
