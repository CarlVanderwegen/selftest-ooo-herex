package model.vraag;

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
    public void addVraag(VraagType vraag){
        vraaagLijst.add(vraag);
    }

}
