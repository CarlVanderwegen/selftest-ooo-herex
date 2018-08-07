package model;

import model.category.CategoryList;
import model.category.CategoryType;
import model.category.MainCategory;

public class SelftestFacade {

    private CategoryList catlist;


    public SelftestFacade() {
        this.catlist = new CategoryList();
        catlist.add(new MainCategory("test 1", "the first one"));
    }


    public CategoryList getCatlist() {
        return catlist;
    }

    public void setCatlist(CategoryList catlist) {
        this.catlist = catlist;
    }

    public void addCategory (CategoryType cat){
        this.catlist.add(cat);
    }
    public  void removeCategory(String cat) {
        this.catlist.remove(cat);
    }




}
