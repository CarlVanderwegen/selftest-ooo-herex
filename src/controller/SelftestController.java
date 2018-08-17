package controller;

import model.SelftestFacade;
import view.panels.MyObserver;

import java.util.ArrayList;

public class SelftestController implements MyObservable {

    private ArrayList<MyObserver> observers;
    public SelftestFacade facade = new SelftestFacade();

    // observer code
    public SelftestController() {
        observers = new ArrayList<MyObserver>();
    }

    @Override
    public void registerObserver(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MyObserver observer) {
        if (observers.indexOf(observer)>=0)
            observers.remove(observers.indexOf(observer));
    }

    @Override
    public void notifyObserver() {
        for (MyObserver observer:observers) {
            observer.update(facade.getCatlist());
        }
    }

// rest









}
