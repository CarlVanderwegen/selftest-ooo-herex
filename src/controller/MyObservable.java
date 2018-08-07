package controller;

import view.panels.MyObserver;

public interface MyObservable {
    void registerObserver(MyObserver observer);
    void removeObserver(MyObserver observer);
    void notifyObserver(MyObserver observer);
    void notifyAllObservers();
    void notifyTotalScoreObservers();
    void resetObservers();
}

