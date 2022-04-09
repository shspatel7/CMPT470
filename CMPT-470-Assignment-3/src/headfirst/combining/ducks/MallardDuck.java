package headfirst.combining.ducks;

public class MallardDuck implements Quackable {
	Observable observable;

	public MallardDuck() {
		observable = new Observable(this);
	}

	public void quack() {
		System.out.println("Quack");
		notifyObservers();
	}
	
	public void fly(){
		System.out.println("I am flying");

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
		return "Mallard Duck";
	}
}
