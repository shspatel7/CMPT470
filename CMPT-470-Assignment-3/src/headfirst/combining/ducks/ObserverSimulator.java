package headfirst.combining.ducks;

public class ObserverSimulator implements Observer{
    @Override
    public void update(QuackObserver duck) {
        System.out.println(duck.toString() + " just quacked.");
    }

    public String toString() {
        return "ObserverSimulator";
    }
}
