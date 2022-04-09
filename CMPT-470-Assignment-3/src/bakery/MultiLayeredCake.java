package bakery;

public class MultiLayeredCake extends CakeDecorator{
    public MultiLayeredCake(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return "Multi-layered " + super.getDescription();
    }

    @Override
    public int getCost() {
        return super.getCost() + 5;
    }
}
