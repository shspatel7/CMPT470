package bakery;

public class SprinklerCake extends CakeDecorator{
    int sprinklerQuantity;
    public SprinklerCake(Cake cake, int quantity) {
        super(cake);
        this.sprinklerQuantity = quantity;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with "+ sprinklerQuantity + " sprinkles";
    }

    @Override
    public int getCost() {
        return super.getCost() + sprinklerQuantity * 2;
    }
}
