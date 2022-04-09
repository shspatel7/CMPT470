package headfirst.combining.ducks;

public class RubberDuck implements Quackable {
	Observable observable;

	public RubberDuck() {
		observable = new Observable(this);
	}

	public void quack() {
		System.out.println("Squeak");
		notifyObservers();
	}
	
	public void fly(){
		System.out.println("I am rubber I can't fly");
	}

	@Override
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		observable.notifyObservers();
	}

	public String toString() {
		return "Rubber Duck";
	}
}
