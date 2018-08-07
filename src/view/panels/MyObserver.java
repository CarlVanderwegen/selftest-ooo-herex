package view.panels;

import model.category.CategoryList;
import model.vraag.VragenLijst;


public interface MyObserver {
    public void update(CategoryList cat, VragenLijst vragen);

}
