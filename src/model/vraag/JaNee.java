package model.vraag;

import model.DomainException;
import model.category.CategoryType;

public class JaNee implements VraagType{
    String naam , description;
    CategoryType category;

    public JaNee(){

    }

    public JaNee(String naam, String description) {
        setNaam(naam);
        setDescription(description);
    }

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
//    public void setCategory(CategoryType category) {
//        this.category = category;
//    }
}
