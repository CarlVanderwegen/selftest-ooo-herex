package model.vraag;

public enum Vraagtypes {
    JANEE,
    MultipleChoice;

    public static VraagType GetVraagType(String s){
        VraagType ret = null;
        switch (Vraagtypes.valueOf(s.toUpperCase())) {
            case JANEE:
                ret =  new JaNee();
                break;
            case MultipleChoice:
                ret =  new MultipleChoice();
                break;
            default:
                break;
        }
        return ret;
    }
}
