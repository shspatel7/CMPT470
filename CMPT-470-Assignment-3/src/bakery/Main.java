package bakery;

/**
 * Create an order and print it
 */
public class Main {
    public static void main(String[] args) {
        // Create the order
        Order order = new Order();
        order.addCake(new ChocolateCake());
        order.addCake(new VanillaCake());
        order.addCake(new SprinklerCake(new VanillaCake(), 1));
        order.addCake(new MultiLayeredCake(new SprinklerCake(new StrawberryCake(), 2)));

        // Print the order
        order.printOrder();
    }
}
