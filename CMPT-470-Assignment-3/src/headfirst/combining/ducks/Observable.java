package headfirst.combining.ducks;

import java.util.ArrayList;

public class Observable {
    ArrayList<Observer> observers = new ArrayList<Observer>();
    QuackObserver duck;

    public Observable(QuackObserver duck) {
        this.duck = duck;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }
    }
}