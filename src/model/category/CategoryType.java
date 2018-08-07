package model.category;

import model.vraag.VraagType;
import model.vraag.VragenLijst;

import java.util.ArrayList;

public interface CategoryType {
    String getNaam();
    String getDescription();
    VragenLijst getVragen();
    void setNaam(String naam);
    void setDescription(String description);
    void addVraag(VraagType vraag);

}
