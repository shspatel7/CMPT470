package bakery;

public class StrawberryCake extends Cake {

    @Override
    public String getDescription() {
        return "Strawberry Cake";
    }

    @Override
    public int getCost() {
        return super.getCost()*2;
    }
}
