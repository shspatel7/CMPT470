package bakery;

public abstract class CakeDecorator  extends Cake implements CakeInterface{
    protected Cake cake;
    public CakeDecorator(Cake cake){
        this.cake = cake;
    }

    @Override
    public String getDescription() {
        return cake.getDescription();
    }

    @Override
    public int getCost() {
        return cake.getCost();
    }
}
