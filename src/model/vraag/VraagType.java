package model.vraag;

import model.category.CategoryType;

public interface VraagType {


    String getNaam();
    String getDescription();
    //CategoryType getCategory();

    void setNaam(String naam);
    void setDescription(String description);
    //void setCategory(CategoryType category);
}