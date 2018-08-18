package model.vraag;

import model.DomainException;

import java.util.ArrayList;

public class VragenLijst {
    ArrayList<VraagType> vraaagLijst;

    public VragenLijst() {
        this.vraaagLijst = new ArrayList<>();
    }

    public ArrayList<VraagType> getVraaagLijst() {
        return vraaagLijst;
    }

    public void setVraaagLijst(ArrayList<VraagType> vraaagLijst) {
        this.vraaagLijst = vraaagLijst;
    }

    public void add(VraagType cat){
        if (cat == null)
            throw new DomainException("category is non existant");
        else if (vraaagLijst.indexOf(cat) >0)
            throw new DomainException("category allready exsists");
        this.vraaagLijst.add(cat);
    }

    public VraagType getVraag(String catnaam){
        for (VraagType cat:vraaagLijst) {
            if (cat.getNaam().trim().toLowerCase() == catnaam.trim().toLowerCase())
                return cat;
        }
        throw new DomainException("there is no category by that name");
    }

}
