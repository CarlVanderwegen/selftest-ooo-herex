package model.vraag;

public enum Vraagtypes {
    JANEE,
    MULTIPLECHOICE;

    public static VraagType getVraagType(String s){
        VraagType ret = null;
        switch (Vraagtypes.valueOf(s.toUpperCase())) {
            case JANEE:
                ret =  new JaNee();
                break;
            case MULTIPLECHOICE:
                ret =  new MultipleChoice();
                break;
            default:
                break;
        }
        return ret;
    }
}
