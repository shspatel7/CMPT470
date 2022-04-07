package headfirst.combining.ducks;

public class DecoyDuck implements Quackable {
	public void quack() {
		System.out.println("<< Silence >>");
	}
	
	public void fly(){
		System.out.println("I am trying to fly away");

	}
}
