package bakery;

/**
 * Create an order and print it
 */
public class Main {
    public static void main(String[] args) {
        // Create the order
        Order order = new Order();
        order.addCake(new VanillaCake());
        order.addCake(new ChocolateCake());

        // Print the order
        order.printOrder();
    }
}
