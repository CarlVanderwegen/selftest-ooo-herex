package model.category;

import model.DomainException;
import model.vraag.VraagType;
import model.vraag.VragenLijst;

public class MainCategory implements CategoryType{
    private String naam , description;
    private VragenLijst vragenLijst;

    public MainCategory(String naam, String description) {
        this.naam = naam;
        this.description = description;
        this.vragenLijst = new VragenLijst();
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
        return vragenLijst;
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
        vragenLijst.addVraag(vraag);
    }
}
