package headfirst.combining.ducks;

public interface QuackObserver {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
