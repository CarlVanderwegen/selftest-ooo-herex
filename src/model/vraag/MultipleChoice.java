package model.vraag;

import model.DomainException;
import model.category.CategoryType;

public class MultipleChoice implements VraagType {
    String naam , description;
    //CategoryType category;
    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public String getDescription() {
        return description;
    }

//    @Override
//    public CategoryType getCategory() {
//        return category;
//    }


    @Override
    public void setNaam(String naam) {
        if (naam.trim().isEmpty())
            throw new DomainException("question name can't be empty");
        this.naam = naam;
    }

    @Override
    public void setDescription(String description) {
        if (description.trim().isEmpty())
            throw new DomainException("question description can't be empty");
        this.description = description;
    }

//    @Override
//    public void setCategory(CategoryType superCat) {
//        this.category = superCat;
//    }
}
