package controller;

import model.SelftestFacade;
import java.util.Observable;

public class SelftestController extends Observable {

    public final SelftestFacade facade = new SelftestFacade();

    public void changedParams() {
        setChanged();
        notifyObservers();
    }


}
