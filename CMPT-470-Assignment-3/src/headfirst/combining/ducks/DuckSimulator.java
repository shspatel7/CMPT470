package headfirst.combining.ducks;

public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}
  
	void simulate() {
		Quackable mallardDuck = new MallardDuck();
		Quackable redheadDuck = new RedheadDuck();
		Quackable duckCall = new DuckCall();
		Quackable rubberDuck = new RubberDuck();
 
		System.out.println("\nDuck Simulator");
 
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);

		System.out.println("\nThe duck simulator with Observer.");
		ObserverSimulator observerSimulator = new ObserverSimulator();
		Observable observable1 = new Observable(mallardDuck);
		observable1.registerObserver(observerSimulator);
		observable1.notifyObservers();
		Observable observable2 = new Observable(redheadDuck);
		observable2.registerObserver(observerSimulator);
		observable2.notifyObservers();
		Observable observable3 = new Observable(duckCall);
		observable3.registerObserver(observerSimulator);
		observable3.notifyObservers();
		Observable observable4 = new Observable(rubberDuck);
		observable4.registerObserver(observerSimulator);
		observable4.notifyObservers();
	}
   
	void simulate(Quackable duck) {
		duck.quack();
	}
}
