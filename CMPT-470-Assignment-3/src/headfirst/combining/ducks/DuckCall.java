package headfirst.combining.ducks;

public class DuckCall implements Quackable {
	Observable observable;

	public DuckCall() {
		observable = new Observable(this);
	}

	public void quack() {
		System.out.println("Kwak");
		notifyObservers();
	}
	
	public void fly(){
		System.out.println("fly fly away");

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
		return "Duck Call";
	}
}
