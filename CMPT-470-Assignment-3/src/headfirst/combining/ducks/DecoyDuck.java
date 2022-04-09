package headfirst.combining.ducks;

public class DecoyDuck implements Quackable {
	Observable observable;

	public DecoyDuck() {
		observable = new Observable(this);
	}

	public void quack() {
		System.out.println("<< Silence >>");
		notifyObservers();
	}

	public void fly(){
		System.out.println("I am trying to fly away");

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
		return "Decoy Duck";
	}
}
