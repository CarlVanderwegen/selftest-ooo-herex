package model.category;

import model.DomainException;
import model.vraag.VraagType;
import model.vraag.VragenLijst;

public class SubCategory implements CategoryType {
    private String naam , description;
    private CategoryType superCat;
    private VragenLijst vraagLijst;

    public SubCategory(String naam, String description, CategoryType superCat) {
        setNaam(naam);
        setDescription(description);
        setSuperCat(superCat);
        this.vraagLijst = new VragenLijst();
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public VragenLijst getVragen() {
        return vraagLijst;
    }

    public CategoryType getSuperCat() {
        return superCat;
    }


    @Override
    public void setNaam(String naam) {
        if (naam.trim().isEmpty())
            throw new DomainException("catagory name can't be empty");
        this.naam = naam;
    }

    @Override
    public void setDescription(String description) {
        if (description.trim().isEmpty())
            throw new DomainException("catagory description can't be empty");
        this.description = description;
    }

    @Override
    public void addVraag(VraagType vraag) {
        vraagLijst.add(vraag);

    }

    public void setSuperCat(CategoryType superCat) {
        this.superCat = superCat;
    }
}
