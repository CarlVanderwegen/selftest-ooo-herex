package model.vraag;

public class VraagFactory {

    public static VraagType createVraagType(String vraagType){
        return Vraagtypes.getVraagType(vraagType);
    }
}
